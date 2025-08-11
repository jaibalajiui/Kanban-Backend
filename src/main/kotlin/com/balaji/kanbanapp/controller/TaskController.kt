package com.balaji.kanbanapp.controller

import com.balaji.kanbanapp.dto.TaskDto
import com.balaji.kanbanapp.model.Task
import com.balaji.kanbanapp.service.TaskService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/api/tasks")
class TaskController(val taskService: TaskService) {

    @GetMapping("/all")
    fun getAllTasks() = taskService.getAllTasks()

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable("id") id: Long) = taskService.getTaskById(id)

    @PostMapping
    fun createTask(@RequestBody task: Task) = taskService.addTask(task)

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody task: TaskDto) = taskService.modifyTask(id, task)
}