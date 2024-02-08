package com.islamzada.favorite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.islamzada.entities.uimodel.HotelUIModel
import com.islamzada.favorite.databinding.FavListItemBinding

class FavoriteListAdapter : RecyclerView.Adapter<FavListViewHolder>() {

    private val differ = AsyncListDiffer(this, differCallBack)


    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bind = FavListItemBinding.inflate(inflater,parent,false)

        return FavListViewHolder(bind)

    }

    override fun onBindViewHolder(holder: FavListViewHolder, position: Int) {
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


class FavListViewHolder(private val binding: FavListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(model: HotelUIModel) {
        binding.apply {
            txtTitle.text = model.name
            txtAddress.text = model.address
            txtCity.text = "${model.city} - ${model.country}"
            txtStartRating.text = "${model.starRating}, ${model.reviewScore}"
            txtNear.text = "${model.cityCenterPointDistanceName} - ${model.cityCenterPointDistance}"

            val url = model.thumbnailImage.replace("/0x0", "")
            Glide.with(binding.root).load(url).into(binding.imageView)

        }

    }
}

