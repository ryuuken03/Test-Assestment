package mapan.developer.testassesment.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mapan.developer.testassesment.ApiHelper
import mapan.developer.testassesment.data.source.Resource
import mapan.developer.testassesment.data.source.dto.Document
import mapan.developer.testassesment.domain.repository.Repository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/***
 * Created By Mohammad Toriq on 10/01/2024
 */
@Singleton
class RepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper
) : Repository{
    override fun getDocuments(): Flow<Resource<MutableList<Document>>> = flow {
            emit(Resource.Loading())
            try {
                emit(Resource.Success(apiHelper.getDocuments()))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        message = "Oops, something went wrong!"
                    )
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        message = "Couldn't reach server, check your internet connection."
                    )
                )

        }
    }

}