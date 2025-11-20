import kotlin.system.exitProcess

fun main(){
    println("=== TO-DO LIST ===\n" +
            "1. Показать все задачи\n" +
            "2. Добавить задачу\n" +
            "3. Найти задачу\n" +
            "4. Отметить как выполненную\n" +
            "5. Удалить задачу\n" +
            "6. Статистика\n" +
            "0. Выход")
    val read = readln()
    when(read){
        "1" -> 11
        "2" -> 22
        "3" -> 33
        "4" -> 44
        "5" -> 55
        "6" -> 66
        "0" -> exitProcess(1)
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }

}