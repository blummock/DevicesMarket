package com.example.devicesmarket.main_market

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.devicesmarket.databinding.CategoryButtonLayoutBinding

class CategoryButtonsAdapter(private val actions: List<Triple<Int, Int, () -> Unit>>) :
    RecyclerView.Adapter<CategoryButtonsAdapter.ButtonHolder>() {

    private var selected: CategoryButtonLayoutBinding? = null

    override fun onBindViewHolder(holder: ButtonHolder, position: Int) {
        holder.bind(actions[position])
    }

    override fun getItemCount(): Int = actions.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ButtonHolder(
        CategoryButtonLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), parent.context
    )

    inner class ButtonHolder(
        private val binding: CategoryButtonLayoutBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(action: Triple<Int, Int, () -> Unit>) {
            binding.run {
                button.foreground = AppCompatResources.getDrawable(context, action.second)
                titleText.text = context.getText(action.first)
                button.setOnClickListener {
                    selected?.button?.isSelected = false
                    selected?.titleText?.isSelected = false
                    action.third.invoke()
                    it.isSelected = true
                    titleText.isSelected = true
                    selected = binding
                }
            }
        }


    }

}
