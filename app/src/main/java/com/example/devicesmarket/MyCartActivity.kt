package com.example.devicesmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.devicesmarket.databinding.ActivityMyCartBinding
import com.example.devicesmarket.databinding.ItemCardBinding

class MyCartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = CartItemsAdapter()
        binding.itemsRecycler.adapter = adapter
        adapter.submitList(arrayListOf(
            com.example.core.DeviceItem("Samsung S9", "$500", "$600", 1),
            com.example.core.DeviceItem("Xiaomi Mi5", "$300", "$400", 1),
            com.example.core.DeviceItem("Iphone XS 256", "$1500", "$1650", 1),
            com.example.core.DeviceItem("Samsung A9", "$200", "$320", 1),
        ))
    }

    inner class CartItemHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(deviceItem: com.example.core.DeviceItem) {
            binding.itemName.text = deviceItem.brand
            binding.itemPrice.text = deviceItem.price
        }
    }

    inner class CartItemsAdapter :
        ListAdapter<com.example.core.DeviceItem, CartItemHolder>(object : DiffUtil.ItemCallback<com.example.core.DeviceItem>() {

            override fun areItemsTheSame(oldItem: com.example.core.DeviceItem, newItem: com.example.core.DeviceItem) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: com.example.core.DeviceItem, newItem: com.example.core.DeviceItem) =
                oldItem.brand == newItem.brand
        }) {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemHolder =
            CartItemHolder(
                ItemCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        override fun onBindViewHolder(holder: CartItemHolder, position: Int) {
            holder.bind(getItem(position))
        }
    }
}