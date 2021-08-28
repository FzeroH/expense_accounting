package com.example.expenseaccounting.screens.addexpenses

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R
import moxy.MvpAppCompatFragment
import org.w3c.dom.Text

class AddExpenseFragment : MvpAppCompatFragment() {

    private lateinit var btnAddExpenseBack: ImageView
    private lateinit var btnAddFuel: ConstraintLayout
    private lateinit var btnAddWash: ConstraintLayout
    private lateinit var btnAddParking: ConstraintLayout
    private lateinit var showTypesMenu: TextView
    private lateinit var popupMenu: PopupMenu


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v:View = inflater.inflate(R.layout.fragment_add_expense, container, false)
        btnAddExpenseBack = v.findViewById(R.id.btn_add_expense_back)
        /*btnAddFuel = v.findViewById(R.id.add_fuel)
        btnAddWash = v.findViewById(R.id.add_wash)
        btnAddParking = v.findViewById(R.id.add_parking)*/
        showTypesMenu = v.findViewById(R.id.show_types_menu)
        popupMenu = PopupMenu(context, showTypesMenu)
        popupMenu.menuInflater.inflate(R.menu.add_expense_type_menu, popupMenu.menu)
        return v
    }

    @SuppressLint("ResourceAsColor")
    override fun onStart() {
        super.onStart()
        btnAddExpenseBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_addExpenseFragment_to_mainFragment)
        }
        /*btnAddFuel.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_addExpenseFragment_to_fuelFragment)
        }
        btnAddWash.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_addExpenseFragment_to_washFragment)
        }
        btnAddParking.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_addExpenseFragment_to_parkingFragment)
        }*/

        popupMenu.setOnMenuItemClickListener {

            if(it.itemId == R.id.wash_type){
                showTypesMenu.text = "Мойка"

            }
            else if (it.itemId == R.id.parking_type){

                showTypesMenu.text = "Парковка"
            }
            else if (it.itemId == R.id.fuel_type){

                showTypesMenu.text = "Топливо"
            }
            false
        }
        showTypesMenu.setOnClickListener{
            popupMenu.show()
        }

    }
}