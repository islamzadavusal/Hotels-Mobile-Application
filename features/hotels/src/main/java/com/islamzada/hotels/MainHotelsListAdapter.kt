package com.islamzada.hotels

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        differ.currentList.getOrNull(position)?.let {
            holder.bind(it)
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


class MainListViewHolder(private val binding : HotelListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(model: HotelUIModel){

        binding.txtTitle.text = model.name
        binding.txtAddress.text = model.address
        binding.txtCity.text = "${model.city}  -  ${model.country}"
        binding.txtStartRating.text = "${model.starRating}, ${model.reviewScore}"
        binding.txtNear.text = "${model.cityCenterPointDistanceName}  -  ${model.cityCenterPointDistance}"


                val url = model.thumbnailImage.replace("/0x0", "")
                Glide.with(binding.root).load(url).into(binding.imageView)

    }
}