package com.xzcode.jpademo.dto

import java.io.Serializable
import java.time.ZonedDateTime

/**
 * DTO for {@link com.xzcode.jpademo.model.User}
 */
data class UserDto(
    val id: Long,
    val username: String,
    val password: String,
    val cratedTime: ZonedDateTime,
    val lastModifiedTime: ZonedDateTime
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = -3010093039890233269L
    }
}
