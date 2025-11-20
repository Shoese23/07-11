data class Tasks(
    val id: Int,
    var title: String,
    var description: String,
    var category: String,
    var priority: Priority,
    var dueDate: String,
    var isCompleted: Boolean = false,
    var createdAt: String
)