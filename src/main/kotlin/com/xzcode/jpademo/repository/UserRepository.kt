package com.xzcode.jpademo.repository

import com.xzcode.jpademo.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
