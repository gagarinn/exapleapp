package net.demo.ip.api.data.usecaseimpl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.runBlocking
import net.demo.ip.api.data.di.ipApiDataModule
import net.demo.ip.api.domain.ResultObj
import net.demo.ip.api.domain.usecase.GetIpDetailsUsecase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

internal class GetIpDetailsUsecaseImplTest : KoinTest {
    val getIpDetailsUsecase: GetIpDetailsUsecase by inject()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        startKoin {
            modules(ipApiDataModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun executeInvalid(){
        val validIp = "46.119.150.106"
        runBlocking {
            val result = getIpDetailsUsecase.execute(validIp)
            assert(result is ResultObj.Success)
        }
    }
}