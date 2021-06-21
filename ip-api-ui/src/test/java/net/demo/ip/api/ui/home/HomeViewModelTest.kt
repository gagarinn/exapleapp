package net.demo.ip.api.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertNull
import net.demo.ip.api.ui.home.di.homeModule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class HomeViewModelTest : KoinTest {
    val viewModel: HomeViewModel by inject()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        startKoin {
            modules(homeModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun onIpChanged() {
        // Given
        viewModel.ipValidationError.set(-1)
        assert(viewModel.ipValidationError.get() == -1)
        // When
        viewModel.onIpChanged()
        // Then
        assert(viewModel.ipValidationError.get() == 0)
    }

    @Test
    fun onNextClickedInValid() {
        // Given
        viewModel.requestedIp.set("invalid ip")
        assert(viewModel.ipValidationError.get() == 0)
        // When
        viewModel.onNextClicked()
        // Then
        assert(viewModel.ipValidationError.get() != 0)
        assertNull(viewModel.events.value)
    }

    @Test
    fun onNextClickedValid() {
        // Given
        val validIp = "46.119.150.106"
        viewModel.requestedIp.set(validIp)
        assert(viewModel.ipValidationError.get() == 0)
        assertNull(viewModel.events.value)
        // When
        viewModel.onNextClicked()
        // Then
        assert(viewModel.ipValidationError.get() == 0)
        assert(viewModel.events.value is HomeViewModel.UiEvent.OnNextClicked)
    }
}