package com.inturnsala.retrofitbasic

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {

    //here i write get request
//this funtion return call class of retrofit
    //we use list because we get list of data
    // type of data is -> MydataItem
    //out url https://jsonplaceholder.typicode.com/posts
    //we use get request so we annotate GET and in parenthesis we put last past of our url
 @GET("posts")
fun getData(): Call<List<MydataItem>>
}