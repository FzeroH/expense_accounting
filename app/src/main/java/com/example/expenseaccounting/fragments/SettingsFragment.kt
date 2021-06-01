package com.example.expenseaccounting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R

class SettingsFragment : Fragment() {

    private lateinit var btn_settings_back: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val v:View = inflater.inflate(R.layout.fragment_settings, container, false)

        btn_settings_back = v.findViewById(R.id.btn_settings_back)
        return v
    }

    override fun onStart() {
        super.onStart()
        btn_settings_back.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_settingsFragment_to_mainFragment)
        }
    }
}