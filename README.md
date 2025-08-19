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


///
Task Manager 📝
Um sistema de gerenciamento de tarefas em linha de comando desenvolvido em Kotlin, permitindo criar, editar, deletar e organizar suas tarefas de forma eficiente.
🚀 Funcionalidades

✅ Adicionar Tarefas - Crie novas tarefas com título, descrição, data de vencimento e prioridade
✏️ Atualizar Tarefas - Edite qualquer propriedade de uma tarefa existente
🗑️ Deletar Tarefas - Remova tarefas que não são mais necessárias
🔍 Buscar Tarefas - Encontre tarefas específicas pelo ID
🏷️ Filtrar por Status - Visualize tarefas por status (Pendente, Em Progresso, Concluída)
📊 Visualização Organizada - Lista ordenada por status, prioridade e data de vencimento

🏗️ Estrutura do Projeto
Enums

Priority: LOW, MEDIUM, HIGH
TaskStatus: PENDING, IN_PROGRESS, COMPLETED
MenuActions: Ações disponíveis no menu

Classes Principais

Task: Data class que representa uma tarefa
TaskManager: Implementa o padrão Repository para gerenciar tarefas
TaskRepository: Interface que define as operações básicas

📋 Como Usar
1. Executando o Programa
bashkotlinc Main.kt -include-runtime -d TaskManager.jar
java -jar TaskManager.jar
2. Menu Principal
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
3. Criando uma Tarefa
Ao selecionar a opção 1, você será solicitado a fornecer:

ID: Identificador único da tarefa
Título: Nome da tarefa (obrigatório)
Descrição: Detalhes da tarefa (opcional)
Data de Vencimento: Formato dd/MM/yyyy
Prioridade: 1 (Baixa), 2 (Média), 3 (Alta)

4. Visualização das Tarefas
As tarefas são exibidas com ícones visuais:

Status: ⏳ (Pendente), 🔄 (Em Progresso), ✅ (Concluída)
Prioridade: 🟢 (Baixa), 🟡 (Média), 🔴 (Alta)

Exemplo: ⏳ 🔴 [1] Finalizar projeto - 25/12/2024
🎯 Funcionalidades Detalhadas
Adicionar Tarefa

Validação de entrada para todos os campos
ID deve ser único e não negativo
Data deve seguir o formato dd/MM/yyyy
Novas tarefas sempre começam com status PENDING

Atualizar Tarefa

Permite manter valores atuais pressionando ENTER
Validação similar à criação de tarefas
Busca a tarefa pelo ID antes de permitir edição

Deletar Tarefa

Remove tarefa pelo ID
Confirma se a operação foi bem-sucedida
Informa caso a tarefa não seja encontrada

Buscar Tarefa

Localiza tarefa específica pelo ID
Exibe informações completas incluindo descrição
Feedback claro caso não seja encontrada

Filtrar por Status

Filtra tarefas por PENDING, IN_PROGRESS ou COMPLETED
Ordena por prioridade e data de vencimento
Mostra contador de tarefas por categoria

Ordenação Inteligente
As tarefas são automaticamente ordenadas por:

Status (Pendente → Em Progresso → Concluída)
Prioridade (Alta → Média → Baixa)
Data de Vencimento (mais próxima primeiro)

🛠️ Tecnologias Utilizadas

Linguagem: Kotlin
Paradigma: Programação Orientada a Objetos
Padrões: Repository Pattern
Data/Hora: Java Time API
