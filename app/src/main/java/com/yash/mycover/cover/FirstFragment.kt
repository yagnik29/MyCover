package com.yash.mycover.cover

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.yash.mycover.R
import com.yash.mycover.databinding.FragmentFirstBinding
import com.yash.mycover.network.CoverJob
import kotlinx.android.synthetic.main.list_driver_all_job.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        @Suppress("UNUSED_VARIABLE")
        // Inflate the layout for this fragment
        val app = requireNotNull(activity).application
        val binding = FragmentFirstBinding.inflate(inflater)

        binding.setLifecycleOwner(this)


        val viewModelProviderFactory =
            CoverViewModelFactory("application/json", "SST100000000003", app)
        val viewModel =
            ViewModelProviders.of(this, viewModelProviderFactory).get(CoverViewModel::class.java)

        binding.viewModel = viewModel
        binding.listRecycler.adapter =
            CoverAdapter(OnclickListener { coverJobDetail: CoverJob.CoverJobDetail, view: View ->

                when (view.id) {

                    R.id.llExpand -> Log.e("click", "Expand ${coverJobDetail.jobId}")
                    R.id.rlInstructions -> Log.e("click", "instruction ${coverJobDetail.deliveryInstruction}")
                    R.id.rlPick-> Log.e("click", "Pick ${coverJobDetail.pickupDetail?.name}")
                    else -> Log.e("click", "Other")
                }

            })

        return binding.root
    }
}
