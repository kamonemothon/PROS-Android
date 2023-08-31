package org.junwoo.nemo.ui.screen.planlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.junwoo.nemo.domain.model.Plan
import org.junwoo.nemo.domain.repository.PlanRepository
import javax.inject.Inject

@HiltViewModel
class PlanListViewModel @Inject constructor(
    private val planRepository: PlanRepository
) : ViewModel() {
    private val _planList: MutableStateFlow<List<Plan>> = MutableStateFlow(listOf())
    val planList: StateFlow<List<Plan>>
        get() = _planList

    init {
        getPlanList()
    }

    private fun getPlanList() = viewModelScope.launch {
        val items = planRepository.getAllPlans()
        Log.d("MyTag", items.toString())
        _planList.value = items
    }
}