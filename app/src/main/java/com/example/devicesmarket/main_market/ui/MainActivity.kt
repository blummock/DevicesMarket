package com.example.devicesmarket.main_market.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.core.data.BestSellerEntity
import com.example.core.di.ActivityWithAppComponent
import com.example.core.di.ViewModelFactory
import com.example.core.navigation.Navigation
import com.example.devicesmarket.R
import com.example.devicesmarket.databinding.ActivityMainBinding
import com.example.devicesmarket.databinding.DeviceCardBinding
import com.example.devicesmarket.main_market.di.DaggerMarketActivityComponent
import com.example.productdetails.ProductFragment
import com.squareup.picasso.Picasso
import javax.inject.Inject


class MainActivity : ActivityWithAppComponent() {

    @Inject
    lateinit var navigation: Navigation

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val wordsViewModel by viewModels<MarketActivityViewModel> {
        viewModelFactory
    }

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dagger = DaggerMarketActivityComponent.builder()
            .abstractAppComponent(appComponent)
            .build()
        dagger.inject(this)
        val adapter = ProductsAdapter()
        binding.devicesRecycler.adapter = adapter
        val hsAdapter = HotSalesListAdapter()
        binding.pager.adapter = hsAdapter
        wordsViewModel.marketList.observe(this) {
            adapter.submitList(it.bestSeller)
            hsAdapter.submitList(it.homeStore)
        }

        binding.topSheet.buttonsRecycler.adapter = CategoryButtonsAdapter(listOf(
            Triple(R.string.phones_string, R.drawable.ic_phone) {
                Log.d("AAAAAA", "BBBBBBBB")
            },
            Triple(R.string.computer_string, R.drawable.ic_pc) {
                Toast.makeText(
                    baseContext,
                    "Computer",
                    Toast.LENGTH_SHORT
                ).show()
            },
            Triple(R.string.health_string, R.drawable.ic_heart) {
                Toast.makeText(
                    baseContext,
                    "Health",
                    Toast.LENGTH_SHORT
                ).show()
            },
            Triple(R.string.books_string, R.drawable.ic_book) {
                Toast.makeText(
                    baseContext,
                    "Book",
                    Toast.LENGTH_SHORT
                ).show()
            },
            Triple(R.string.another_string, R.drawable.ic_bucket) {
                Toast.makeText(
                    baseContext,
                    "Another",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ))
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

        fun bind(item: BestSellerEntity) {
            binding.run {
                deviceTitle.text = item.title
                discountPrice.text = getString(R.string.dollar, item.discountPrice)
                price.text = getString(R.string.dollar, item.priceWithoutDiscount)
                likeButton.isSelected = item.isFavorites
                Picasso.get()
                    .load(item.picture)
                    .centerCrop()
                    .resize(400, 400)
                    .into(deviceImage)
            }
            binding.root.setOnClickListener {
                navigation.toProductDetailsActivity(this@MainActivity)
            }
        }
    }

    inner class ProductsAdapter :
        ListAdapter<BestSellerEntity, ProductHolder>(object :
            DiffUtil.ItemCallback<BestSellerEntity>() {

            override fun areItemsTheSame(oldItem: BestSellerEntity, newItem: BestSellerEntity) =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: BestSellerEntity,
                newItem: BestSellerEntity
            ) =
                oldItem.id == newItem.id
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