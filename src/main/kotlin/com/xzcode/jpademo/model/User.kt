package com.xzcode.jpademo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "t_user_")
class User : AbstractModel() {

    @Column(name = "username_", length = 50)
    var username: String = ""

    @Column(name = "password_", length = 64)
    var password: String = ""

}
