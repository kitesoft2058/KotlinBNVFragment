package com.kitesoft.kotlinbnvfragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class Tab3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab3, container, false)
    }

    lateinit var recyclerview:RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview= view.findViewById(R.id.recycler)
    }

    //처음 프레그먼트가 만들어질때 데이터 한번 가져오기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        searchNaverShopping("패딩")
    }

    fun searchNaverShopping(query:String){

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://openapi.naver.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()

        retrofit.create(NaverRetrofitService::class.java).searchData(query).enqueue(object :
            Callback<NaverShoppingApiResponse> {
            override fun onResponse(call: Call<NaverShoppingApiResponse>, response: Response<NaverShoppingApiResponse>) {
                val shoppingResponse: NaverShoppingApiResponse?= response.body()

                val buffer:StringBuffer= StringBuffer()
                buffer.append("total : " + shoppingResponse?.total +"\n")
                buffer.append("display : " + shoppingResponse?.display + "\n")
                buffer.append("items size : " + shoppingResponse?.items?.size +"\n")
                buffer.append(shoppingResponse?.items?.get(0)?.title+"\n")
                buffer.append(shoppingResponse?.items?.get(0)?.link+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.image+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.lprice+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.hprice+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.maker+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.brand+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.mallName+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.productId+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.productType+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.category1+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.category2+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.category3+"\n")
//                buffer.append(shoppingResponse?.items?.get(0)?.category4+"\n")
//
//                AlertDialog.Builder(activity).setMessage(buffer.toString()).show()

                //if(shoppingResponse!=null) recyclerview.adapter= MyAdapter(activity as Context, shoppingResponse.items)
                // != null 문을 ?.let {} 으로 대체할 수 있음.
                shoppingResponse?.let { recyclerview.adapter= MyAdapter(activity as Context, it.items) }
                //shoppingResponse?.items?.let { recyclerview.adapter= MyAdapter(activity as Context, it) }

            }

            override fun onFailure(call: Call<NaverShoppingApiResponse>, t: Throwable) {
                Toast.makeText(activity, "서버오류 : " + t.message, Toast.LENGTH_SHORT).show()
            }
        })

//        retrofit.create(NaverApiRetrofitService::class.java).searchDataByString("패딩").enqueue(object : Callback<String>{
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                val s:String?= response.body()
//                AlertDialog.Builder(this@MainActivity).setMessage(s).show()
//            }
//
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "서버오류 : " + t.message, Toast.LENGTH_SHORT).show()
//            }
//        })



    }
}