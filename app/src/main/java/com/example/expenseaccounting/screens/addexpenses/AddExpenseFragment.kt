package com.example.expenseaccounting.screens.addexpenses

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.expenseaccounting.MainActivity
import com.example.expenseaccounting.R

class AddExpenseFragment : Fragment() {

    private lateinit var btnAddExpenseBack: ImageView
    private lateinit var showTypesMenu: TextView
    private lateinit var popupMenu: PopupMenu
    private lateinit var btnAddExpense: ImageButton
    private lateinit var inputPrice: EditText
    private lateinit var inputComment: EditText




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val v:View = inflater.inflate(R.layout.fragment_add_expense, container, false)
        btnAddExpenseBack = v.findViewById(R.id.btn_add_expense_back)
        showTypesMenu = v.findViewById(R.id.show_types_menu)
        btnAddExpense = v.findViewById(R.id.btn_add_expense)
        inputPrice = v.findViewById(R.id.input_price)
        inputComment = v.findViewById(R.id.input_comment)
        popupMenu = PopupMenu(context, showTypesMenu)
        popupMenu.menuInflater.inflate(R.menu.add_expense_type_menu, popupMenu.menu)

        return v
    }

    @SuppressLint("ResourceAsColor")
    override fun onStart() {
        super.onStart()
        val addExpenseViewModel = ViewModelProvider(this).get(AddExpenseViewModel::class.java)

        btnAddExpenseBack.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_addExpenseFragment_to_mainFragment)
        }
        btnAddExpense.setOnClickListener {
            addExpenseViewModel.addExpense(title = showTypesMenu.text.toString(),
                price = inputPrice.text.toString().toDouble(),
                quantity = 1,
                comment = inputComment.text.toString())
            Toast.makeText(requireContext(),"Расход добавлен",LENGTH_SHORT).show()
        }
        popupMenu.setOnMenuItemClickListener {

            when (it.itemId) {
                R.id.wash_type -> {
                    showTypesMenu.text = "Мойка"
                }
                R.id.parking_type -> {
                    showTypesMenu.text = "Парковка"
                }
                R.id.fuel_type -> {
                    showTypesMenu.text = "Топливо"
                }
            }
            false
        }
        showTypesMenu.setOnClickListener{
            popupMenu.show()
        }

    }

}