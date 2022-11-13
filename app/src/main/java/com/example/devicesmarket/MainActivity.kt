package com.example.devicesmarket

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.di.ActivityWithAppComponent
import com.example.core.navigation.Navigation
import com.example.devicesmarket.databinding.ActivityMainBinding
import com.example.devicesmarket.databinding.DeviceCardBinding
import javax.inject.Inject


class MainActivity : ActivityWithAppComponent() {

    @Inject
    lateinit var navigation: Navigation

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DaggerActivityComponent.builder()
            .abstractAppComponent(appComponent)
            .build()
            .inject(this)
        val adapter = ProductsAdapter()
        binding.devicesRecycler.adapter = adapter
        binding.topSheet.buttonsRecycler.adapter = CategoryButtonsAdapter(listOf(
            Triple(R.string.phones_string, R.drawable.layer_phones) {
                Log.d("AAAAAA", "BBBBBBBB")
            },
            Triple(R.string.computer_string, R.drawable.layer_phones) {
                Toast.makeText(
                    baseContext,
                    "Computer",
                    Toast.LENGTH_SHORT
                ).show()
            },
            Triple(R.string.health_string, R.drawable.layer_phones) {
                Toast.makeText(
                    baseContext,
                    "Health",
                    Toast.LENGTH_SHORT
                ).show()
            },
            Triple(R.string.books_string, R.drawable.layer_phones) {
                Toast.makeText(
                    baseContext,
                    "Book",
                    Toast.LENGTH_SHORT
                ).show()
            },
            Triple(R.string.another_string, R.drawable.layer_phones) {
                Toast.makeText(
                    baseContext,
                    "Another",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ))
        adapter.submitList(
            arrayListOf(
                com.example.core.DeviceItem("Samsung S9", "$500", "$600", 1),
                com.example.core.DeviceItem("Xiaomi Mi5", "$300", "$400", 1),
                com.example.core.DeviceItem("Iphone XS 256", "$1500", "$1650", 1),
                com.example.core.DeviceItem("Samsung A9", "$200", "$320", 1),
                com.example.core.DeviceItem("Samsung G457", "$100", "$110", 1),
                com.example.core.DeviceItem("Oppo", "$1400", "$1410", 1),
                com.example.core.DeviceItem("Huawei", "$1040", "$1140", 1),
                com.example.core.DeviceItem("Pixel", "$1000", "$1100", 1),
                com.example.core.DeviceItem("One Plus", "$1001", "$1101", 1)
            )
        )

    }


    override fun onResume() {
        super.onResume()
        val filter = binding.bottomFilter
        fun stateFilter(isShow: Boolean) {
            if (filter.isActivated != isShow) {
                filter.animate().translationY((filter.height * if (isShow) -1 else 1).toFloat())
                    .start()
                filter.isActivated = isShow
            }
        }
        binding.topSheet.filterReference.setOnClickListener {
            stateFilter(true)
        }
        binding.filterLayout.closeButton.setOnClickListener {
            stateFilter(false)
        }
        binding.filterLayout.doneButton.setOnClickListener {
            stateFilter(false)
        }
        binding.toCartButton.setOnClickListener {
            navigation.toMyCartActivity(this)
        }
    }

    inner class ProductHolder(private val binding: DeviceCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        lateinit var deviceItem: com.example.core.DeviceItem

        fun bind(deviceItem: com.example.core.DeviceItem) {
            this.deviceItem = deviceItem
            binding.devicePrice.text = deviceItem.price
            binding.deviceTitle.text = deviceItem.brand
            binding.deviceCost.text = deviceItem.cost
            binding.root.setOnClickListener {
                navigation.toProductDetailsActivity(this@MainActivity)
            }
        }
    }

    inner class ProductsAdapter :
        ListAdapter<com.example.core.DeviceItem, ProductHolder>(object :
            DiffUtil.ItemCallback<com.example.core.DeviceItem>() {

            override fun areItemsTheSame(oldItem: com.example.core.DeviceItem, newItem: com.example.core.DeviceItem) =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: com.example.core.DeviceItem,
                newItem: com.example.core.DeviceItem
            ) =
                oldItem.brand == newItem.brand
        }) {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder =
            ProductHolder(
                DeviceCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        override fun onBindViewHolder(holder: ProductHolder, position: Int) {
            holder.bind(getItem(position))
        }

    }

}