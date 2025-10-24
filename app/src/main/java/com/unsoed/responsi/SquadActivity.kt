package com.unsoed.responsi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.responsi.data.Player
import com.unsoed.responsi.databinding.ActivitySquadBinding
import com.unsoed.responsi.squad.PlayerDetailFragment
import com.unsoed.responsi.squad.SquadAdapter

class SquadActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySquadBinding
    private var playerList: List<Player>? = null
    private lateinit var squadAdapter: SquadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.w("SquadActivity", "Menggunakan getSerializableExtra() yang deprecated")
        playerList = intent.getSerializableExtra("SQUAD_DATA") as? List<Player>

        if (!playerList.isNullOrEmpty()) {
            setupRecyclerView(playerList!!)
        } else {
            Log.e("SquadActivity", "Daftar pemain kosong atau null!")
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView(players: List<Player>) {

        squadAdapter = SquadAdapter(players) { selectedPlayer ->

            val fragment = PlayerDetailFragment.newInstance(selectedPlayer)
            fragment.show(supportFragmentManager, "PlayerDetailFragmentTag")
        }

        binding.rvPlayers.adapter = squadAdapter

        binding.rvPlayers.layoutManager = LinearLayoutManager(this)
    }
}