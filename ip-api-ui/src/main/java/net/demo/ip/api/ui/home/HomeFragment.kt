package net.demo.ip.api.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import net.demo.ip.api.ui.R
import net.demo.ip.api.ui.databinding.HomeFragmentBinding
import net.demo.ip.api.ui.details.toBundle
import net.demo.ip.api.ui.home.HomeViewModel.UiEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

     val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = HomeFragmentBinding.inflate(inflater)
            .also {
                it.viewModel = viewModel
                it.lifecycleOwner = viewLifecycleOwner
            }
        viewModel.events.observe(viewLifecycleOwner, Observer { handleEvent(it) })
        return binding.root
    }

    private fun handleEvent(uiEvent: UiEvent) {
        when(uiEvent) {
            is UiEvent.OnNextClicked -> navigateToDetail(uiEvent.requestedIp)
        }
    }

    private fun navigateToDetail(requestedIp: String) {
        findNavController().navigate(R.id.action_home_to_ip_details, requestedIp.toBundle())
    }
}