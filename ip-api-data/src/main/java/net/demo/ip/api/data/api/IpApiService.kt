package net.demo.ip.api.data.api

import net.demo.ip.api.domain.model.IpDetails
import retrofit2.http.GET
import retrofit2.http.Url

internal interface IpApiService {
    @GET
    suspend fun getIpDetails(@Url ip: String): IpDetails
}