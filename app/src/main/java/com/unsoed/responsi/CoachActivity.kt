package com.unsoed.responsi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi.databinding.ActivityCoachBinding

class CoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coachName = intent.getStringExtra("COACH_NAME")
        val coachNationality = intent.getStringExtra("COACH_NATIONALITY")
        val coachDob = intent.getStringExtra("COACH_DOB")
        val coachContractUntil = intent.getStringExtra("COACH_CONTRACT_UNTIL")

        Log.d("CoachActivity", "Nama: $coachName")
        Log.d("CoachActivity", "Kebangsaan: $coachNationality")

        binding.tvCoachName.text = coachName
        binding.tvCoachNationality.text = coachNationality
        binding.tvCoachDob.text = "Born: $coachDob"
        binding.tvCoachContract.text = "Contract until: ${coachContractUntil ?: "N/A"}"

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}