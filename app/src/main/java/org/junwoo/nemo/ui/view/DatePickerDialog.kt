package org.junwoo.nemo.ui.view

import android.view.LayoutInflater
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
fun DiaryDatePickerDialog(
    onDialogDismissed: () -> Unit,
    year: Int,
    month: Int,
    day: Int,
    onDateSelected: (Int, Int, Int) -> Unit,
) {
    var selectedYear by remember { mutableStateOf(year) }
    var selectedMonth by remember { mutableStateOf(month) }
    var selectedDay by remember { mutableStateOf(day) }
    Surface {

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "시간 설정")
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    modifier = Modifier.size(16.dp)
                        .clickable { onDialogDismissed() },
                    imageVector = Icons.Default.Clear,
                    contentDescription = null
                )
            }
            AndroidView(
                modifier = Modifier.fillMaxWidth(),
                factory = { context ->
                    val view = LayoutInflater.from(context).inflate(R.layout.datepicker_view, null)
                    val datePicker = view.findViewById<DatePicker>(R.id.date_picker)
                    datePicker.init(
                        year,
                        month,
                        day
                    ) { _, year, monthOfYear, dayOfMonth ->
                        selectedYear = year
                        selectedMonth = monthOfYear + 1
                        selectedDay = dayOfMonth
                    }
                    datePicker
                }
            )
            Button(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 42.dp),
                onClick = { onDateSelected(selectedYear, selectedMonth, selectedDay) },
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