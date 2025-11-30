package com.xzcode.jpademo.model

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@MappedSuperclass
abstract class AbstractModel {

    @Id
    @Column(name = "id_")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null

    @Column(name = "created_time_")
    val cratedTime: ZonedDateTime = ZonedDateTime.now()

    @Column(name = "last_modified_time_")
    var lastModifiedTime: ZonedDateTime = ZonedDateTime.now()
}
