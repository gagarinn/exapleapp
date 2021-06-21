package net.demo.ip.api.data.di

import net.demo.ip.api.data.IpDetailsRepository
import net.demo.ip.api.data.usecaseimpl.GetIpDetailsUsecaseImpl
import net.demo.ip.api.domain.usecase.GetIpDetailsUsecase
import org.koin.dsl.module

internal val dataModule = module {
    single { IpDetailsRepository(get()) }
    single<GetIpDetailsUsecase> { GetIpDetailsUsecaseImpl(get()) }
}