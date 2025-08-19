package presentation.ui.input


import data.TaskManager
import domain.model.Priority
import domain.model.Task
import domain.model.TaskStatus
import presentation.ui.MenuDisplay
import utils.DateUtils
import utils.isNullOrNegative
import java.time.LocalDate

class UserInputHandler {

    /**
     * Reads all input needed to create a new task
     * @return A new Task object with user input
     */
    fun readTask(): Task {
        val id = readTaskId()
        val title = readTaskTitle()
        val description = readTaskDescription()
        val dueDate = readTaskDueDate()
        val priority = readTaskPriority()

        return Task(
            id = id,
            title = title,
            description = description,
            dueDate = dueDate,
            priority = priority,
            status = TaskStatus.PENDING // New tasks always start as PENDING
        )
    }

    /**
     * Reads input to update an existing task, allowing user to keep current values
     * @param existingTask The task to be updated
     * @return Updated Task object
     */
    fun readTaskUpdate(existingTask: Task): Task {
        val title = readTaskTitleUpdate(existingTask.title)
        val description = readTaskDescriptionUpdate(existingTask.description)
        val dueDate = readTaskDueDateUpdate(existingTask.dueDate)
        val priority = readTaskPriorityUpdate(existingTask.priority)
        val status = readTaskStatusUpdate(existingTask.status)

        return Task(
            id = existingTask.id,
            title = title,
            description = description,
            dueDate = dueDate,
            priority = priority,
            status = status
        )
    }

