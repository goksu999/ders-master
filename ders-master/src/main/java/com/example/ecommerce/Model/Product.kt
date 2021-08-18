package com.example.ecommerce.Model

import org.hibernate.annotations.GenericGenerator
import org.intellij.lang.annotations.Pattern
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name="product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    val id : Int? =1,

    @Column(unique = true)
    val code: String? = "",

    @Column(nullable = false)
    val productName: String? = "",


    var productImage: String? = "",

    val productPrice: BigDecimal? = BigDecimal.ZERO,



    val createdAt: LocalDateTime? = LocalDateTime.now(),

    @Column(nullable = false)
    val updateAt: LocalDateTime? = LocalDateTime.now()









) {
    override fun toString(): String {
        return "Product(productPrice=$productPrice)"
    }
}
