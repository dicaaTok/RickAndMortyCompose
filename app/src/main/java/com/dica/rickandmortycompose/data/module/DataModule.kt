package com.dica.rickandmortycompose.data.module


import android.icu.util.TimeUnit
import com.dica.rickandmortycompose.BuildConfig
import com.dica.rickandmortycompose.data.api.CharactersApiService
import com.dica.rickandmortycompose.data.api.EpisodeApiService
import com.dica.rickandmortycompose.data.api.LocationApiService
import com.dica.rickandmortycompose.data.repository.CharactersRepository
import com.dica.rickandmortycompose.data.repository.EpisodeRepository
import com.dica.rickandmortycompose.data.repository.LocationRepository
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module{

        single { provideOkHttpClient() }
        single { provideRetrofit(get()) }
        single<CharactersApiService> { get<Retrofit>().create(CharactersApiService::class.java) }
        single<LocationApiService>{ get<Retrofit>().create(LocationApiService::class.java) }
        single<EpisodeApiService>{ get<Retrofit>().create(EpisodeApiService::class.java) }
        single { CharactersRepository(get()) }
        single { LocationRepository(get()) }
        single { EpisodeRepository(get()) }
}

private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                }).build()

}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
}