    /**
     * Reads task ID for update operation (validates if task exists)
     * @param taskManager TaskManager to validate task existence
     * @return Valid task ID or null if invalid
     */
    fun readTaskIdForUpdate(taskManager: TaskManager): Int? {
        MenuDisplay.showIdPrompt("updated")
        var id: Int? = null

        while (id == null) {
            MenuDisplay.showInputArrow()
            val inputId = readlnOrNull()?.toIntOrNull()

            when {
                inputId.isNullOrNegative() -> {
                    MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_ID)
                }
                taskManager.find(inputId!!) == null -> {
                    MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.TASK_NOT_FOUND)
                }
                else -> {
                    id = inputId
                }
            }
        }
        return id
    }

    /**
     * Reads task ID for delete operation
     * @return Valid task ID or null if invalid
     */
    fun readTaskIdForDelete(): Int? {
        MenuDisplay.showIdPrompt("deleted")
        return readValidId()
    }

    /**
     * Reads task ID for search operation
     * @return Valid task ID or null if invalid
     */
    fun readTaskIdForSearch(): Int? {
        MenuDisplay.showIdPrompt("searched")
        return readValidId()
    }

    /**
     * Reads status filter selection
     * @return Selected TaskStatus or null if invalid
     */
    fun readStatusFilter(): TaskStatus? {
        MenuDisplay.showStatusFilterMenu()
        MenuDisplay.showInputArrow()
        val option = readlnOrNull()?.toIntOrNull()

        return when (option) {
            1 -> TaskStatus.PENDING
            2 -> TaskStatus.IN_PROGRESS
            3 -> TaskStatus.COMPLETED
            else -> {
                MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_OPTION)
                null
            }
        }
    }

    // Private helper methods for reading individual fields

    private fun readTaskId(): Int {
        MenuDisplay.showInputPrompt("ID")
        var id: Int? = null

        while (id.isNullOrNegative()) {
            MenuDisplay.showInputArrow()
            id = readlnOrNull()?.toIntOrNull()
            if (id.isNullOrNegative()) {
                MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_ID)
            }
        }
        return id!!
    }

    private fun readTaskTitle(): String {
        MenuDisplay.showInputPrompt("TITLE")
        var title: String? = null

        while (title.isNullOrBlank()) {
            MenuDisplay.showInputArrow()
            title = readlnOrNull()
            if (title.isNullOrBlank()) {
                MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_TITLE)
            }
        }
        return title!!
    }

    private fun readTaskDescription(): String {
        MenuDisplay.showInputPrompt("DESCRIPTION", isOptional = true)
        MenuDisplay.showInputArrow()
        return readlnOrNull() ?: ""
    }

    private fun readTaskDueDate(): LocalDate {
        MenuDisplay.showInputPrompt("DUE DATE (dd/MM/yyyy)")
        var dueDate: LocalDate? = null

        while (dueDate == null) {
            MenuDisplay.showInputArrow()
            val dateInput = readlnOrNull()
            dueDate = DateUtils.parseDate(dateInput ?: "")
            if (dueDate == null) {
                MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_DATE)
            }
        }
        return dueDate
    }

    private fun readTaskPriority(): Priority {
        MenuDisplay.showInputPrompt("PRIORITY")
        MenuDisplay.showPriorityMenu()
        var priority: Priority? = null

        while (priority == null) {
            MenuDisplay.showInputArrow()
            val option = readlnOrNull()?.toIntOrNull()
            priority = when (option) {
                1 -> Priority.LOW
                2 -> Priority.MEDIUM
                3 -> Priority.HIGH
                else -> {
                    MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_OPTION)
                    null
                }
            }
        }
        return priority
    }

    // Update methods (allow keeping current values)

    private fun readTaskTitleUpdate(currentTitle: String): String {
        MenuDisplay.showUpdatePrompt("TITLE")
        var title: String? = null

        while (title.isNullOrBlank()) {
            MenuDisplay.showInputArrow()
            title = readlnOrNull()?.ifEmpty { currentTitle }
            if (title.isNullOrBlank()) {
                MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_TITLE)
            }
        }
        return title!!
    }

    private fun readTaskDescriptionUpdate(currentDescription: String): String {
        MenuDisplay.showUpdatePrompt("DESCRIPTION")
        MenuDisplay.showInputArrow()
        return readlnOrNull()?.ifEmpty { currentDescription } ?: currentDescription
    }

    private fun readTaskDueDateUpdate(currentDate: LocalDate): LocalDate {
        MenuDisplay.showUpdatePrompt("DUE DATE (dd/MM/yyyy)")
        var dueDate: LocalDate? = null

        while (dueDate == null) {
            MenuDisplay.showInputArrow()
            val dateInput = readlnOrNull()?.ifEmpty { DateUtils.formatDate(currentDate) }
            dueDate = DateUtils.parseDate(dateInput ?: "")
            if (dueDate == null) {
                MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_DATE)
            }
        }
        return dueDate
    }

    private fun readTaskPriorityUpdate(currentPriority: Priority): Priority {
        MenuDisplay.showUpdatePrompt("PRIORITY")
        MenuDisplay.showPriorityMenu()
        var priority: Priority? = null

        while (priority == null) {
            MenuDisplay.showInputArrow()
            val option = readlnOrNull()?.ifEmpty { (currentPriority.ordinal + 1).toString() }?.toIntOrNull()
            priority = when (option) {
                1 -> Priority.LOW
                2 -> Priority.MEDIUM
                3 -> Priority.HIGH
                else -> {
                    MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_OPTION)
                    null
                }
            }
        }
        return priority
    }

    private fun readTaskStatusUpdate(currentStatus: TaskStatus): TaskStatus {
        MenuDisplay.showUpdatePrompt("STATUS")
        MenuDisplay.showStatusMenu()
        var status: TaskStatus? = null

        while (status == null) {
            MenuDisplay.showInputArrow()
            val option = readlnOrNull()?.ifEmpty { (currentStatus.ordinal + 1).toString() }?.toIntOrNull()
            status = when (option) {
                1 -> TaskStatus.PENDING
                2 -> TaskStatus.IN_PROGRESS
                3 -> TaskStatus.COMPLETED
                else -> {
                    MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_OPTION)
                    null
                }
            }
        }
        return status
    }

    private fun readValidId(): Int? {
        var id: Int? = null

        while (id.isNullOrNegative()) {
            MenuDisplay.showInputArrow()
            id = readlnOrNull()?.toIntOrNull()
            if (id.isNullOrNegative()) {
                MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_ID)
            }
        }
        return id
    }
}