package com.gosp.apps.mlapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.gosp.apps.mlapp.databinding.SearchResultFragmentBinding
import com.gosp.apps.mlapp.main.MainViewModel
import com.gosp.apps.mlapp.models.ItemsResult
import com.gosp.apps.mlapp.ui.adapters.ProductAdapter


class SearchResultFragment : Fragment() {


    private var _binding: SearchResultFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = SearchResultFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = SearchResultFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        viewModel.dataList.observe(viewLifecycleOwner) { setDataAdapter(it) }
    }

    // Set data to RecycleView
    private fun setDataAdapter(list: ArrayList<ItemsResult>) {
        binding.rvData.setHasFixedSize(true)
        val adapter = ProductAdapter(list, requireActivity(),
            onItemClick = { id ->
                viewModel.getDetailItem(id,requireContext())
            })
        binding.rvData.adapter = adapter
    }
}