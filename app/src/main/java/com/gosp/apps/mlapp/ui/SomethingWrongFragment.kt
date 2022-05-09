package com.gosp.apps.mlapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gosp.apps.mlapp.R
import com.gosp.apps.mlapp.databinding.NotInternetFragmentBinding

import com.gosp.apps.mlapp.main.MainViewModel

class SomethingWrongFragment: Fragment() {

    private var _binding: NotInternetFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = SomethingWrongFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = NotInternetFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        if (viewModel.isBatInternet){
            binding.ivLogo.setImageResource(R.drawable.ml_not_internet)
            binding.tvTryAgain.text = "Reintentar"
        }

        binding.tvTryAgain.setOnClickListener{
            requireActivity().onBackPressed()
        }

    }
}