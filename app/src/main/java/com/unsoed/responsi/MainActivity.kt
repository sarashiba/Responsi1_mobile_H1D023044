package com.unsoed.responsi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.unsoed.responsi.api.ApiClient
import com.unsoed.responsi.data.TeamResponse
import com.unsoed.responsi.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val API_TOKEN = "99269a481b2944d6a05a51ccc2993fe4"

    private var teamData: TeamResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationButtons()
        fetchDataFromApi()
        setupClickListeners()
    }

    private fun setupNavigationButtons() {
        binding.navHistory.let {
            it.imgIcon.setImageResource(R.drawable.ic_history)
            it.tvLayout.text = "Club History"
        }
        binding.navCoach.let {
            it.imgIcon.setImageResource(R.drawable.ic_coach)
            it.tvLayout.text = "Head Coach"
        }
        binding.navSquad.let {
            it.imgIcon.setImageResource(R.drawable.ic_group)
            it.tvLayout.text = "Team Squad"
        }
    }


    private fun fetchDataFromApi() {
        lifecycleScope.launch {
            try {
                val response = ApiClient.instance.getTeamDetail(API_TOKEN)

                if (response.isSuccessful) {
                    teamData = response.body()

                    Log.d("MainActivity", "Data Coach: ${teamData?.coach?.name}")
                    Log.d("MainActivity", "Jumlah Pemain: ${teamData?.squad?.size}")
                } else {
                    Log.e("MainActivity", "Error: ${response.message()}")
                    Toast.makeText(this@MainActivity, "Gagal memuat data", Toast.LENGTH_SHORT).show()
                }

            } catch (e: Exception) {
                Log.e("MainActivity", "Exception: ${e.message}")
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupClickListeners() {
        binding.navHistory.root.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        binding.navCoach.root.setOnClickListener {
            if (teamData == null) {
                Toast.makeText(this, "Data belum siap, coba lagi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, CoachActivity::class.java)
            intent.putExtra("COACH_NAME", teamData?.coach?.name)
            intent.putExtra("COACH_NATIONALITY", teamData?.coach?.nationality)
            intent.putExtra("COACH_DOB", teamData?.coach?.dateOfBirth)
            intent.putExtra("COACH_CONTRACT_UNTIL", teamData?.coach?.contract?.until)
            startActivity(intent)
        }

        binding.navSquad.root.setOnClickListener {
            if (teamData == null || teamData?.squad.isNullOrEmpty()) {
                Toast.makeText(this, "Data skuad belum siap, coba lagi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SquadActivity::class.java)

            intent.putExtra("SQUAD_DATA", ArrayList(teamData?.squad))

            startActivity(intent)
        }
    }
}