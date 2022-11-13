package com.example.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.productdetails.databinding.DevicesPagerCardBinding

class ProductFragment : Fragment() {

    lateinit var binding: DevicesPagerCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DevicesPagerCardBinding.inflate(inflater)
        return binding.root
    }
}