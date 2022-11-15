package com.example.productdetails

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.core.data.ProductEntity
import com.example.core.di.ActivityWithAppComponent
import com.example.core.di.ViewModelFactory
import com.example.core.navigation.Navigation
import com.example.productdetails.databinding.ActivityProductDetailsBinding
import javax.inject.Inject

class ProductDetailsActivity : ActivityWithAppComponent() {

    @Inject
    lateinit var navigation: Navigation

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<ProductDetailsViewModel> {
        viewModelFactory
    }

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DaggerProductActivityComponent.builder().abstractAppComponent(appComponent).build().inject(this)
        attachViewModel()
        viewModel.load(1)
        val adapter = PagerAdapter(4)
        binding.pager.also {
            it.adapter = adapter
            it.offscreenPageLimit = 2
            it.setPageTransformer { page, position ->
                page.translationX = position * -420f
                page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            }
        }

//        filter.viewTreeObserver.addOnGlobalLayoutListener {
//            update(0)
//        }

        binding.pager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.load(position)
            }
        })
    }


    private fun attachViewModel() {
        val filter = binding.bottomFilter
        fun update(productEntity: ProductEntity) {
            val height = filter.height
            filter.animate().translationY((height).toFloat())
                .withEndAction {
                    binding.deviceInfoLayout.productName.text = productEntity.title
                    filter.animate().translationY((-height).toFloat()).start()
                }.start()
        }
        viewModel.productEntity.observe(this) {
            update(it)
        }
    }

    private inner class PagerAdapter(val items: Int) : FragmentStateAdapter(supportFragmentManager, lifecycle) {

        override fun getItemCount() = items

        override fun createFragment(position: Int): Fragment = ProductFragment()
    }

    override fun onBackPressed() {
        navigation.toMainActivity(this)
    }
}