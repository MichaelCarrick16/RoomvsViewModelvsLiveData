package com.example.roomversionone

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomversionone.db.UserEntity

class RecyclerViewAdapter(context: Context , list: List<UserEntity>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var context : Context
    private var list : List<UserEntity>
    private lateinit var onCallback : OnActionCallback

    init {
        this.context = context
        this.list = list
    }

    fun setNewData(list: List<UserEntity>){
        this.list = list
        notifyDataSetChanged()
    }

    fun setCallback(onCallback: OnActionCallback){
        this.onCallback = onCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        var view : View = LayoutInflater.from(context).inflate(R.layout.custom_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var userEntity = list.get(position)
        holder.tvNameItem.setText(userEntity.name)
        holder.tvEmailItem.setText(userEntity.email)
        holder.imvDelete.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                onCallback.onCallback(userEntity)
            }

        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

     class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tvNameItem : TextView = itemView.findViewById(R.id.tv_name_item)
        var tvEmailItem : TextView = itemView.findViewById(R.id.tv_email_item)
        var imvDelete : ImageView = itemView.findViewById(R.id.imv_delete)
    }
}