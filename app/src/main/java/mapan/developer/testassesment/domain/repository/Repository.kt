package mapan.developer.testassesment.domain.repository

import kotlinx.coroutines.flow.Flow
import mapan.developer.testassesment.data.source.Resource
import mapan.developer.testassesment.data.source.dto.Document

/***
 * Created By Mohammad Toriq on 10/01/2024
 */
interface Repository {
    fun getDocuments(
    ): Flow<Resource<MutableList<Document>>>
}