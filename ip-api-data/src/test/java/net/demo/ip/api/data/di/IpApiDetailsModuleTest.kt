package net.demo.ip.api.data.di

import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

internal class IpApiDetailsModuleTest : KoinTest {
    @Test
    fun `check data module dependencies`(){
        koinApplication {
            modules(ipApiDataModule)
        }.checkModules()
    }
}