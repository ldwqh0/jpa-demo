package com.xzcode.jpademo.controller

import com.xzcode.jpademo.dto.UserDto
import com.xzcode.jpademo.request.UserRequest
import com.xzcode.jpademo.service.UserService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedModel
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    
    @PostMapping
    fun save(@RequestBody request: UserRequest): UserDto {
        return userService.save(request)
    }
    
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: UserRequest): UserDto {
        return userService.update(id, request)
    }
    
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        userService.delete(id)
    }
    
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): UserDto? {
        return userService.findById(id)
    }
    
    @GetMapping
    fun find(
        pageable: Pageable
    ): PagedModel<UserDto> {
        return userService.find(pageable)
    }
}
