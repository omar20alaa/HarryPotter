package com.example.harrypotter.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.data.api.model.Character
import com.example.harrypotter.data.repository.HarryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val harryRepository: HarryRepository
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<Character>())
    val state: StateFlow<List<Character>>
        get() = _state

    init {
        viewModelScope.launch {
            val characters = harryRepository.getCharacters()
            _state.value = characters
        }
    }

}