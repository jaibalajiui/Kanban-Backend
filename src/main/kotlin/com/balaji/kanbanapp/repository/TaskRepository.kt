package com.balaji.kanbanapp.repository

import com.balaji.kanbanapp.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long> {}