package net.demo.ip.api.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.demo.ip.api.ui.databinding.FragmentIpDetailsBinding
import net.demo.ip.api.ui.details.IpDetailsFragment.Companion.IP_AGR_KEY
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class IpDetailsFragment : Fragment() {

    companion object {
        const val IP_AGR_KEY = "IP_AGR_KEY"
        fun newInstance() = IpDetailsFragment()
    }

    private  val viewModel: IpDetailsViewModel by viewModel{
        parametersOf(arguments?.getIp() ?: "")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentIpDetailsBinding.inflate(inflater)
            .also {
                it.viewModel = viewModel
                it.lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }
}

fun String.toBundle(): Bundle {
    val bundle = Bundle()
    bundle.putString(IP_AGR_KEY, this)
    return bundle
}

fun Bundle.getIp() : String? {
    return this.getString(IP_AGR_KEY)
}