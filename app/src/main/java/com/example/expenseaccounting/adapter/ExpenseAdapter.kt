package com.example.expenseaccounting.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expenseaccounting.R
import com.example.expenseaccounting.data.remote.expense.ExpenseAccountingApi
import com.example.expenseaccounting.data.remote.expense.ExpenseAccountingResponse

class ExpenseAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var expenseList: List<ExpenseAccountingResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.last_expense_item, parent, false)
        return AddExpenseViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AddExpenseViewHolder) {
            holder.bind(expenseResponse = expenseList[position])
        }
    }

    override fun getItemCount(): Int {
        return expenseList.count()
    }

    fun setData(newExpenseList: List<ExpenseAccountingResponse>){
        expenseList = newExpenseList
        notifyDataSetChanged()
    }
}

class AddExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private var date: TextView = itemView.findViewById(R.id.txt_date_expense)
    private var typeExpense : TextView = itemView.findViewById(R.id.txt_type_expense)
    private var costExpense : TextView = itemView.findViewById(R.id.txt_cost_expense)

    fun bind(expenseResponse: ExpenseAccountingResponse) {
        date.text = "${expenseResponse.date}"
        typeExpense.text = expenseResponse.title
        costExpense.text = "${expenseResponse.quantity}"

    }
}