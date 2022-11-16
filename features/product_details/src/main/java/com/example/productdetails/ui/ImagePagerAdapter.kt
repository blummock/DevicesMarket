package com.example.productdetails.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ImagePagerAdapter(
    private val items: Int,
    private val viewModel: ProductDetailsViewModel,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = items

    override fun createFragment(position: Int): Fragment {
        return ProductFragment(viewModel)
    }
}