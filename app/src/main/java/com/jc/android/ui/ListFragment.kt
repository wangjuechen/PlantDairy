package com.jc.android.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jc.android.plantdairy.databinding.FragmentFirstBinding
import com.jc.android.ui.adapter.PlantAdapter
import com.jc.android.ui.adapter.PlantClickListener

class ListFragment : Fragment(), PlantClickListener {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val plantAdapter = PlantAdapter(
            plantList = listOf("Monstera", "Halfmoon", "Mia")
        )
        plantAdapter.plantClickListener = this
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = plantAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickPlant(plant: String) {
        openDetailPage(plant)
    }

    private fun openDetailPage(plant: String) {
        val intent = Intent(activity, DetailActivity::class.java)
        activity?.startActivity(intent)
    }
}