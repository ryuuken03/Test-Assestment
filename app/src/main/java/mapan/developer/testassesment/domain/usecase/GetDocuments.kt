package mapan.developer.testassesment.domain.usecase

import kotlinx.coroutines.flow.Flow
import mapan.developer.testassesment.data.source.Resource
import mapan.developer.testassesment.data.source.dto.Document
import mapan.developer.testassesment.domain.repository.Repository

/***
 * Created By Mohammad Toriq on 10/01/2024
 */
class GetDocuments(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Resource<MutableList<Document>>> {
        return repository.getDocuments()
    }
}