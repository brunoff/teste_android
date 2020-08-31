package br.com.bruno.fonseca.app.features.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.bruno.fonseca.app.R
import br.com.bruno.fonseca.app.data.remote.products.ProductResponseSkuDTO
import br.com.bruno.fonseca.app.databinding.FragmentProductSkuRowBinding
import br.com.bruno.fonseca.app.features.BindableAdapter

class SkuAdapter :
    RecyclerView.Adapter<SkuAdapter.SkuViewHolder>(),
    BindableAdapter<List<ProductResponseSkuDTO>> {
    val values: MutableList<ProductResponseSkuDTO> = mutableListOf()

    class SkuViewHolder(val itemBinding: FragmentProductSkuRowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(minePortifoliosResponseDTO: ProductResponseSkuDTO) {
            itemBinding.item = minePortifoliosResponseDTO
            itemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkuViewHolder {

        val binding = DataBindingUtil.inflate<FragmentProductSkuRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.fragment_product_sku_row, parent, false
        );
        return SkuViewHolder(binding);
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: SkuViewHolder, position: Int) {
        val minePortifoliosResponseDTO = values[position]
        holder.bind(minePortifoliosResponseDTO)
    }

    override fun setData(data: List<ProductResponseSkuDTO>) {
        values.clear()
        values.addAll(data)
        notifyDataSetChanged()
    }

}