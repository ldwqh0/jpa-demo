package com.xzcode.jpademo.request

import java.io.Serializable

data class UserRequest(
    val username: String,
    val password: String,
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = -2436393213022596696L
    }
}
