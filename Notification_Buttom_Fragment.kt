package com.blaziee.blaziee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.blaziee.blaziee.adaptar.notificationadaptar
import com.blaziee.blaziee.databinding.FragmentNotificationButtomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Notification_Buttom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationButtomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentNotificationButtomBinding.inflate(layoutInflater,container,false)
        val notification= listOf("Your order has been Canceled Successfully","Order has been taken by the driver","Congrats Your Order Placed")
        val notificationImage= listOf(R.drawable.sademoji,R.drawable.icon__2_,R.drawable.illustration)
        val adt=notificationadaptar(ArrayList(notification), ArrayList(notificationImage))
        binding.notirv.layoutManager=LinearLayoutManager(requireContext())
        binding.notirv.adapter=adt
        return binding.root
    }

    companion object {

    }
}