package com.example.Madjobs
//view lis of company
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Create an adapter class that extends RecyclerView.Adapter, and takes a list of ComanyModel objects

class ComAdapter(private val comList: ArrayList<ComanyModel>) :
    RecyclerView.Adapter<ComAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    // Define a method for setting the click listener for the RecyclerView items

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.company_list_item, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCom = comList[position]
        holder.tvComName.text = currentCom.name
        holder.tvComCountry.text = currentCom.country
        holder.tvComprovince.text = currentCom.province
        holder.tvComDistric.text = currentCom.distric
        holder.tvComType.text = currentCom.type
    }

    override fun getItemCount(): Int {
        return comList.size
    }

    // Bind data to the ViewHolder, using the data from the ComanyModel object at the given position

    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val tvComName : TextView = itemView.findViewById(R.id.showName)
        val tvComCountry : TextView = itemView.findViewById(R.id.showCountry)
        val tvComprovince : TextView = itemView.findViewById(R.id.showProvince)
        val tvComDistric : TextView = itemView.findViewById(R.id.showDistric)
        val tvComType : TextView = itemView.findViewById(R.id.showType)

        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }


}