package com.example.productdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.core.DeviceItem
import com.example.core.navigation.BackToMainActivity
import com.example.productdetails.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : BackToMainActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    private val items = arrayListOf(
        DeviceItem("Samsung S9", "$500", "$600", 1),
        DeviceItem("Xiaomi Mi5", "$300", "$400", 1),
        DeviceItem("Iphone XS 256", "$1500", "$1650", 1),
        DeviceItem("Samsung A9", "$200", "$320", 1),
        DeviceItem("Samsung G457", "$100", "$110", 1),
        DeviceItem("Oppo", "$1400", "$1410", 1),
        DeviceItem("Huawei", "$1040", "$1140", 1),
        DeviceItem("Pixel", "$1000", "$1100", 1),
        DeviceItem("One Plus", "$1001", "$1101", 1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = PagerAdapter()
        binding.pager.also {
            it.adapter = adapter
            it.offscreenPageLimit = 2
            it.setPageTransformer { page, position ->
                page.translationX = position * -420f
                page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            }
        }
        val filter = binding.bottomFilter
        fun update(position: Int) {
            val height = filter.height
            filter.animate().translationY((height).toFloat())
                .withEndAction {
                    binding.deviceInfoLayout.productName.text = items[position].brand
                    filter.animate().translationY((-height).toFloat()).start()
                }.start()
        }

        filter.viewTreeObserver.addOnGlobalLayoutListener {
            update(0)
        }

        binding.pager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                update(position)
            }
        })
    }

    private inner class PagerAdapter : FragmentStateAdapter(supportFragmentManager, lifecycle) {

        override fun getItemCount(): Int = items.size

        override fun createFragment(position: Int): Fragment = ProductFragment()


    }
}