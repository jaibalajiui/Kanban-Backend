package com.balaji.kanbanapp.model

import jakarta.persistence.*


@Entity
@Table(name = "PERSON")
data class Person (

    @Id
    @Column(name = "PERSON_ID", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var personId: Int? = null,

    @Column(name = "FIRST_NAME")
    var firstName: String = "",

    @Column(name = "LAST_NAME")
    var lastName: String = "",

    @Column(name = "EMAIL")
    var email: String = "",

    @Column(name = "PASSWORD")
    var password: String = "",

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "PERSON_ROLES",
        joinColumns = [JoinColumn(name = "PERSON_ID")],
        inverseJoinColumns = [JoinColumn(name = "ROLE_ID")]
    )
    var roles: MutableSet<Role> = mutableSetOf()

)