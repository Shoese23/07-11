class Tasks(val id: Int,
            val title: String,
            val description: String,
            val category: String,
            val priority: Priority,
            val dueDate: String,
            val isCompleted: Boolean = false,
            val createdAt: String)
{

}