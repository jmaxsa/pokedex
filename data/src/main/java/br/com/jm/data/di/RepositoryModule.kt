package br.com.jm.data.di

import br.com.jm.data.api.PokemonApi
import br.com.jm.data.repositories.PokemonRemoteDataSource
import br.com.jm.data.repositories.PokemonRemoteDataSourceImpl
import br.com.jm.data.repositories.PokemonRepositoryImpl
import br.com.jm.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePokemonRepository(
        remoteDataSource: PokemonRemoteDataSource
    ): PokemonRepository {
        return PokemonRepositoryImpl(
            remoteDataSource = remoteDataSource
        )
    }
}