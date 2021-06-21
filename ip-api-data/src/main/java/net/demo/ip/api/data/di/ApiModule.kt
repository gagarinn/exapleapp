package net.demo.ip.api.data.di

import net.demo.ip.api.data.api.IpApiService
import org.koin.dsl.module
import retrofit2.Retrofit

internal val apiModule = module {
    factory { provideIpDetailsApi(get()) }
}

internal fun provideIpDetailsApi(retrofit: Retrofit) : IpApiService = retrofit.create(IpApiService::class.java)