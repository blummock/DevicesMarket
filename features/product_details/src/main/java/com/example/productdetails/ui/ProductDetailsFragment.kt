package com.example.productdetails.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.core.AbstractFragment
import com.example.core.data.ProductEntity
import com.example.core.di.ViewModelFactory
import com.example.core.navigation.ARG_COUNT_ITEMS
import com.example.core.navigation.CURRENT_ITEM
import com.example.core.navigation.Navigation
import com.example.productdetails.databinding.ProductDetailsFragmentBinding
import com.example.productdetails.di.DaggerProductDetailsComponent
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class ProductDetailsFragment : AbstractFragment<ProductDetailsFragmentBinding>(ProductDetailsFragmentBinding::inflate) {

    @Inject
    lateinit var navigation: Navigation

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<ProductDetailsViewModel> {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerProductDetailsComponent.builder()
            .abstractActivityComponent(component)
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        attachViewModel()
        val countItems = requireArguments().getInt(ARG_COUNT_ITEMS, 1)
        val currentItem = requireArguments().getInt(CURRENT_ITEM, 0)
        viewModel.load(currentItem)
        initImagePager(countItems)
        initTabPager()
    }

    private fun initTabPager() {
        val items = listOf(
            com.example.core.R.string.shop_string,
            com.example.core.R.string.details_string,
            com.example.core.R.string.features_string
        )
        val adapter = TabPagerAdapter(items.size, viewModel, childFragmentManager, lifecycle)
        val pager = binding.deviceInfoLayout.pager
        pager.adapter = adapter
        TabLayoutMediator(binding.deviceInfoLayout.tabLayout, pager) { tab, position ->
            tab.text = getString(items[position])
        }.attach()
    }

    private fun initImagePager(itemsCount: Int) {
        val adapter = ImagePagerAdapter(itemsCount, viewModel, childFragmentManager, lifecycle)
        binding.pager.also {
            it.adapter = adapter
            it.offscreenPageLimit = 2
            it.setPageTransformer { page, position ->
                page.translationX = position * -420f
                page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            }
            it.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    viewModel.load(position)
                }
            })
        }
    }

    private fun attachViewModel() {
        val filter = binding.bottomLayout
        fun update(productEntity: ProductEntity) {
            val height = filter.height
            filter.animate().translationY((height).toFloat())
                .withEndAction {
                    binding.deviceInfoLayout.productName.text = productEntity.title
                    filter.animate().translationY((-height).toFloat()).start()
                }.start()
        }
        viewModel.productEntity.observe(viewLifecycleOwner) {
            update(it)
            binding.apply {
                deviceInfoLayout.addButton.text = getString(com.example.core.R.string.add_to_cart_string, it.price)
                deviceInfoLayout.ratingBar.rating = it.rating
            }
        }
        binding.closeButton.setOnClickListener {
            navigation.back()
        }
    }
}