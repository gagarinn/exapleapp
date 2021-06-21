package net.demo.ip.api.ui.home.di

import net.demo.ip.api.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val homeModule = module  {
    viewModel { HomeViewModel() }
}