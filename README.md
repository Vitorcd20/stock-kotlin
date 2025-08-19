Task Manager 📝
A command-line task management system developed in Kotlin, allowing you to create, edit, delete, and organize your tasks efficiently.
🚀 Features

✅ Add Tasks - Create new tasks with title, description, due date, and priority
✏️ Update Tasks - Edit any property of an existing task
🗑️ Delete Tasks - Remove tasks that are no longer needed
🔍 Search Tasks - Find specific tasks by ID
🏷️ Filter by Status - View tasks by status (Pending, In Progress, Completed)
📊 Organized Display - Sorted list by status, priority, and due date

🏗️ Project Structure
Enums

Priority: LOW, MEDIUM, HIGH
TaskStatus: PENDING, IN_PROGRESS, COMPLETED
MenuActions: Available menu actions

Main Classes

Task: Data class representing a task
TaskManager: Implements Repository pattern to manage tasks
TaskRepository: Interface defining basic operations

📋 How to Use
1. Running the Program
bashkotlinc Main.kt -include-runtime -d TaskManager.jar
java -jar TaskManager.jar
2. Main Menu
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
3. Creating a Task
When selecting option 1, you'll be prompted to provide:

ID: Unique task identifier
Title: Task name (required)
Description: Task details (optional)
Due Date: Format dd/MM/yyyy
Priority: 1 (Low), 2 (Medium), 3 (High)

4. Task Visualization
Tasks are displayed with visual icons:

Status: ⏳ (Pending), 🔄 (In Progress), ✅ (Completed)
Priority: 🟢 (Low), 🟡 (Medium), 🔴 (High)

Example: ⏳ 🔴 [1] Finish project - 25/12/2024
🎯 Detailed Features
Add Task

Input validation for all fields
ID must be unique and non-negative
Date must follow dd/MM/yyyy format
New tasks always start with PENDING status

Update Task

Allows keeping current values by pressing ENTER
Similar validation to task creation
Finds task by ID before allowing editing

Delete Task

Removes task by ID
Confirms if operation was successful
Reports if task is not found

Search Task

Locates specific task by ID
Displays complete information including description
Clear feedback if not found

Filter by Status

Filters tasks by PENDING, IN_PROGRESS, or COMPLETED
Sorts by priority and due date
Shows task counter by category

Smart Sorting
Tasks are automatically sorted by:

Status (Pending → In Progress → Completed)
Priority (High → Medium → Low)
Due Date (closest first)

🛠️ Technologies Used

Language: Kotlin
Paradigm: Object-Oriented Programming
Patterns: Repository Pattern
Date/Time: Java Time API
Paradigma: Programação Orientada a Objetos
Padrões: Repository Pattern
Data/Hora: Java Time API
