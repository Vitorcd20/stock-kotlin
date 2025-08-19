import data.TaskManager
import presentation.ui.MenuActions
import presentation.ui.MenuDisplay
import presentation.ui.input.UserInputHandler

// 1) structure task definition = create
// data class Task structure task manager
// = class TaskManager

// 2) build menu (visually)

// 3) data input functions - tasks (int, string, date, boolean)

// 4) menu action execution logic


fun main() {
    val taskManager = TaskManager()
    val inputHandler = UserInputHandler()

    var action: Int? = null
    while (action != MenuActions.EXIT.ordinal) {

        MenuDisplay.showMainMenu()

        val tasks = taskManager.findAll()
        MenuDisplay.showTaskList(tasks)

        MenuDisplay.showActionPrompt()
        MenuDisplay.showInputArrow()
        action = readlnOrNull()?.toIntOrNull()

        when (action) {
            MenuActions.ADD_TASK.ordinal -> {
                val task = inputHandler.readTask()
                taskManager.insert(task)
                MenuDisplay.showSuccessMessage(MenuDisplay.SuccessMessages.TASK_ADDED)
            }

            MenuActions.UPDATE_TASK.ordinal -> {
                val id = inputHandler.readTaskIdForUpdate(taskManager)
                id?.let { taskId ->
                    val taskToUpdate = taskManager.find(taskId)
                    taskToUpdate?.let { existingTask ->
                        val updatedTask = inputHandler.readTaskUpdate(existingTask)
                        taskManager.update(updatedTask)
                        MenuDisplay.showSuccessMessage(MenuDisplay.SuccessMessages.TASK_UPDATED)
                    }
                }
            }

            MenuActions.DELETE_TASK.ordinal -> {
                val id = inputHandler.readTaskIdForDelete()
                id?.let { taskId ->
                    val deleted = taskManager.delete(taskId)
                    if (deleted) {
                        MenuDisplay.showSuccessMessage(MenuDisplay.SuccessMessages.TASK_DELETED)
                    } else {
                        MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.TASK_NOT_FOUND)
                    }
                }
            }

            MenuActions.SEARCH_TASK.ordinal -> {
                val id = inputHandler.readTaskIdForSearch()
                id?.let { taskId ->
                    val foundTask = taskManager.find(taskId)
                    if (foundTask != null) {
                        MenuDisplay.showTaskDetails(foundTask)
                    } else {
                        MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.TASK_NOT_FOUND)
                    }
                }
            }

            MenuActions.FILTER_BY_STATUS.ordinal -> {
                val status = inputHandler.readStatusFilter()
                status?.let { filterStatus ->
                    val filteredTasks = taskManager.findByStatus(filterStatus)
                    MenuDisplay.showFilteredTasks(filteredTasks, filterStatus)
                }
            }

            MenuActions.EXIT.ordinal -> {
                MenuDisplay.showExitMessage()
            }

            else -> {
                MenuDisplay.showErrorMessage(MenuDisplay.ErrorMessages.INVALID_MENU_OPTION)
            }
        }

        if (action != MenuActions.EXIT.ordinal) {
            MenuDisplay.showContinuePrompt()
            readlnOrNull()
        }
    }
}