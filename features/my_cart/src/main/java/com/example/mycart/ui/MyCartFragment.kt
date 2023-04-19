package com.example.mycart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.AbstractFragment
import com.example.core.data.BasketItemEntity
import com.example.core.di.ViewModelFactory
import com.example.core.navigation.Navigation
import com.example.mycart.databinding.CartItemCardBinding
import com.example.mycart.databinding.MyCartFragmentBinding
import com.example.mycart.di.DaggerMyCartComponent
import com.squareup.picasso.Picasso
import javax.inject.Inject

class MyCartFragment : AbstractFragment<MyCartFragmentBinding>(MyCartFragmentBinding::inflate) {

    @Inject
    lateinit var navigation: Navigation

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var adapter: CartItemsAdapter

    private val viewModel by viewModels<MyCartViewModel> {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMyCartComponent.builder()
            .abstractActivityComponent(component)
            .build()
            .inject(this)
        adapter = CartItemsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycler()
        binding.closeButton.setOnClickListener {
            navigation.back()
        }
    }

    private fun initRecycler() {
        binding.itemsRecycler.adapter = adapter
        viewModel.basketList.observe(viewLifecycleOwner) {
            adapter.submitList(it.basket)
            binding.delivery.text = it.delivery
            binding.total.text = getString(com.example.core.R.string.dollar_us, it.total)
        }
    }

    inner class CartItemHolder(private val binding: CartItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BasketItemEntity) {
            binding.apply {
                counterView.text = "1"
                itemName.text = item.title
                itemPrice.text = getString(com.example.core.R.string.dollar_f, item.price)
                Picasso.get()
                    .load(item.images)
                    .into(image)
            }
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
}