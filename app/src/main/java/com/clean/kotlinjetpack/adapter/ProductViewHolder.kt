package com.clean.kotlinjetpack.adapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.clean.kotlinjetpack.Product
import com.clean.kotlinjetpack.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ProductViewHolder (itemView: View) : BaseViewHolder(itemView)  {

    val txtName: TextView
    val txtDescription: TextView

    val img: ImageView

    val txtState:TextView

    init {
        txtName = itemView.findViewById(R.id.txtName)
        txtDescription = itemView.findViewById(R.id.txtDescription)
        img = itemView.findViewById(R.id.imgProduct)
        txtState=itemView.findViewById(R.id.txtState)

    }








    override fun onBind(item: Product?) {



        txtName.text=item?.name
        txtDescription.text=item?.description

        //Glide.with(itemView.context).load(item?.imgUrl).to(img)
        Picasso.with(itemView.context).load(item?.imgUrl).resize(100,100).into(img)
        if(item?.state.equals("I")){
            itemView.isEnabled=false
            itemView.alpha=0.5f
            txtState.text="INACTIVO"
            txtState.setTextColor( ContextCompat.getColor(itemView.context,(R.color.inactive)))
        }else{
            txtState.text="ACTIVO"
            txtState.setTextColor( ContextCompat.getColor(itemView.context,(R.color.active)))



        }







    }





}