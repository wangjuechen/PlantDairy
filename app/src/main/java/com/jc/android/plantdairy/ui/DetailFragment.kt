package com.jc.android.plantdairy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.jc.android.plantdairy.R
import com.jc.android.plantdairy.databinding.FragmentDetailBinding
import com.jc.android.plantdairy.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

const val KEY_WORD_OF_PLANT_ID : String = "plantId"

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by viewModels()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    var id: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView: TextView = view.findViewById(R.id.detail_textview_id)
        val photoImageView: ImageView = view.findViewById(R.id.detail_imageview_plant)
        super.onViewCreated(view, savedInstanceState)
        id = arguments?.getString(KEY_WORD_OF_PLANT_ID) ?: ""

        detailViewModel.getPlant(id)

        detailViewModel.plantLiveData.observe(viewLifecycleOwner) {
            textView.text = it.id
            Glide.with(view.context)
                .load(it.imgSrcUrl)
                .into(photoImageView)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}