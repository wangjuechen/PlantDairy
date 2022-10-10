package com.jc.android.plantdairy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.jc.android.plantdairy.R
import com.jc.android.plantdairy.databinding.FragmentListBinding
import com.jc.android.plantdairy.ui.adapter.ItemAdapter
import com.jc.android.plantdairy.ui.adapter.PlantClickListener
import com.jc.android.plantdairy.ui.viewmodel.PlantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(), PlantClickListener {

    private val listViewModel: PlantViewModel by viewModels()

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val plantAdapter = ItemAdapter()

        plantAdapter.plantClickListener = this
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = plantAdapter

        listViewModel.plantListLiveData.observe(viewLifecycleOwner) {
            plantAdapter.updatePlantList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickPlant(PlantId: String) {
        Navigation.findNavController(binding.root).navigate(R.id.action_ListFragment_to_DetailFragment, Bundle().apply {
            putString("plantID", PlantId)
        })
    }
}