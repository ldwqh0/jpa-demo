package com.xzcode.jpademo.controller

import com.xzcode.jpademo.dto.UserDto
import com.xzcode.jpademo.request.UserRequest
import com.xzcode.jpademo.service.UserService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody request: UserRequest): UserDto {
        return userService.save(request)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun update(@PathVariable id: Long, @RequestBody request: UserRequest): UserDto {
        return userService.update(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
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
