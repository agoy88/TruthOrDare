package com.mars.truthordare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragmentTruth : BottomSheetDialogFragment() {

    lateinit var tvData : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.bottom_sheet_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvData = view.findViewById(R.id.deskripsi_bottom_sheet)
        val array = resources.getStringArray(R.array.Truth_txt)
        val randomIndex = (array.indices).random()
        tvData.text = array[randomIndex]
    }

}