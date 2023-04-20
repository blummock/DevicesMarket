package com.example.productdetails.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.productdetails.databinding.ShopTabItemBinding

class ShopTabFragment(private val viewModel: ProductDetailsViewModel) : Fragment() {

    lateinit var binding: ShopTabItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShopTabItemBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.productEntity.observe(viewLifecycleOwner) {
            binding.apply {
                cpuTitle.text = it.cpu
                cameraTitle.text = it.camera
                ramTitle.text = it.ssd
                storeTitle.text = it.sd
                firstStoreButton.text = getString(com.example.core.R.string.store_gb_string, it.capacity[0])
                secondStoreButton.text = getString(com.example.core.R.string.store_gb_string, it.capacity[1])
                colorFirstButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor(it.color[0]))
                colorFirstButton.isSelected = true
                colorSecondButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor(it.color[1]))

            }
        }
    }
}