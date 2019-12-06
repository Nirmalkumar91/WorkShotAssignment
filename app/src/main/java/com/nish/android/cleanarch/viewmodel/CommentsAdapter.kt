package com.nish.android.cleanarch.viewmodel

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import android.view.ViewGroup
import com.nish.android.cleanarch.R
import com.nish.android.cleanarch.databinding.ItemCommentBinding


class CommentsAdapter(
    private val dataModelList: List<CommentViewModel>
) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: ItemCommentBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_comment, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataModelList[position]
        holder.bind(dataModel)
    }


    override fun getItemCount(): Int {
        return dataModelList?.size
    }

    inner class ViewHolder(var itemRowBinding: ItemCommentBinding) :
        RecyclerView.ViewHolder(itemRowBinding.getRoot()) {

        fun bind(commentViewModel: CommentViewModel) {
            itemRowBinding.viewmodel = commentViewModel
        }
    }
}