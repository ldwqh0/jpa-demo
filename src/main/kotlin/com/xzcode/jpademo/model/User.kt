package com.xzcode.jpademo.model

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "t_user_")
class User {

    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "username_", length = 50)
    var username: String = ""

    @Column(name = "password_", length = 64)
    var password: String = ""

    @Column(name = "created_time_")
    val cratedTime: ZonedDateTime = ZonedDateTime.now()

    @Column(name = "last_modified_time_")
    var lastModifiedTime: ZonedDateTime = ZonedDateTime.now()
}
