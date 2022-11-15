package com.example.mycart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.data.BasketItemEntity
import com.example.core.di.ActivityWithAppComponent
import com.example.core.di.ViewModelFactory
import com.example.core.navigation.Navigation
import com.example.mycart.databinding.ActivityMyCartBinding
import com.example.mycart.databinding.CartItemCardBinding
import javax.inject.Inject

class MyCartActivity : ActivityWithAppComponent() {

    @Inject
    lateinit var navigation: Navigation

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<MyCartViewModel> {
        viewModelFactory
    }

    private lateinit var binding: ActivityMyCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DaggerMyCartActivityComponent.builder().abstractAppComponent(appComponent).build().inject(this)
        val adapter = CartItemsAdapter()
        binding.itemsRecycler.adapter = adapter
        viewModel.basketList.observe(this) {
            adapter.submitList(it.basket)
        }
    }

    inner class CartItemHolder(private val binding: CartItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BasketItemEntity) {
            binding.itemName.text = item.title
            binding.itemPrice.text = item.price.toString()
        }
    }

    inner class CartItemsAdapter : ListAdapter<BasketItemEntity, CartItemHolder>(object :
        DiffUtil.ItemCallback<BasketItemEntity>() {

        override fun areItemsTheSame(oldItem: BasketItemEntity, newItem: BasketItemEntity) =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: BasketItemEntity,
            newItem: BasketItemEntity
        ) = oldItem.id == newItem.id
    }
    ) {


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