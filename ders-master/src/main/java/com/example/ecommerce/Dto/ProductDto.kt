package com.example.ecommerce.Dto

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Column

data class ProductDto(
    val id : Int?,

    val code: String? ,

    val productName: String? ,


    var productImage: String?,

    val productPrice: BigDecimal? ,


    val createdAt: LocalDateTime?,


    val updateAt: LocalDateTime?
)
