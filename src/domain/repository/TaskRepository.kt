package domain.repository

import domain.model.Task
import domain.model.TaskStatus


interface TaskRepository {
    fun insert(task: Task)
    fun delete(id: Int): Boolean
    fun update(task: Task): Boolean
    fun find(id: Int): Task?
    fun findAll(): List<Task>
    fun findByStatus(status: TaskStatus): List<Task>
}
