package com.kitesoft.kotlinbnvfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class Tab1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    lateinit var et:EditText
    //val tv:TextView by lazy { view.findViewById(R.id.tv) } //view 참조가 불가하여 by lazy 는 어울리지 않음.
    lateinit var tv:TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et= view.findViewById(R.id.et)
        tv= view.findViewById(R.id.tv)

        view.findViewById<Button>(R.id.btn).setOnClickListener {
            tv.text= et.text.toString()
            //et.text= "" //error
            et.setText("")
        }

        et.setOnEditorActionListener { textView, i, keyEvent ->
            tv.text= textView.text
            et.setText("")
            true
        }
    }
}