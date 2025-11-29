package com.xzcode.jpademo.service

import com.xzcode.jpademo.dto.UserDto
import com.xzcode.jpademo.request.UserRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedModel

interface UserService {
    fun save(request: UserRequest): UserDto
    fun update(id: Long, request: UserRequest): UserDto
    fun delete(id: Long)
    fun findById(id: Long): UserDto?
    fun find(pageable: Pageable): PagedModel<UserDto>
}
