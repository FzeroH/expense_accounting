package com.example.expenseaccounting.fragments.dialogfragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.expenseaccounting.R

class FilterDialogFragment : DialogFragment() {

    private lateinit var calendar: CalendarView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.dialog_calendar_fragment,container, false)
        calendar = v.findViewById(R.id.calendar_view)
        return v
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val listener = DialogInterface.OnClickListener { _, which ->
            parentFragmentManager.setFragmentResult(REQUEST_KEY, bundleOf(KEY_RESPONSE to which))
        }

        return AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setView(R.layout.dialog_calendar_fragment)
            .setNegativeButton("No",listener)
            .setPositiveButton("Yes",listener)
            .create()
    }
    
    companion object {
        @JvmStatic val TAG: String = FilterDialogFragment::class.java.simpleName
        @JvmStatic val REQUEST_KEY = "$TAG:defaultRequestKey"
        @JvmStatic val KEY_RESPONSE = "RESPONSE"
    }
}
