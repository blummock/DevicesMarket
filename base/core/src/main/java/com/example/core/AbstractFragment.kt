package com.example.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.core.di.AbstractActivity

abstract class AbstractFragment<T : ViewBinding>(private val viewBindingMeth: (LayoutInflater, ViewGroup?, Boolean) -> T) : Fragment() {

    protected val component by lazy {
        (requireActivity() as AbstractActivity).getComponent()
    }

    protected lateinit var binding: T
    private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = viewBindingMeth.invoke(inflater, container, false)
        return binding.root
    }
}