package com.gosp.apps.mlapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.gosp.apps.mlapp.databinding.SearchFragmentBinding
import com.gosp.apps.mlapp.main.MainViewModel

class SearchFragment : Fragment() {

    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = SearchFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        binding.etSearch.setOnEditorActionListener { v, actionId, keyEvent ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    if (!binding.etSearch.text.isNullOrEmpty())
                        viewModel.doSearch(binding.etSearch.text.toString(),requireContext())
                    else{
                        Toast.makeText(requireContext(), "Ingresa un artículo", Toast.LENGTH_SHORT).show()
                    }
                    true
                }else -> false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.etSearch.text.clear()
    }

}