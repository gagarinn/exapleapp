package net.demo.ip.api.ui.details.di

import net.demo.ip.api.ui.details.IpDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val detailsModule = module  {
    viewModel { (ip: String ) -> IpDetailsViewModel(ip, get()) }
}