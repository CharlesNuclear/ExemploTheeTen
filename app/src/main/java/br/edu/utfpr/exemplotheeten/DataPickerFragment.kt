package br.edu.utfpr.exemplotheeten

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import org.threeten.bp.LocalDate

class DataPickerFragment(val callback: (result: LocalDate) -> Unit) : Fragment(), DatePickerDialog.OnDateSetListener{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.datapicker_fragment, container, false)

        return view
    }

    override fun onDateSet(picker: DatePicker?, year: Int, month: Int, day: Int) {
        //callback( LocalDate(year, month, day))

    }


}