package net.demo.ip.api.data

import net.demo.ip.api.data.api.IpApiService
import net.demo.ip.api.data.mappers.toDomainString
import net.demo.ip.api.domain.ResultObj

internal class IpDetailsRepository(private val api: IpApiService) {
    suspend fun fetchDetails(ip: String): ResultObj<String> {
        try {
            return ResultObj.Success(api.getIpDetails(ip).toDomainString())
        } catch (e: Exception){
            return ResultObj.Error(e)
        }
    }
}