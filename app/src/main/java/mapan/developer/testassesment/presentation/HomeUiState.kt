package mapan.developer.testassesment.presentation

import mapan.developer.testassesment.data.source.dto.Document

/***
 * Created By Mohammad Toriq on 10/01/2024
 */
data class HomeUiState (
    val list: ArrayList<Document> = ArrayList(),
    val isLoading: Boolean = false,
    val errorMessage : String = ""
)