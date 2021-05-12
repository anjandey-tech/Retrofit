package com.inturnsala.retrofitbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log10

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMyData()

    }

    private fun getMyData()
    {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(Apiinterface::class.java)


        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MydataItem>?> {
            override fun onResponse(
                call: Call<List<MydataItem>?>,
                response: Response<List<MydataItem>?>
            ) {
               val responsbody = response.body()!!

                val stringBuilder = StringBuilder()
                for(myData in responsbody)
                {
                        stringBuilder.append(myData.id)
                    stringBuilder.append("\n")
                    stringBuilder.append(myData.userId)
                    stringBuilder.append("\n")
                }

                val txt  : TextView
                txt = findViewById(R.id.txtId)
                txt.text = stringBuilder
            }

            override fun onFailure(call: Call<List<MydataItem>?>, t: Throwable) {
                        Log.d("MainActivity","onFailure" +t.message)
            }
        })


    }
}