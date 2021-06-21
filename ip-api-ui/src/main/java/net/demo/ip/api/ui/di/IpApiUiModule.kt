package net.demo.ip.api.ui.di

import net.demo.ip.api.ui.details.di.detailsModule
import net.demo.ip.api.ui.home.di.homeModule

val ipApiUiModule = listOf(detailsModule, homeModule)