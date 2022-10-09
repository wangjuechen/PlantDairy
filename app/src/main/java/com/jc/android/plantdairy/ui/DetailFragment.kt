package com.jc.android.plantdairy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jc.android.plantdairy.databinding.FragmentDetailBinding
import com.jc.android.plantdairy.ui.viewmodel.DetailViewModel

class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by viewModels()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    var id: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id = arguments?.getString("plantId") ?: ""

        detailViewModel.getPlant(id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}