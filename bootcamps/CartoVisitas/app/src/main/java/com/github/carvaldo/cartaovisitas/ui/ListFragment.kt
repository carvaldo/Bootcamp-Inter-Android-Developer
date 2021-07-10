package com.github.carvaldo.cartaovisitas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.github.carvaldo.cartaovisitas.R
import com.github.carvaldo.cartaovisitas.databinding.FragmentListBinding
import com.github.carvaldo.cartaovisitas.viewmodel.CartaoViewModel

/**
 * [Fragment] da lista de cartões.
 */
class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: CartaoAdapter
    private val viewModel: CartaoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        viewModel.listar().observe(requireActivity()) {
            adapter = CartaoAdapter(lifecycleScope, it)
            binding.recyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.adicionarButton.setOnClickListener {
            findNavController().navigate(R.id.action_lista_para_adicao)
        }
    }
}