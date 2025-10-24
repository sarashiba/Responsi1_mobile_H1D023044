package com.unsoed.responsi.squad

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi.R
import com.unsoed.responsi.data.Player
import com.unsoed.responsi.databinding.ItemPlayerBinding


class SquadAdapter(
    private val playerList: List<Player>,
    private val onItemClick: (Player) -> Unit
) : RecyclerView.Adapter<SquadAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = playerList[position]
        holder.bind(player, onItemClick)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    inner class PlayerViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(player: Player, onItemClick: (Player) -> Unit) {

            binding.tvPlayerName.text = player.name
            binding.tvPlayerNationality.text = player.nationality

            val context = binding.root.context
            val colorRes = getColorForPosition(player.position)
            val color = ContextCompat.getColor(context, colorRes)

            binding.itemContainer.setBackgroundColor(color)

            binding.root.setOnClickListener {
                onItemClick(player)
            }
        }
    }

    private fun getColorForPosition(position: String): Int {
        return when {
            position.equals("Goalkeeper", ignoreCase = true) -> R.color.player_yellow

            position.contains("Defence", ignoreCase = true) ||
                    position.contains("Back", ignoreCase = true) -> R.color.player_blue

            position.contains("Midfield", ignoreCase = true) -> R.color.player_green

            position.contains("Forward", ignoreCase = true) ||
                    position.contains("Offence", ignoreCase = true) ||
                    position.contains("Winger", ignoreCase = true) -> R.color.player_red

            else -> android.R.color.darker_gray
        }
    }
}