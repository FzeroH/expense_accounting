package com.example.expenseaccounting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R

class SettingsFragment : Fragment() {

    private lateinit var btnSettingsBack: ImageView
    private lateinit var btnVolumeTank: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val v:View = inflater.inflate(R.layout.fragment_settings, container, false)

        btnSettingsBack = v.findViewById(R.id.btn_settings_back)
        btnVolumeTank = v.findViewById(R.id.btn_volume_tank)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnSettingsBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_settingsFragment_to_mainFragment)
        }
        btnVolumeTank.setOnClickListener {
            Toast.makeText(context,"Установить количество топлива", LENGTH_SHORT).show()
        }
    }
}