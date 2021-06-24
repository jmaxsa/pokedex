package br.com.jm.data.di

import br.com.jm.data.BuildConfig
import br.com.jm.data.api.PokemonApi
import br.com.jm.data.repositories.PokemonRemoteDataSource
import br.com.jm.data.repositories.PokemonRemoteDataSourceImpl
import br.com.jm.data.repositories.PokemonRepositoryImpl
import br.com.jm.domain.repositories.PokemonRepository
import br.com.jm.domain.usecase.GetPokemonUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource(
        pokemonApi: PokemonApi
    ): PokemonRemoteDataSource {
        return PokemonRemoteDataSourceImpl(
            service = pokemonApi
        )
    }

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pokeapi.co/api/v2/")
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)

    @Singleton
    @Provides
    fun providePokemonUseCase(repository: PokemonRepository): GetPokemonUseCase = GetPokemonUseCase(repository = repository)
}
//}