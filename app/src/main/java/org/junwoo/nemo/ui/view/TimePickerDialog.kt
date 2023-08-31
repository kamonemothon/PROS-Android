package org.junwoo.nemo.ui.view

import android.view.LayoutInflater
import android.widget.TimePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.junwoo.nemo.R

@Composable
fun DepartureTimePickerDialog(
    onDialogDismissed: () -> Unit,
    onDateSelected: (Int, Int) -> Unit,
) {
    Surface {
        var selectedHour by remember { mutableStateOf(0) }
        var selectedMinute by remember { mutableStateOf(0) }
        Column {
            AndroidView(
                modifier = Modifier.fillMaxWidth(),
                factory = { context ->
                    val view = LayoutInflater.from(context).inflate(R.layout.datepicker_view, null)
                    val timePicker = view.findViewById<TimePicker>(R.id.time_picker)
                    timePicker.apply {
                        setIs24HourView(true)
                        setOnTimeChangedListener { view, hourOfDay, minute ->
                            selectedMinute = hourOfDay
                            selectedHour = minute
                        }
                    }
                    timePicker
                }
            )
            Button(onClick = {
                onDateSelected(selectedHour, selectedMinute)
            }) {
                Text(text = "확인")
            }
        }
        
        
    }
   
}