package net.demo.ip.api.data.di

import net.demo.ip.api.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val netWorkModule = module {
    single { createRetrofit(get()) }
    single { provideOkHttpClient() }
}

internal fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val builder = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
    return builder.build()
}

private fun provideOkHttpClient(): OkHttpClient {
    val build = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
        build.addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }
    return build.build()
}