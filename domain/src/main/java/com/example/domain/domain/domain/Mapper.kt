package com.example.domain.domain.domain

interface Mapper<From, To> {
    fun map(from: From): To
}