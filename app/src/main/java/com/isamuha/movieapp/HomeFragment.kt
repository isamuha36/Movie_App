package com.isamuha.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.isamuha.movieapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieList = listOf(
            Movie(
                title = "Venom: The Last Dance",
                duration = "1h 48m",
                rating = "R",
                genre = "Action",
                poster = R.drawable.venom,
                synopsis = "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating."
            ),
            Movie(
                title = "Dosa Musyrik",
                duration = "1h 32m",
                rating = "D17+",
                genre = "Horror",
                poster = R.drawable.dosa_musyrik,
                synopsis = "A story about struggles against sin and redemption..."
            ),
            Movie(
                title = "Inside Out 2",
                duration = "1h 36m",
                rating = "SU",
                genre = "Animation",
                poster = R.drawable.inside_out,
                synopsis = "An adventure inside Riley's mind with her emotions..."
            ),
            Movie(
                title = "Transformer One",
                duration = "1h 48m",
                rating = "R",
                genre = "Action",
                poster = R.drawable.transformer_one,
                synopsis = "A journey of robots and humans fighting for Earth's future..."
            )
        )


        val adapter = MovieAdapter(movieList)
        binding.recyclerViewMovies.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewMovies.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
