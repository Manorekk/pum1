import kotlin.math.pow

fun checkArmstrong(number: Int): Boolean {
    // Zamieniamy liczbę na listę jej cyfr
    val digits = number.toString().map { it.toString().toInt() }

    // Liczba cyfr w liczbie (potrzebna do potęgowania)
    val power = digits.size

    // Sumujemy każdą cyfrę podniesioną do potęgi równej ilości cyfr
    val sum = digits.sumOf { it.toDouble().pow(power).toInt() }

    // Porównujemy sumę z oryginalną liczbą
    return sum == number
}

fun main() {
    // Pobieramy liczbę od użytkownika
    print("Podaj liczbę: ")
    val number = readLine()?.toIntOrNull() // Wczytujemy liczbę i konwertujemy na Int

    if (number != null) {
        // Sprawdzamy, czy liczba jest liczbą Armstronga
        val result = checkArmstrong(number)
        println("Czy $number jest liczbą Armstronga? $result")
    } else {
        println("Niepoprawna liczba. Wprowadź liczbę całkowitą.")
    }
}

