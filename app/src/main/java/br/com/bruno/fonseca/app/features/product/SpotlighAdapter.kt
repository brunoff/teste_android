package br.com.bruno.fonseca.app.features.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.bruno.fonseca.app.R
import br.com.bruno.fonseca.app.data.remote.products.ProductResponseSpotlightDTO
import br.com.bruno.fonseca.app.databinding.FragmentProductSpotlightRowBinding
import br.com.bruno.fonseca.app.features.BindableAdapter

class SpotlighAdapter :
    RecyclerView.Adapter<SpotlighAdapter.ViewHolder>(),
    BindableAdapter<List<ProductResponseSpotlightDTO>> {
    val values: MutableList<ProductResponseSpotlightDTO> = mutableListOf()

    class ViewHolder(val itemBinding: FragmentProductSpotlightRowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(minePortifoliosResponseDTO: ProductResponseSpotlightDTO) {
            itemBinding.item = minePortifoliosResponseDTO
            itemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = DataBindingUtil.inflate<FragmentProductSpotlightRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.fragment_product_spotlight_row, parent, false
        );
        return ViewHolder(binding);
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val minePortifoliosResponseDTO = values[position]
        holder.bind(minePortifoliosResponseDTO)
    }

    override fun setData(data: List<ProductResponseSpotlightDTO>) {
        values.clear()
        values.addAll(data)
        notifyDataSetChanged()
    }

}