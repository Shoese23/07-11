import java.io.File
import java.time.LocalDate

class TaskManager {
    val tasks = mutableListOf<Tasks>()
    var nextId = 1

    fun addTask(title: String, description: String, category: String, priority: Priority, dueDate: String): Tasks {
        val task = Tasks(nextId++, title, description, category, priority, dueDate, false, LocalDate.now().toString())
        tasks.add(task)
        return task
    }
    fun addTasks() {
        print("Название: ")
        val title = readlnOrNull() ?: return
        print("Описание: ")
        val description = readlnOrNull() ?: return

        print("Категория: ")
        val category = readlnOrNull() ?: return

        print("Приоритет (HIGH/MEDIUM/LOW): ")
        val priorityStr = readlnOrNull() ?: return
        val priority = try {
            Priority.valueOf(priorityStr.uppercase())
        } catch (e: IllegalArgumentException) {
            println("Неверный приоритет. Используйте: HIGH, MEDIUM, LOW")
            return }

        print("Срок выполнения: ")
        val dueDate = readlnOrNull() ?: return

        val task1 = addTask(title, description, category, priority, dueDate)
        println("Задача добавлена (ID: ${task1.id})")
    }


    fun all(): String {
        val result = tasks.joinToString("\n")
        print("$result")
        return result}

    fun save(){
        val file = File("tasks.txt")
        val res = all()
        file.writeText("$res")}

    fun findTitle(title: String): List<Tasks> {
        return tasks.filter { it.title.contains(title, ignoreCase = true) }
    }
    fun findCategory(category: String): List<Tasks> {
        return tasks.filter { it.category.contains(category, ignoreCase = true) }
    }
    fun findPriority(priority: Priority): List<Tasks> {
        return tasks.filter { it.priority == priority }
    }
    fun findTask() {
        print("Искать по названию, категории или приоритету? (title/category/priority): ")
        val type = readlnOrNull() ?: return

        print("Введите запрос: ")
        val query = readlnOrNull() ?: return

        when (type.lowercase()) {
            "title" -> findTitle(query).forEach { print(it) }
            "category" -> findCategory(query).forEach { print(it) }
            "priority" -> {
                val priority = try {
                    Priority.valueOf(query.uppercase())
                } catch (e: IllegalArgumentException) {
                    println("Неверный приоритет. Используйте: HIGH, MEDIUM, LOW")
                    return
                }
            }
        }
    }

    fun mark(id: Int, completed: Boolean = true): Boolean {
        val task = tasks.find { it.id == id } ?: return false
        task.isCompleted = completed
        return true
    }
    fun completed() {
        print("Введите ID задачи для отметки: ")
        val id = readlnOrNull()?.toIntOrNull() ?: return

        if (mark(id)) {
            println("Задача отмечена как выполненная!")
        } else {
            println("Задача с таким ID не найдена.")
        }
    }

    fun deleteTask(id: Int): Boolean {
        val task = tasks.find { it.id == id } ?: return false
        tasks.remove(task)
        return true
    }
    fun deleteTasks() {
        print("Введите ID задачи для удаления: ")
        val id = readlnOrNull()?.toIntOrNull() ?: return

        if (deleteTask(id)) {
            println("Задача удалена!")
        } else {
            println("Задача с таким ID не найдена.")
        }
    }

    fun stats(): Map<String, Int> {
        return mapOf(
            "total" to tasks.size,
            "completed" to tasks.count { it.isCompleted },
            "pending" to tasks.count { !it.isCompleted }
        )
    }
    fun showStats() {
        val stats = stats()
        println("\n=== СТАТИСТИКА ===")
        println("Всего задач: ${stats["total"]}")
        println("Выполнено: ${stats["completed"]}")
        println("В работе: ${stats["pending"]}")
    }

}