package com.example.recyclerviewpro.adapters


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpro.activities.DetailActivity
import com.example.recyclerviewpro.helpers.FilterHelper
import com.example.recyclerviewpro.R
import com.example.recyclerviewpro.databinding.OneElementBinding
import com.example.recyclerviewpro.models.Data
import com.squareup.picasso.Picasso

class   RVAdapter(photosWithContent: ArrayList<Data>) :
    RecyclerView.Adapter<RVAdapter.PhotosViewHolder>(), Filterable {
    var photosDetail = photosWithContent
    var dataFilter: FilterHelper = FilterHelper(photosDetail, this)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.one_element, parent, false)
        return PhotosViewHolder((view))
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        var photoDetail = photosDetail[position]
        holder.setData(photoDetail, position)
    }

    override fun getItemCount(): Int {
        return photosDetail.size
    }

    class PhotosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var oneElement = itemView as CardView

        private var binding = OneElementBinding.bind(itemView)
        var circleImageViewThumb = binding.circleImageViewThumb
        var textViewLikes = binding.textViewLikes
        var textViewPhotograper = binding.textViewPhotograper

        fun setData(photoDetail: Data, position: Int) {
            textViewPhotograper.text = "By " + photoDetail.authorName
            textViewLikes.text = photoDetail.photoLikes.toString()
            Picasso.with(itemView.context).load(photoDetail.photoThumbUrl).into(
                circleImageViewThumb
            )

            oneElement.setOnClickListener { view ->
                var intent = Intent(view.context, DetailActivity::class.java)
                intent.putExtra("photoDetail", photoDetail)
                view.context.startActivity(intent)
            }
        }

    }

    override fun getFilter(): Filter {
        return dataFilter
    }

    fun setFilter(values: ArrayList<Data>) {
        photosDetail = values
    }

}
