package com.xzcode.jpademo.service.impl

import com.xzcode.jpademo.dto.UserDto
import com.xzcode.jpademo.model.User
import com.xzcode.jpademo.repository.UserRepository
import com.xzcode.jpademo.request.UserRequest
import com.xzcode.jpademo.service.UserService
import com.xzcode.jpademo.service.dto.invoke
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.data.web.PagedModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    @Transactional
    override fun save(request: UserRequest): UserDto {
        val user = User().apply {
            username = request.username
            password = request.password
            lastModifiedTime = ZonedDateTime.now()
        }
        val savedUser = userRepository.save(user)
        return UserDto(savedUser)
    }

    @Transactional
    override fun update(id: Long, request: UserRequest): UserDto {
        val user = userRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("用户不存在")
        user.apply {
            username = request.username
            password = request.password
            lastModifiedTime = ZonedDateTime.now()
        }
        val updatedUser = userRepository.save(user)
        return UserDto(updatedUser)
    }

    @Transactional
    override fun delete(id: Long) {
        userRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): UserDto? {
        return userRepository.findByIdOrNull(id)?.let { UserDto(it) }
    }

    @Transactional(readOnly = true)
    override fun find(pageable: Pageable): PagedModel<UserDto> {
        return userRepository.findAll(pageable).map {
            UserDto.Companion(it)
        }.let {
            PagedModel(it)
        }
    }
}
