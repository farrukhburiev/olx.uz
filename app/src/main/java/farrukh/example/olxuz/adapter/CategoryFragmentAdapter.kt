package farrukh.example.olxuz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import farrukh.example.olxuz.R
import farrukh.example.olxuz.modul.Category


class CategoryFragmentAdapter(var offers:MutableList<Category>): RecyclerView.Adapter<CategoryFragmentAdapter.MyHolder>()  {

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.name)
        var img = itemView.findViewById<ImageView>(R.id.img)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var myHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)


        return MyHolder(myHolder)
    }

    override fun getItemCount(): Int {
        return offers.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val cont = offers.get(position)
        holder.name.text = cont.name
        holder.img.setImageResource(cont.img)

    }


}