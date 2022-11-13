package com.example.mycart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.di.ActivityWithAppComponent
import com.example.core.navigation.Navigation
import com.example.mycart.databinding.ActivityMyCartBinding
import com.example.mycart.databinding.CartItemCardBinding
import javax.inject.Inject

class MyCartActivity : ActivityWithAppComponent() {

    @Inject lateinit var navigation: Navigation

    private lateinit var binding: ActivityMyCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DaggerMyCartActivityComponent.builder().abstractAppComponent(appComponent).build().inject(this)
        val adapter = CartItemsAdapter()
        binding.itemsRecycler.adapter = adapter
        adapter.submitList(
            arrayListOf(
                com.example.core.DeviceItem("Samsung S9", "$500", "$600", 1),
                com.example.core.DeviceItem("Xiaomi Mi5", "$300", "$400", 1),
                com.example.core.DeviceItem("Iphone XS 256", "$1500", "$1650", 1),
                com.example.core.DeviceItem("Samsung A9", "$200", "$320", 1),
            )
        )
    }

    inner class CartItemHolder(private val binding: CartItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(deviceItem: com.example.core.DeviceItem) {
            binding.itemName.text = deviceItem.brand
            binding.itemPrice.text = deviceItem.price
        }
    }

    inner class CartItemsAdapter :
        ListAdapter<com.example.core.DeviceItem, CartItemHolder>(object :
            DiffUtil.ItemCallback<com.example.core.DeviceItem>() {

            override fun areItemsTheSame(oldItem: com.example.core.DeviceItem, newItem: com.example.core.DeviceItem) =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: com.example.core.DeviceItem,
                newItem: com.example.core.DeviceItem
            ) =
                oldItem.brand == newItem.brand
        }) {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemHolder =
            CartItemHolder(
                CartItemCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        override fun onBindViewHolder(holder: CartItemHolder, position: Int) {
            holder.bind(getItem(position))
        }
    }

    override fun onBackPressed() {
        navigation.toMainActivity(this)
    }

}