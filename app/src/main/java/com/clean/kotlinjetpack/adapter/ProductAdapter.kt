package com.clean.kotlinjetpack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clean.kotlinjetpack.Product
import com.clean.kotlinjetpack.R
import com.clean.kotlinjetpack.util.OnDisableTimeClickListener
import java.util.ArrayList

class ProductAdapter : RecyclerView.Adapter<BaseViewHolder>()  {
    private var items: MutableList<Product> = ArrayList<Product>()

    interface OnAdapter{
        fun   onItemCLick(item:Product)
    }
    private var onAdapter: OnAdapter? =null

    fun setList(list :MutableList<Product>){
        items=list;
        notifyDataSetChanged()
    }

    fun setListener(listener :OnAdapter){
        this.onAdapter=listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {


        return ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_row, parent, false))




    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(items.get(position))
        holder.itemView.setOnClickListener(OnDisableTimeClickListener(View.OnClickListener {

            if(onAdapter!=null){

                onAdapter?.onItemCLick(items.get(position))

            }
        }))
    }

    override fun getItemCount(): Int {
        return items.size

    }
}