package net.demo.ip.api.data.usecaseimpl

import net.demo.ip.api.data.IpDetailsRepository
import net.demo.ip.api.domain.usecase.GetIpDetailsUsecase

internal class GetIpDetailsUsecaseImpl(val repository: IpDetailsRepository): GetIpDetailsUsecase {
    override suspend fun execute(ip: String) = repository.fetchDetails(ip)
}