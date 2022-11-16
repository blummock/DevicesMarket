package com.example.productdetails.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.productdetails.databinding.DevicesPagerCardBinding
import com.squareup.picasso.Picasso

class ProductFragment(private val viewModel: ProductDetailsViewModel) : Fragment() {

    lateinit var binding: DevicesPagerCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DevicesPagerCardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.productEntity.observe(viewLifecycleOwner) {
            Picasso.get()
                .load(it.images[1])
                .into(binding.image)
        }
    }
}