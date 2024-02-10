package com.islamzada.hotels

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.islamzada.entities.uimodel.HotelUIModel
import com.islamzada.hotels.databinding.HotelListItemBinding

class MainHotelsListAdapter : RecyclerView.Adapter<MainListViewHolder>() {

    private val differ = AsyncListDiffer(this, differCallBack)

    fun setData(items: List<HotelUIModel>){
        differ.submitList(items)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bind = HotelListItemBinding.inflate(inflater,parent,false)

        return MainListViewHolder(bind)

    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid
        differ.currentList.getOrNull(position)?.let {
            holder.bind(it, currentUserUid)
        }
    }



    companion object {
        private val differCallBack = object : DiffUtil.ItemCallback<HotelUIModel>(){
            override fun areItemsTheSame(oldItem: HotelUIModel, newItem: HotelUIModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HotelUIModel, newItem: HotelUIModel): Boolean {
                return oldItem == newItem
            }

        }
    }


}


class MainListViewHolder(private val binding: HotelListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(model: HotelUIModel, currentUserUid: String?) {

        binding.txtTitle.text = model.name
        binding.txtAddress.text = model.address
        binding.txtPrice.text = "${model.price} ₺"
        binding.txtCity.text = "${model.city} ,  ${model.country}"
        binding.txtStartRating.text = "${model.reviewScore}".replace(".", ",")
        binding.txtNear.text = "merkezine ${model.cityCenterPointDistance} km"

        val reviewScore = model.reviewScore
        val result = when (reviewScore) {
            in 0.0..3.99 -> binding.root.context.getString(R.string.bad)
            in 4.0..7.99 -> binding.root.context.getString(R.string.middle)
            in 8.0..10.0 -> binding.root.context.getString(R.string.perfect)
            else -> ""
        }
        binding.txtResult.text = result

        val url = model.thumbnailImage.replace("/0x0", "")
        Glide.with(binding.root).load(url).into(binding.imageView)


            // ADD DATA TO FIREBASE

        binding.imageButtonFav.setOnClickListener {

            val db = Firebase.firestore

            val data = hashMapOf(
                "id" to model.id,
                "name" to model.name,
                "result" to result,
                "address" to model.address,
                "city" to model.city,
                "country" to model.country,
                "reviewScore" to model.reviewScore,
                "cityCenterPointDistance" to model.cityCenterPointDistance,
                "thumbnailImage" to model.thumbnailImage,
                "price" to model.price
            )

            val currentUserUID = FirebaseAuth.getInstance().currentUser?.uid

            currentUserUID?.let { uid ->
                db.collection("users").document(uid)
                    .collection("currentUser")
                    .add(data)

                    .addOnSuccessListener {
                        Log.d(TAG, "Success")
                        Toast.makeText(binding.root.context,
                            binding.root.context.getString(R.string.add_to_fav), Toast.LENGTH_SHORT).show()

                    }

                    .addOnFailureListener { exception ->
                        Log.w(TAG, "Error", exception)
                    }
            }
        }
    }
}