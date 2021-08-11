package com.example.recyclerviewpro.activities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import com.example.recyclerviewpro.R
import com.example.recyclerviewpro.databinding.ActivityDetailBinding
import com.example.recyclerviewpro.models.Data
import com.squareup.picasso.Picasso
import java.io.IOException
import java.net.URL


class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    lateinit var photoDetail: Data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setIntentDataToView()
    }


    private fun setIntentDataToView() {
        var intent = intent
        if (intent != null) {
            photoDetail = intent.extras?.get("photoDetail") as Data

            binding.textViewDesciption.text = photoDetail.photoDescription
            binding.textViewBio.text = photoDetail.authorBio
            binding.textViewAuthor.text = photoDetail.authorName
            Picasso.with(this).load(photoDetail.authorProfilePhoto)
                .placeholder(R.drawable.placeholder).into(binding.circleImageViewThumbAuthor)
            setSupportActionBar(binding.animToolbar)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            binding.collapsingToolbar.title = photoDetail.photoTitle
            LoadImage().execute(photoDetail.photoUrl)
        }
    }

    inner class LoadImage : AsyncTask<String?, Void?, Bitmap?>() {
        override fun doInBackground(vararg params: String?): Bitmap? {
            var bitmap: Bitmap? = null
            try {
                val inputStream = URL(params[0]).openStream()
                bitmap = BitmapFactory.decodeStream(inputStream)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return bitmap
        }

        override fun onPostExecute(bitmap: Bitmap?) {
            Picasso.with(applicationContext).load(photoDetail.photoUrl)
                .placeholder(R.drawable.placeholder).into(binding.header)
            Palette.from(bitmap!!).generate { palette ->
                var color = palette?.getDominantColor(R.attr.colorAccent)
                binding.collapsingToolbar.setContentScrimColor(color!!)
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    window.statusBarColor = color
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}