package mapan.developer.testassesment.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mapan.developer.testassesment.ApiHelper
import mapan.developer.testassesment.data.repository.RepositoryImpl
import mapan.developer.testassesment.domain.repository.Repository
import javax.inject.Singleton

/***
 * Created By Mohammad Toriq on 10/01/2024
 */
@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Provides
    @Singleton
    fun provideRepositoryImpl(
        apiHelper: ApiHelper,
    ): Repository = RepositoryImpl(apiHelper)

}