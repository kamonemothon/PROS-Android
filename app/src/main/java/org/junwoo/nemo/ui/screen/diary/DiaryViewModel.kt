package org.junwoo.nemo.ui.screen.diary

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.junwoo.nemo.domain.model.Diary
import org.junwoo.nemo.domain.repository.DiaryRepository
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
): ViewModel() {
    private val _diaryList = MutableStateFlow(listOf<Diary>())
    val diaryList: StateFlow<List<Diary>>
        get() = _diaryList

    init {
        getDiaryList()
    }

    private fun getDiaryList() {
        viewModelScope.launch {
            val diary = diaryRepository.getDiaries()
            Log.d("MyTag", diary.toString())
            _diaryList.value = diary
        }
    }
}