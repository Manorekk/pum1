// Funkcja generująca trójkąt Pascala o zadanej wysokości
fun generatePascal(height: Int): List<List<Int>> {
    val triangle = mutableListOf<List<Int>>() // Lista przechowująca kolejne wiersze trójkąta Pascala

    for (i in 0 until height) { // Iteracja po kolejnych poziomach trójkąta
        val row = mutableListOf(1)
        if (i > 0) { // Dla wierszy poza pierwszym
            val prevRow = triangle[i - 1] // Pobieramy poprzedni wiersz
            for (j in 1 until i) { // Obliczamy wartości środkowe wiersza
                row.add(prevRow[j - 1] + prevRow[j]) // Suma dwóch elementów powyżej
            }
            row.add(1) // Każdy wiersz kończy się jedynką
        }
        triangle.add(row) // Dodajemy wiersz do listy
    }

    return triangle // Zwracamy wygenerowany trójkąt Pascala
}

// Funkcja wyświetlająca trójkąt Pascala w formie symetrycznej
fun printPascal(height: Int) {
    val triangle = generatePascal(height) // Generujemy trójkąt Pascala
    val maxWidth = triangle.last().joinToString(" ").length // Obliczamy szerokość ostatniego wiersza

    for (row in triangle) { // Iteracja po wierszach trójkąta
        val rowStr = row.joinToString(" ") // Konwersja wiersza na string
        val padding = " ".repeat((maxWidth - rowStr.length) / 2) // Obliczenie wcięcia dla wyrównania do środka
        println("$padding$rowStr") // Wypisanie wiersza z odpowiednim wcięciem
    }
}

// Funkcja główna programu
fun main() {
    val height = 10 // Ustalona wysokość trójkąta Pascala
    printPascal(height) // Wywołanie funkcji do wyświetlenia trójkąta
}

