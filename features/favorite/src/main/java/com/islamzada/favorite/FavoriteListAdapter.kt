package com.islamzada.favorite

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.islamzada.entities.model.FavoriteData
import com.islamzada.favorite.databinding.FavListItemBinding

class FavoriteListAdapter : RecyclerView.Adapter<FavListViewHolder>() {

    private val differ = AsyncListDiffer(this, differCallBack)

    fun setData(items: List<FavoriteData>){
        differ.submitList(items)
    }

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
        private val differCallBack = object : DiffUtil.ItemCallback<FavoriteData>(){
            override fun areItemsTheSame(oldItem: FavoriteData, newItem: FavoriteData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FavoriteData, newItem: FavoriteData): Boolean {
                return oldItem == newItem
            }
        }
    }
}


class FavListViewHolder(private val binding: FavListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(model: FavoriteData) {
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

