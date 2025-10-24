package com.unsoed.responsi.squad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.unsoed.responsi.data.Player
import com.unsoed.responsi.databinding.FragmentPlayerDetailBinding

class PlayerDetailFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    private var player: Player? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            player = it.getSerializable("PLAYER_DATA") as Player?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        player?.let {
            binding.tvDetailName.text = it.name
            binding.tvDetailDob.text = it.dateOfBirth ?: "N/A"
            binding.tvDetailNationality.text = it.nationality
            binding.tvDetailPosition.text = it.position
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(player: Player): PlayerDetailFragment {
            val fragment = PlayerDetailFragment()
            val args = Bundle()
            args.putSerializable("PLAYER_DATA", player)
            fragment.arguments = args
            return fragment
        }
    }
}