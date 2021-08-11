package com.example.recyclerviewpro.helpers

import android.widget.Filter
import com.example.recyclerviewpro.adapters.RVAdapter
import com.example.recyclerviewpro.models.Data

class FilterHelper(photoDetail: ArrayList<Data>, adapter: RVAdapter) : Filter() {
    var allList = photoDetail
    private var filteredDataList = ArrayList<Data>()
    private var adapter = adapter
    override fun performFiltering(constraint: CharSequence): FilterResults {
        val charSequenceString = constraint.toString()
        if (charSequenceString.isEmpty()) {
            filteredDataList = allList
        } else {
            val filteredList = ArrayList<Data>()
            for (i in allList) {
                if (i.authorName!!.toLowerCase()
                        .contains(charSequenceString.toLowerCase())
                ) {
                    filteredList.add(i)
                }
                filteredDataList = filteredList
            }
        }
        val results = FilterResults()
        results.values = filteredDataList
        results.count = filteredDataList.size
        return results
    }

    override fun publishResults(constraint: CharSequence, results: FilterResults) {
        adapter.setFilter(results.values as ArrayList<Data>)
        adapter.notifyDataSetChanged()
    }
}