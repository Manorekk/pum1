fun sumOfDivisors(number: Int): Int {
    var sum = 0
    for (i in 1 until number) {
        if (number % i == 0) {
            sum += i
        }
    }
    return sum
}

fun classifyNumber(number: Int): String {
    val sumDivisors = sumOfDivisors(number)
    return when {
        sumDivisors == number -> "doskonała"
        sumDivisors > number -> "obfita"
        else -> "niedomiarowa"
    }
}

fun main() {
    val number1: Int = 28
    println("$number1: " + classifyNumber(number1))  // doskonala

    val number2: Int = 12
    println("$number2: " + classifyNumber(number2))  // obfita

    val number3: Int = 8
    println("$number3: " + classifyNumber(number3))  // niedomiarowa
}