package com.example.expenseaccounting.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expenseaccounting.R
import com.example.expenseaccounting.data.remote.expense.model.ExpenseResponseModel

class ExpenseAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var expenseList: List<ExpenseResponseModel> = ArrayList()

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

    fun setData(newExpenseList: List<ExpenseResponseModel>){
        expenseList = newExpenseList
        notifyDataSetChanged()
    }
}

class AddExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private var date: TextView = itemView.findViewById(R.id.txt_date_expense) //TODO: Добавить серриализатор для даты
    private var commentExpense: TextView = itemView.findViewById(R.id.txt_comment_expense)
    private var quantityExpense: TextView = itemView.findViewById(R.id.txt_quantity_expense)
    private var typeExpense : TextView = itemView.findViewById(R.id.txt_type_expense)
    private var costExpense : TextView = itemView.findViewById(R.id.txt_cost_expense)

    @SuppressLint("SetTextI18n")
    fun bind(expenseResponse: ExpenseResponseModel) {
        date.text = expenseResponse.date.substring(0,10)
        commentExpense.text = expenseResponse.comment
        quantityExpense.text = expenseResponse.quantity.toString()
        typeExpense.text = expenseResponse.title
        costExpense.text = "${expenseResponse.price.toUInt()} руб."

        if(commentExpense.text.isNullOrEmpty()){
            commentExpense.visibility = GONE
        }

    }
}