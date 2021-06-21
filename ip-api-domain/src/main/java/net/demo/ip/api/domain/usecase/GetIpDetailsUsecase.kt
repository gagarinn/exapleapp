package net.demo.ip.api.domain.usecase

import net.demo.ip.api.domain.ResultObj

interface GetIpDetailsUsecase {
    suspend fun execute(ip: String) : ResultObj<String>
}