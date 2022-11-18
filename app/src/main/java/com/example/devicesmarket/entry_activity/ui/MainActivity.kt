package com.example.devicesmarket.entry_activity.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.R
import com.example.core.data.BestSellerEntity
import com.example.core.di.ActivityWithAppComponent
import com.example.core.di.ViewModelFactory
import com.example.core.navigation.Constants.ARG_COUNT_ITEMS
import com.example.core.navigation.Constants.CURRENT_ITEM
import com.example.core.navigation.Navigation
import com.example.devicesmarket.databinding.ActivityMainBinding
import com.example.devicesmarket.databinding.DeviceCardBinding
import com.example.devicesmarket.entry_activity.di.DaggerMarketActivityComponent
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
        DaggerMarketActivityComponent.builder()
            .abstractAppComponent(appComponent)
            .build().inject(this)
        initRecyclers()
        initBottomFilter()
        initCartCounter()
        initButtonsRecycler()
    }

    private fun initRecyclers() {
        val adapter = ProductsAdapter()
        binding.devicesRecycler.adapter = adapter
        val hsAdapter = HotSalesListAdapter()
        binding.pager.adapter = hsAdapter
        wordsViewModel.marketList.observe(this) {
            adapter.submitList(it.bestSeller)
            hsAdapter.submitList(it.homeStore)
        }
    }

    private fun initBottomFilter() {
        val filter = binding.bottomLayout
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

    private fun initCartCounter() {
        wordsViewModel.basketCount.observe(this) {
            binding.cartCounter.text = if (it == 0) "" else it.toString()
        }
    }

    private fun initButtonsRecycler() {
        binding.topSheet.buttonsRecycler.adapter = CategoryButtonsAdapter(listOf(
            Triple(R.string.phones_string, R.drawable.ic_phone) {
                Toast.makeText(baseContext, getText(R.string.phones_string), Toast.LENGTH_SHORT).show()
            },
            Triple(R.string.computer_string, R.drawable.ic_pc) {
                Toast.makeText(baseContext, getText(R.string.computer_string), Toast.LENGTH_SHORT).show()
            },
            Triple(R.string.health_string, R.drawable.ic_heart) {
                Toast.makeText(baseContext, getText(R.string.health_string), Toast.LENGTH_SHORT).show()
            },
            Triple(R.string.books_string, R.drawable.ic_book) {
                Toast.makeText(baseContext, getText(R.string.books_string), Toast.LENGTH_SHORT).show()
            },
            Triple(R.string.another_string, R.drawable.ic_bucket) {
                Toast.makeText(baseContext, getText(R.string.another_string), Toast.LENGTH_SHORT).show()
            }
        ))
    }

    inner class ProductHolder(private val binding: DeviceCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BestSellerEntity, count: Int) {
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
                val bundle = Bundle()
                bundle.putInt(ARG_COUNT_ITEMS, count)
                bundle.putInt(CURRENT_ITEM, item.id)
                navigation.toProductDetailsActivity(this@MainActivity, bundle)
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
            holder.bind(getItem(position), itemCount)
        }
    }
}