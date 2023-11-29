package br.edu.utfpr.exemplotheeten

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.Period
import org.threeten.bp.chrono.ChronoLocalDate
import org.threeten.bp.chrono.ChronoLocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit

class fields_fragment : Fragment() {

    private lateinit var dataPrimaria: EditText
    private lateinit var dataSecundaria: EditText
    private lateinit var horaPrimaria: EditText
    private lateinit var horaSecundaria: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fields_fragment, container, false)

        dataPrimaria   = view.findViewById(R.id.etDataPrimaria)
        dataSecundaria = view.findViewById(R.id.etDataSecundaria)
        horaPrimaria   = view.findViewById(R.id.etHoraPrimaria)
        horaSecundaria = view.findViewById(R.id.etHoraSecundaria)

        return view
    }

    fun calculaData(){
        val datePrimaria: LocalDate =
            LocalDate.parse(dataPrimaria.text.toString(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"))

        val dateSecundaria: LocalDate =
            LocalDate.parse(dataSecundaria.text.toString(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"))

        val horaPrimaria: LocalTime =
            LocalTime.parse(horaPrimaria.text.toString(),
                DateTimeFormatter.ofPattern("HH:mm"))

        val horaSecundaria: LocalTime =
            LocalTime.parse(horaSecundaria.text.toString(),
                DateTimeFormatter.ofPattern("HH:mm"))

        val dateTimePrimario: LocalDateTime =
            LocalDateTime.of(datePrimaria, horaPrimaria)

        val dateTimeSecundaria: LocalDateTime =
            LocalDateTime.of(dateSecundaria, horaSecundaria)

        val period = Period.between(datePrimaria, dateSecundaria)

        val builder = getActivity()?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Tempo Passado")
        builder?.setMessage("Anos passados: ${dateTimePrimario.until(dateTimeSecundaria, ChronoUnit.YEARS)}," +
                            " Meses passados: ${dateTimePrimario.until(dateTimeSecundaria, ChronoUnit.MONTHS)}, " +
                            "Dias Passados: ${dateTimePrimario.until(dateTimeSecundaria, ChronoUnit.DAYS)}")
        builder?.show()
    }

}