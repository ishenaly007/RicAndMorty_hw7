package com.abit.ricandmorty_hw7

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.abit.ricandmorty_hw7.databinding.ItemHeroBinding
import com.bumptech.glide.Glide

class HeroAdapter(
    private var herolist: List<Hero>,
    val onClick:(position:Int) ->Unit
) : Adapter<HeroAdapter.HeroViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(ItemHeroBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
       holder.bind(herolist[position])
    }

    override fun getItemCount(): Int = herolist.size

    inner class HeroViewHolder(
        private val binding: ItemHeroBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
            binding.tvName.text = hero.name
            binding.tvStatus.text = hero.status
            Glide.with(binding.ivAvatar).load(hero.image).into(binding.ivAvatar)
        }
    }
}
