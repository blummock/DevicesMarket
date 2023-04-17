package com.example.base_screen.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.base_screen.databinding.HotSalesCardBinding
import com.example.core.data.HomeStoreEntity
import com.squareup.picasso.Picasso

class HotSalesListAdapter : ListAdapter<HomeStoreEntity, ProductHolder>(object :
    DiffUtil.ItemCallback<HomeStoreEntity>() {

    override fun areItemsTheSame(oldItem: HomeStoreEntity, newItem: HomeStoreEntity) =
        oldItem == newItem

    override fun areContentsTheSame(
        oldItem: HomeStoreEntity,
        newItem: HomeStoreEntity
    ) =
        oldItem.id == newItem.id
}) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder =
        ProductHolder(
            HotSalesCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ProductHolder(private val binding: HotSalesCardBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HomeStoreEntity) {
        binding.run {
            hotSalesTitle.text = item.title
            hotSalesSub.text = item.subtitle
            newIcon.visibility = if (item.isNew == true) View.VISIBLE else View.INVISIBLE
            byNowButton.visibility = if (item.isBy) View.VISIBLE else View.INVISIBLE
            Picasso.get()
                .load(item.picture)
                .into(hotSalesImage)
        }
    }
}