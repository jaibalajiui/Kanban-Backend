package com.balaji.kanbanapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KanbanAppApplication

fun main(args: Array<String>) {
    runApplication<KanbanAppApplication>(*args)
}
