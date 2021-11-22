package com.kitesoft.kotlinbnvfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    val bnv:BottomNavigationView by lazy{ findViewById(R.id.bnv) }

    var fragments: ArrayList<Fragment> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Fragment 동적 추가 [ 우선 Tab1Fragment 부터.. ]
        fragments.add(Tab1Fragment())
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragments.get(0)).commit()

//        bnv.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener{
//            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                when(item.itemId){
//                    R.id.bnv_tab1-> Toast.makeText(this@MainActivity, "tab1", Toast.LENGTH_SHORT).show()
//                    R.id.bnv_tab2-> Toast.makeText(this@MainActivity, "tab2", Toast.LENGTH_SHORT).show()
//                    R.id.bnv_tab3-> Toast.makeText(this@MainActivity, "tab3", Toast.LENGTH_SHORT).show()
//                }
//                return true //true 로 하지 않으면 선택은 되지만 탭이 바뀐것이 표시되지 않음.
//            }
//        })

        //축약형
        bnv.setOnItemSelectedListener {

            val tran:FragmentTransaction = supportFragmentManager.beginTransaction()
            fragments.forEach { tran.hide(it) }

            when(it.itemId){
                R.id.bnv_tab1-> {
                    tran.show(fragments.get(0))
                }
                R.id.bnv_tab2-> {
                    if(fragments.size<2) {
                        fragments.add(Tab2Fragment())
                        tran.add(R.id.fragment_container, fragments.get(1))
                    }
                    tran.show(fragments.get(1))
                }
                R.id.bnv_tab3-> {
                    if(fragments.size<3) {
                        fragments.add(Tab3Fragment())
                        tran.add(R.id.fragment_container, fragments.get(2))
                    }
                    tran.show(fragments.get(2))
                }
            }

            tran.commit()

            true //축약형에서는 return 키워드도 생략해야 함.
        }
    }
}