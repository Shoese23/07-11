import kotlin.system.exitProcess
import java.io.File

fun main(){
    val manager = TaskManager()
    val file = File("tasks.txt")
    while(true){
        println("\n=== TO-DO LIST ===\n" +
                "1. Показать все задачи\n" +
                "2. Добавить задачу\n" +
                "3. Найти задачу\n" +
                "4. Отметить как выполненную\n" +
                "5. Удалить задачу\n" +
                "6. Статистика\n" +
                "0. Выход")
        print("Выберите цифры:")
        val read = readln()

        when(read){
            "1" -> manager.all()
            "2" -> manager.addTasks()
            "3" -> manager.findTask()
            "4" -> manager.completed()
            "5" -> manager.deleteTasks()
            "6" -> manager.showStats()
            "0" -> { manager.saveToFile()
                println("До свидания!")
                return}
            else -> {
                println("ERROR")
        }
    }
}
}