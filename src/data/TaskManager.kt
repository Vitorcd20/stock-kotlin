package data

import domain.model.Task
import domain.model.TaskStatus
import domain.repository.TaskRepository

class TaskManager: TaskRepository {
    private val taskList = mutableListOf<Task>()

    override fun insert(item: Task) {
        taskList.add(item)
    }

    override fun delete(id: Int): Boolean {
        return taskList.removeIf { it.id == id }
    }

    override fun find(id: Int): Task? {
        return taskList.find { it.id == id }
    }

    override fun findAll(): List<Task> {
        return taskList.sortedWith(
            compareBy<Task> { it.status.ordinal }
                .thenBy { it.priority.ordinal }
                .thenBy { it.dueDate }
        )
    }

    override fun findByStatus(status: TaskStatus): List<Task> {
        return taskList.filter { it.status == status }
            .sortedWith(
                compareBy<Task> { it.priority.ordinal }
                    .thenBy { it.dueDate }
            )
    }

    override fun update(task: Task): Boolean {
        if (taskList.removeIf { it.id == task.id }) {
            taskList.add(task)
            return true
        } else
            return false
    }
}