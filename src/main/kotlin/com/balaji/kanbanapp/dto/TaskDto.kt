package com.balaji.kanbanapp.dto

data class TaskDto (
    var taskId: Int?,
    var taskName: String,
    var taskDescription: String?,
    var status: String,
    var priority: String,
    var assignedTo: String? = null,
    var startDate: String? = null,
    var endDate: String? = null
)

