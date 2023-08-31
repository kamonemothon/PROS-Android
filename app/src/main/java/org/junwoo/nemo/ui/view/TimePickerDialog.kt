package org.junwoo.nemo.ui.view

import android.view.LayoutInflater
import android.widget.TimePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import org.junwoo.nemo.R
import org.junwoo.nemo.ui.theme.NEPL_BLACK
import org.junwoo.nemo.ui.theme.NEPL_GREEN

@Composable
fun DepartureTimePickerDialog(
    hour: Int,
    minute: Int,
    onDateSelected: (Int, Int) -> Unit,
) {
    Surface {
        var selectedHour by remember { mutableStateOf(hour) }
        var selectedMinute by remember { mutableStateOf(minute) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AndroidView(
                modifier = Modifier.fillMaxWidth(),
                factory = { context ->
                    val view = LayoutInflater.from(context).inflate(R.layout.timepicker_view, null)
                    val timePicker = view.findViewById<TimePicker>(R.id.time_picker)
                    timePicker.apply {
                        setHour(hour)
                        setMinute(minute)
                        setIs24HourView(true)
                        setOnTimeChangedListener { view, hourOfDay, minute ->
                            selectedHour = hourOfDay
                            selectedMinute = minute
                        }
                    }
                    timePicker
                }
            )
            Button(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 42.dp),
                onClick = { onDateSelected(selectedHour, selectedMinute) },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = NEPL_GREEN,
                    contentColor = NEPL_BLACK
                )
            ) {
                Text(text = "확인")
            }
        }
    }
}