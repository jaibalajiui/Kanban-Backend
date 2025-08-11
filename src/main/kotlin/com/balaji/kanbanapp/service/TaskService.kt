package com.balaji.kanbanapp.service

import com.balaji.kanbanapp.dto.TaskDto
import com.balaji.kanbanapp.model.Task
import com.balaji.kanbanapp.repository.TaskRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class TaskService(val taskRepository: TaskRepository) {

    // This service can be used to implement business logic related to tasks
    // For example, methods to create, update, delete, and retrieve tasks can be added here

    // Example method to get all tasks (to be implemented)
    fun getAllTasks(): ResponseEntity<Any> {
        val taskResult = taskRepository.findAll()
        if( taskResult.isEmpty()) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }else {
            // Placeholder implementation
            val taskResultDto = taskResult.map {
                TaskDto(it.id, it.title, it.description, it.status, it.priority, it.assignedTo,it.startDate,it.endDate, )
            }
            return ResponseEntity(taskResultDto, HttpStatus.OK)
        }
    }

    fun getTaskById(id: Long): ResponseEntity<Any> {
        val resultTask = taskRepository.findById(id)
        if(resultTask.isPresent) {
            return ResponseEntity(resultTask, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }
    // Example method to add a task (to be implemented)
    fun addTask(task: Task) : ResponseEntity<Any> {
        val createdTask = taskRepository.save(task)
        return ResponseEntity(createdTask, HttpStatus.CREATED)

    }

    fun modifyTask(id: Long, updatedTask: TaskDto): ResponseEntity<Any>{
        val existingTask = taskRepository.findById(id).orElse(null)

         existingTask?.let{
            it.title = updatedTask.taskName
            it.status = updatedTask.status
            it.priority = updatedTask.priority
            it.description = updatedTask.taskDescription
            it.startDate = updatedTask.startDate
            it.endDate = updatedTask.endDate
            it.assignedTo = updatedTask.assignedTo
            taskRepository.save(it)
            return ResponseEntity(it, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }
}