package com.abit.ricandmorty_hw7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abit.ricandmorty_hw7.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private  lateinit var heroAdapter: HeroAdapter
    private var heroList = arrayListOf<Hero>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        heroList.clear()
        loadData()
        heroAdapter = HeroAdapter(heroList, this ::onClick)
        binding.rvHero.adapter= heroAdapter
    }
    private fun onClick(position:Int){
        val bundleHero= Bundle()
        bundleHero.putSerializable("HERO",heroList)
        bundleHero.putInt("POSITION", position)
        findNavController().navigate(R.id.secondFragment, bundleHero)
    }
    private fun loadData() {
        heroList.add(Hero("Miku", "alive", "https://kartinkin.net/uploads/posts/2021-07/1626223689_19-kartinkin-com-p-mika-pyat-nevest-anime-anime-krasivo-31.jpg"))
        heroList.add(Hero("Itsuki", "alive", "https://z.animecult.org/uploads/attachment/cover/23269/characters_98734.jpg"))
        heroList.add(Hero("Nino", "alive", "https://z.animecult.org/uploads/attachment/cover/23268/characters_98731.jpg"))
        heroList.add(Hero("Ichico", "alive", "https://shikimori.one/system/characters/original/161469.jpg"))
        heroList.add(Hero("Hitler", "dead", "https://cdn.britannica.com/58/129958-050-C3FE2DD2/Adolf-Hitler-1933.jpg"))
        heroList.add(Hero("Obama", "alive", "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTE4MDAzNDEwNzg5ODI4MTEw/barack-obama-12782369-1-402.jpg"))
        heroList.add(Hero("Stalin", "dead", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9b/CroppedStalin1943.jpg/274px-CroppedStalin1943.jpg"))
       }

}