package mapan.developer.testassesment

import mapan.developer.testassesment.data.source.dto.Document
import retrofit2.http.GET

/***
 * Created By Mohammad Toriq on 10/01/2024
 */
interface ApiHelper {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getDocuments() : MutableList<Document>
}