package com.balaji.kanbanapp.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "TASK")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID", nullable = true)
    var id: Int? = null,

    @Column(name = "TASK_NAME")
    var title: String,

    @Column(name = "TASK_DESCRIPTION")
    var description: String? = null,

    @Column(name = "TASK_STATUS")
    var status: String = "TODO",

    @Column(name = "TASK_PRIORITY")
    var priority: String = "LOW",

    @Column(name = "TASK_ASSIGNED_TO")
    var assignedTo: String? = null,

    @Column(name = "TASK_START_DATE")
    var startDate: String? = null,

    @Column(name = "TASK_END_DATE")
    var endDate: String? = null,

) {
    override fun toString(): String {
        return "Task(id=$id, title='$title', description=$description, status='$status', priority='$priority', assignedTo=$assignedTo)"
    }
}