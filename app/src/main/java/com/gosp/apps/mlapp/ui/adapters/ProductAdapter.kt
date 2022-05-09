package com.gosp.apps.mlapp.ui.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gosp.apps.mlapp.R
import com.gosp.apps.mlapp.databinding.RowProductBinding
import com.gosp.apps.mlapp.main.asMoneyFormat
import com.gosp.apps.mlapp.models.ItemsResult


class ProductAdapter(
    private val list: ArrayList<ItemsResult>,
    private val activity: Activity,
    private var onItemClick: (id: String) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ProductAdapter.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.binding(list[position], activity,onItemClick)
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RowProductBinding.bind(view)

        @SuppressLint("SetTextI18n")
        fun binding(
            data: ItemsResult,
            activity: Activity,
            onItemClick: (id: String) -> Unit
        ) {
            binding.tvTitle.text = data.title
            binding.tvPrice.text = data.price.toDouble().asMoneyFormat()

            /*val newurl = URL(data.thumbnail)
            val mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
            binding.ivMain.setImageBitmap(mIcon_val)*/

            Glide
                .with(activity)
                .load(data.thumbnail.replace("http://","https://"))
                .asBitmap()
                .skipMemoryCache(true)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_image_broken)
                .into(binding.ivMain)



            //Log.e("LAS FOTOS", "-----> ${data.thumbnail}")
            binding.row.setOnClickListener {
                onItemClick(data.id)
            }

        }
    }
}
