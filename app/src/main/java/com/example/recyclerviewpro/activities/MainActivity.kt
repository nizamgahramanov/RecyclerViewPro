package com.example.recyclerviewpro.activities

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewpro.retrofit.ApiInterface
import com.example.recyclerviewpro.R
import com.example.recyclerviewpro.retrofit.RetrofitClient
import com.example.recyclerviewpro.adapters.RVAdapter
import com.example.recyclerviewpro.databinding.ActivityMainBinding
import com.example.recyclerviewpro.models.Constant
import com.example.recyclerviewpro.models.Data
import com.example.recyclerviewpro.models.PhotoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RVAdapter
    lateinit var searchView: SearchView
    var apiResult = ArrayList<PhotoList.Results>()
    var neededData = ArrayList<Data>()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        searchView = binding.searchViewItems
        getDataSourceFromApi()
//        changeColorSearchViewCursor(searchView)
    }


    private fun getDataSourceFromApi() {
        var api = RetrofitClient.client?.create(ApiInterface::class.java)
        var callApi = api?.getPhotosList("germany", "portrait", Constant.ACCESS_KEY)
        Log.e("CALL API ", callApi.toString())
        callApi?.enqueue(object : Callback<PhotoList> {
            override fun onResponse(call: Call<PhotoList>, response: Response<PhotoList>) {
                binding.rv.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                apiResult = response.body()?.results as ArrayList<PhotoList.Results>
                adapter = RVAdapter(prepareDataForAdapter(apiResult))
                binding.rv.adapter = adapter
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        adapter.filter.filter((newText))
                        return false
                    }

                })

            }
            override fun onFailure(call: Call<PhotoList>, t: Throwable) {
                Log.e("On Failure", t.message)
            }

        })
    }

    private fun prepareDataForAdapter(results: ArrayList<PhotoList.Results>): ArrayList<Data> {

        for (i in results.indices) {
            var photoTitle: String? = resources.getString(R.string.defaultTitle)
            var authorBio: String? = resources.getString(R.string.defaultBio)
            if (results[i].tags?.isEmpty() == false) {
                photoTitle = results[i].tags?.get(0)?.title
                authorBio = results[i].tags?.get(0)?.source?.coverPhoto?.user?.bio
            }
            var authorName = results[i].user?.name
            var photoUrl = results[i].urls?.regular
            var authorProfilePhoto = results[i].user?.profileImage?.large
            var photoThumbUrl = results[i].urls?.thumb
            var photoLikes = results[i].likes
            var photoDescription = results[i].altDescription
            var onePhotoDetails = Data(
                photoTitle,
                photoDescription,
                authorName,
                photoUrl,
                photoLikes,
                photoThumbUrl,
                authorBio,
                authorProfilePhoto
            )

            neededData.add(onePhotoDetails)
        }
        return neededData
    }
}