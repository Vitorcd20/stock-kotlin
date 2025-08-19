package presentation.ui

import domain.model.Priority
import domain.model.Task
import domain.model.TaskStatus

import java.time.format.DateTimeFormatter

object MenuDisplay {

    private val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    /**
     * Displays the main menu with all available options
     */
    fun showMainMenu() {
        println(
            """
        +----------------------------------+
        |        TASK MANAGER              |
        +----------------------------------+
        |  1 - Add Task                    |
        |  2 - Update Task                 |
        |  3 - Delete Task                 |
        |  4 - Search Task                 |
        |  5 - Filter by Status            |
        |  6 - Exit                        |
        +----------------------------------+
        """
        )
    }

    /**
     * Displays the current list of tasks
     * @param tasks List of tasks to display
     */
    fun showTaskList(tasks: List<Task>) {
        println("CURRENT TASK LIST:")
        if (tasks.isEmpty()) {
            println("No tasks have been added yet.")
        } else {
            tasks.forEach { task ->
                println("  ${formatTask(task)}")
            }
        }
    }

    /**
     * Displays filtered tasks by status
     * @param tasks List of filtered tasks
     * @param status The status used for filtering
     */
    fun showFilteredTasks(tasks: List<Task>, status: TaskStatus) {
        println("\nTasks with status ${status.name}:")
        if (tasks.isEmpty()) {
            println("No tasks found with this status.")
        } else {
            tasks.forEach { task ->
                println("  ${formatTask(task)}")
            }
        }
    }

    /**
     * Displays detailed information about a single task
     * @param task The task to display details for
     */
    fun showTaskDetails(task: Task) {
        println("Found task:")
        println("  ${formatTask(task)}")
        println("  Description: ${task.description.ifEmpty { "No description" }}")
    }

    /**
     * Displays the status filter menu
     */
    fun showStatusFilterMenu() {
        println("Select status to filter:")
        println("1 - PENDING | 2 - IN PROGRESS | 3 - COMPLETED")
    }

    /**
     * Displays the priority selection menu
     */
    fun showPriorityMenu() {
        println("1 - LOW | 2 - MEDIUM | 3 - HIGH")
    }

    /**
     * Displays the status selection menu
     */
    fun showStatusMenu() {
        println("1 - PENDING | 2 - IN PROGRESS | 3 - COMPLETED")
    }

    /**
     * Displays success messages
     */
    fun showSuccessMessage(action: String) {
        println("Task $action SUCCESSFULLY!")
    }

    /**
     * Displays error messages
     */
    fun showErrorMessage(message: String) {
        println(message)
    }

    /**
     * Displays input prompts
     */
    fun showInputPrompt(fieldName: String, isOptional: Boolean = false) {
        val optionalText = if (isOptional) " (optional)" else ""
        println("Enter the task $fieldName$optionalText:")
    }

    /**
     * Displays update prompts for existing values
     */
    fun showUpdatePrompt(fieldName: String) {
        println("Change the task $fieldName (press ENTER to keep current value):")
    }

    /**
     * Shows prompt for ID input
     */
    fun showIdPrompt(action: String) {
        println("Enter the ID of the task to be $action:")
    }

    /**
     * Shows the exit message
     */
    fun showExitMessage() {
        println("Thank you for using Task Manager. Come back soon!")
    }

    /**
     * Shows continue prompt
     */
    fun showContinuePrompt() {
        println("\nPress ENTER to continue...")
    }

    /**
     * Shows the input arrow prompt
     */
    fun showInputArrow() {
        print("-> ")
    }

    /**
     * Shows action selection prompt
     */
    fun showActionPrompt() {
        println("\nEnter the desired action:")
    }

    /**
     * Formats a task for display with icons and basic information
     * @param task The task to format
     * @return Formatted string representation of the task
     */
    private fun formatTask(task: Task): String {
        val statusIcon = getStatusIcon(task.status)
        val priorityIcon = getPriorityIcon(task.priority)
        val formattedDate = task.dueDate.format(dateFormatter)

        return "$statusIcon $priorityIcon [${task.id}] ${task.title} - $formattedDate"
    }

    /**
     * Returns the appropriate icon for task status
     * @param status The task status
     * @return Icon representing the status
     */
    private fun getStatusIcon(status: TaskStatus): String {
        return when (status) {
            TaskStatus.PENDING -> "⏳"
            TaskStatus.IN_PROGRESS -> "🔄"
            TaskStatus.COMPLETED -> "✅"
        }
    }

    /**
     * Returns the appropriate icon for task priority
     * @param priority The task priority
     * @return Icon representing the priority
     */
    private fun getPriorityIcon(priority: Priority): String {
        return when (priority) {
            Priority.LOW -> "🟢"
            Priority.MEDIUM -> "🟡"
            Priority.HIGH -> "🔴"
        }
    }


    object ErrorMessages {
        const val INVALID_ID = "Invalid ID entered. Try again."
        const val INVALID_ID_OR_NOT_EXISTS = "Invalid ID entered or task doesn't exist. Try again."
        const val INVALID_TITLE = "Invalid TITLE entered. Try again."
        const val INVALID_DATE = "Invalid date. Use dd/MM/yyyy format. Try again."
        const val INVALID_OPTION = "Invalid option. Try again."
        const val TASK_NOT_FOUND = "No task exists with this ID."
        const val INVALID_MENU_OPTION = "Invalid option. Try again."
    }

    object SuccessMessages {
        const val TASK_ADDED = "added"
        const val TASK_UPDATED = "updated"
        const val TASK_DELETED = "deleted"
    }
}