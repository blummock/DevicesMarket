package com.example.productdetails.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class TabPagerAdapter(
    private val count: Int,
    private val viewModel: ProductDetailsViewModel, fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = count

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ShopTabFragment(viewModel)
            else -> Fragment()
        }
    }
}