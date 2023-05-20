package io.traqueno.service.provider.entity.service

import io.traqueno.service.provider.entity.exception.NotFoundException
import io.traqueno.service.provider.entity.model.ServiceProviderCategory
import io.traqueno.service.provider.entity.repository.CategoryRepository
import io.traqueno.service.provider.entity.request.ServiceProviderCategoryRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    fun createServiceProviderCategory(request: ServiceProviderCategoryRequest): ServiceProviderCategory =
        categoryRepository.save(
            ServiceProviderCategory(
                id = UUID.randomUUID().toString(),
                name = request.name,
                imgUrl = request.imgUrl
            )
        )

    fun findAll(): List<ServiceProviderCategory> =
        categoryRepository.findAll()

    fun findById(id: String): ServiceProviderCategory =
        categoryRepository.findById(id)
            .orElseThrow { NotFoundException("Service Provider Category with id $id not found") }

}