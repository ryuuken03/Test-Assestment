package mapan.developer.testassesment.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import mapan.developer.testassesment.data.source.Resource
import mapan.developer.testassesment.data.source.dto.Document
import mapan.developer.testassesment.domain.usecase.GetDocuments
import javax.inject.Inject

/***
 * Created By Mohammad Toriq on 10/01/2024
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDocuments: GetDocuments
) : ViewModel()  {


    private val _state = mutableStateOf(HomeUiState())
    val state: State<HomeUiState> = _state
    var isInit = false

    init {
        if(!isInit){
            isInit = true
            getData()
        }
    }

    fun getData() {
        viewModelScope.launch {
            getDocuments().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                            _state.value = state.value.copy(
                            list = ArrayList(),
                            isLoading = true,
                            errorMessage = ""
                        )
                    }
                    is Resource.Success -> {
                        var list = ArrayList<Document>()
                        result.data?.forEach{
                            list.add(it)
                        }
                        _state.value = state.value.copy(
                            list = list,
                            isLoading = false,
                            errorMessage = ""
                        )
                    }
                    is Resource.Error -> {

                        _state.value = state.value.copy(
                            list = ArrayList(),
                            isLoading = false,
                            errorMessage = "Failed Connected To API Server"
                        )

                    }
                }
            }.launchIn(this)
        }
    }
}