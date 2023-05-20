package io.traqueno.service.provider.entity.controller

import io.traqueno.service.provider.entity.request.ServiceProviderCategoryRequest
import io.traqueno.service.provider.entity.response.CategoriesResponse
import io.traqueno.service.provider.entity.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/service-provider-category-entity")
class ServiceProviderCategoryController(
    private val categoryService: CategoryService
) {

    @PostMapping("/v1/category/register")
    fun createCompany(@RequestBody request: ServiceProviderCategoryRequest): ResponseEntity<CategoriesResponse> {
        val createdServiceProviderCategory = categoryService.createServiceProviderCategory(request)

        return ResponseEntity
            .ok(
                CategoriesResponse.fromEntity(createdServiceProviderCategory)
            )
    }


    @GetMapping("/v1/category/all")
    fun findAllServiceProvideCategories(): ResponseEntity<List<CategoriesResponse>> {
        val categories = categoryService.findAll()

        return ResponseEntity
            .ok(
                categories.map { CategoriesResponse.fromEntity(it) }
            )
    }

    @GetMapping("/v1/category/{id}")
    fun findCompanyById(@PathVariable id: String): ResponseEntity<CategoriesResponse> {
        val category = categoryService.findById(id)

        return ResponseEntity
            .ok(
                CategoriesResponse.fromEntity(category)
            )
    }

}