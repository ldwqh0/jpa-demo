package com.xzcode.jpademo.service.dto

import com.xzcode.jpademo.dto.UserDto
import com.xzcode.jpademo.model.User

operator fun UserDto.Companion.invoke(model: User): UserDto {
    return model.run {
        UserDto(
            id!!,
            username,
            password,
            cratedTime,
            lastModifiedTime
        )
    }
}
