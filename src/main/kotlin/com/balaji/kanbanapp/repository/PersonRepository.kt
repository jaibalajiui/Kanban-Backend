package com.balaji.kanbanapp.repository

import com.balaji.kanbanapp.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {

    fun findByFirstName(firstName: String): List<Person>

    fun findByLastName(lastName: String): List<Person>

    fun findByFirstNameAndLastName(firstName: String, lastName: String): Person?

    fun findByFirstNameContainingIgnoreCase(firstName: String): List<Person>

    fun findByLastNameContainingIgnoreCase(lastName: String): List<Person>
}