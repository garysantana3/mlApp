package com.gosp.apps.mlapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gosp.apps.mlapp.R
import com.gosp.apps.mlapp.api.response.ItemDetailResponse
import com.gosp.apps.mlapp.databinding.ProductDetailFragmentBinding
import com.gosp.apps.mlapp.main.MainViewModel
import com.gosp.apps.mlapp.main.asMoneyFormat

class ProductDetailFragment: Fragment() {

    private var _binding: ProductDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = ProductDetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ProductDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        viewModel.detailItemData.observe(viewLifecycleOwner) { bindingData(it) }
    }

    private fun bindingData(data: ItemDetailResponse){
        binding.tvTitle.text = data.title
        binding.tvPrice.text = data.price.toDouble().asMoneyFormat()
        binding.tvDescription.text = ""



        Glide.with(activity)
            .load(data.thumbnail.replace("http://","https://"))
            .asBitmap()
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_image_broken)
            .skipMemoryCache(true)
            .into(binding.ivSlide)
    }

}