package farrukh.example.olxuz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import farrukh.example.olxuz.R
import farrukh.example.olxuz.modul.Items


class ItemAdapter(var offers:MutableList<Items>, var listener:OnClickListener): RecyclerView.Adapter<ItemAdapter.MyHolder>()  {

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        var price = itemView.findViewById<TextView>(R.id.price)
        var img = itemView.findViewById<ImageView>(R.id.image)
        var item = itemView.findViewById<ConstraintLayout>(R.id.item_layout)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)

        return MyHolder(myHolder)
    }

    override fun getItemCount(): Int {
        return offers.size
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val cont = offers.get(position)
        holder.name.text = cont.name
        holder.price.text = cont.price.toString()
        holder.img.setImageResource(cont.img)

        holder.item.setOnClickListener {
            listener.itemClicked(position,cont)
        }

    }

    interface OnClickListener{
        fun itemClicked(position: Int,item:Items)
    }


}