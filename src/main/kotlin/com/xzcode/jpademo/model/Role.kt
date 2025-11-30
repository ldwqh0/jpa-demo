package com.xzcode.jpademo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "t_role_")
class Role : AbstractModel() {

    @Column(name = "name_", length = 50)
    var name: String = ""
}
