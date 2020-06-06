package com.yash.mycover.cover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yash.mycover.databinding.ListDriverAllJobBinding
import com.yash.mycover.network.CoverJob

class CoverAdapter(val onClickListener: OnclickListener) :
    ListAdapter<CoverJob.CoverJobDetail, CoverAdapter.CoverPropertyViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<CoverJob.CoverJobDetail>() {
        override fun areItemsTheSame(
            oldItem: CoverJob.CoverJobDetail,
            newItem: CoverJob.CoverJobDetail
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: CoverJob.CoverJobDetail,
            newItem: CoverJob.CoverJobDetail
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }


    class CoverPropertyViewHolder(private var binding: ListDriverAllJobBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            coverProperty: CoverJob.CoverJobDetail,
            onClickListener: OnclickListener
        ) {
            binding.coverListener = onClickListener
            binding.test = coverProperty
            binding.executePendingBindings()
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoverAdapter.CoverPropertyViewHolder {
        return CoverPropertyViewHolder(ListDriverAllJobBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CoverAdapter.CoverPropertyViewHolder, position: Int) {
        val coverJobDetail = getItem(position)
        holder.bind(coverJobDetail, onClickListener)
    }


}

class OnclickListener(val clickListener: (CoverJob.CoverJobDetail, View) -> Unit) {

    fun onClick(coverJobDetail: CoverJob.CoverJobDetail, view: View) =
        clickListener(coverJobDetail, view)

}