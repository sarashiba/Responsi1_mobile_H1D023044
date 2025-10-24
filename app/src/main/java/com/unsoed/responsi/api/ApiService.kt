package com.unsoed.responsi.api

import com.unsoed.responsi.data.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

    @GET("v4/teams/94")
    suspend fun getTeamDetail(
        @Header("X-Auth-Token") apiToken: String
    ): Response<TeamResponse>
}