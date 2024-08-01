package project.app.msmesol.presentation.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import project.app.msmesol.data.Tag
import project.app.msmesol.data.categories
import project.app.msmesol.domain.FireStoreUploader
import project.app.msmesol.domain.FirebaseFileUploader
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
) : AndroidViewModel(application = application) {

    val itemSelected = mutableStateOf<Tag?>(null)

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    val tagsList = mutableStateListOf<Tag>()
    val selectedTags = mutableStateListOf<Tag>()

    val showTips = mutableStateOf(false)

    val tagsSearch = listOf(
        "Clothing",
        "Electronics",
        "Furniture",
        "Home",
        "Jewelry",
        "Food & Beverage",
        "Health & Beauty",
        "Sports & Outdoors",
        "Toys & Games",
        "Automotive",
        "Industrial",
        "Office",
        "Construction",
        "Agriculture",
        "Textiles",
        "Other",
    ).asSequence()
        .asFlow()
        .onEach { delay(3000) }

    private val _tags = MutableStateFlow(categories)
    val tags = searchText
        .debounce(100)
        .onEach { _isSearching.update { true } }
        .combine(_tags) { text, tags ->
            if (text.isBlank()) {
                tags
            } else {
                tags.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _tags.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}