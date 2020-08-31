package br.com.bruno.fonseca.app.features.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.bruno.fonseca.app.R
import br.com.bruno.fonseca.app.databinding.FragmentProductBinding
import kotlinx.android.synthetic.main.fragment_product.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProductFragment : Fragment() {
    private val productViewModel: ProductViewModel by viewModel()
    private lateinit var binding: FragmentProductBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)
        binding.vm = productViewModel
        binding.lifecycleOwner = this

        val rvSpotlight = binding.root.recyclerViewSpotlight
        rvSpotlight.setHasFixedSize(true)
        rvSpotlight.adapter = SpotlighAdapter()

        val rvSku = binding.root.recyclerViewSku
        rvSku.setHasFixedSize(true)
        rvSku.adapter = SkuAdapter()

        return binding.root
    }
}

