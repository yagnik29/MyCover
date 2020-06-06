package com.yash.mycover

import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yash.mycover.cover.CoverAdapter
import com.yash.mycover.network.CoverJob


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, marsProperties: List<CoverJob.CoverJobDetail>?) {

    val adapter = recyclerView.adapter as CoverAdapter
    adapter.submitList(marsProperties)

}

@BindingAdapter("pickUpName")
fun bindPickupName(textView: TextView, name: String) {

    textView.text = String.format("Pickup Name: %s", name)


}


@BindingAdapter("pickUpAddress")
fun bindAddress(
    textView: TextView, pickupDetail: CoverJob.CoverJobDetail.PickupDetail
) {

    textView.text = String.format(
        "%s : %s , %s , %s , %s , %s", pickupDetail.address,
        pickupDetail.picklocality, pickupDetail.pickSuburb, pickupDetail.pickstate,
        pickupDetail.pickcountry, pickupDetail.pickpostalcode
    )


}

@BindingAdapter("dropOffName")
fun bindDropOffName(textView: TextView, name: String) {

    textView.text = String.format("To: %s", name)


}

@BindingAdapter("dropOffAddress")
fun bindDropAddress(
    textView: TextView, dropoffDetail: CoverJob.CoverJobDetail.DropoffDetail
) {

    textView.text = String.format(
        "%s : %s , %s , %s , %s , %s", dropoffDetail.address,
        dropoffDetail.droplocality, dropoffDetail.dropcity, dropoffDetail.dropstate,
        dropoffDetail.dropcountry, dropoffDetail.droppostalcode
    )


}