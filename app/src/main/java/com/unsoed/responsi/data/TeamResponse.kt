package com.unsoed.responsi.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamResponse(
    @SerializedName("area")
    val area: Area,

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("shortName")
    val shortName: String,

    @SerializedName("tla")
    val tla: String,

    @SerializedName("crest")
    val crest: String, // URL logo tim

    @SerializedName("address")
    val address: String,

    @SerializedName("website")
    val website: String,

    @SerializedName("founded")
    val founded: Int,

    @SerializedName("clubColors")
    val clubColors: String,

    @SerializedName("venue")
    val venue: String,

    @SerializedName("runningCompetitions")
    val runningCompetitions: List<RunningCompetition>,

    @SerializedName("coach")
    val coach: Coach, // Objek pelatih

    @SerializedName("squad")
    val squad: List<Player> // Daftar pemain
)

data class Area(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("code")
    val code: String,

    @SerializedName("flag")
    val flag: String // URL bendera
)


data class RunningCompetition(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("code")
    val code: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("emblem")
    val emblem: String?
)


data class Coach(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("dateOfBirth")
    val dateOfBirth: String,

    @SerializedName("nationality")
    val nationality: String,

    @SerializedName("contract")
    val contract: Contract
)

data class Contract(
    @SerializedName("start")
    val start: String,

    @SerializedName("until")
    val until: String
)

data class Player(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("position")
    val position: String, // "Goalkeeper", "Defence", "Midfield", "Offence"

    @SerializedName("dateOfBirth")
    val dateOfBirth: String?, // (nullable)

    @SerializedName("nationality")
    val nationality: String
): Serializable