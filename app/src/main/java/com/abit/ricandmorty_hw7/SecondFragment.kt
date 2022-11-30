package com.abit.ricandmorty_hw7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abit.ricandmorty_hw7.databinding.ActivityMainBinding
import com.abit.ricandmorty_hw7.databinding.FragmentSecondBinding
import com.bumptech.glide.Glide

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var position = arguments?.getInt("POSITION")
        var heroValue = arguments?.getSerializable("HERO") as ArrayList<Hero>

        binding.tvNameDetail.text=heroValue[position!!].name
        binding.tvStatusDetail.text=heroValue[position!!].status
        Glide.with(binding.ivAvatarDetail).load(heroValue[position].image).into(binding.ivAvatarDetail)
    }

}