package com.balaji.kanbanapp.model


import jakarta.persistence.*

@Entity
@Table(name = "ROLES")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    var id: Int? = null,

    @Column(name = "ROLE_NAME", unique = true)
    var name: String
)