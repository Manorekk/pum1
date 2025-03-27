// Zadanie 1: Funkcja anonimowa powtarzająca string 'i' razy
val r: (String, Int) -> String = { s, i -> s.repeat(i) }


// Zadanie 2: Rozszerzenia listy (head i tail)

// Właściwość zwracająca ogon listy (wszystkie elementy poza pierwszym)
val <T> List<T>.tail: List<T>
    get() = if (this.isNotEmpty()) this.drop(1) else emptyList()

// Właściwość zwracająca pierwszy element listy
val <T> List<T>.head: T
    get() = this.first()


// Zadanie 3: Funkcja sprawdzająca, czy lista jest posortowana według podanego porządku
fun <A> isSorted(lst: List<A>, order: (A, A) -> Boolean): Boolean {
    // zipWithNext() tworzy listę par sąsiadujących elementów
    // all { (a, b) -> order(a, b) } sprawdza, czy każda para spełnia warunek sortowania
    return lst.zipWithNext().all { (a, b) -> order(a, b) }
}


// Zadanie 4: Przenosi ostatni element listy na początek
fun <A> tailToHead(lst: List<A>): List<A> {
    if (lst.isEmpty()) throw IllegalStateException("Empty list") // Obsługa pustej listy
    // Tworzy nową listę: ostatni element na początku + reszta listy bez ostatniego elementu
    return listOf(lst.last()) + lst.dropLast(1)
}


// Zadanie 5: Zmienia pierwszy element listy na podany element
fun <A> setHead(lst: List<A>, item: A): List<A> {
    if (lst.isEmpty()) return listOf(item) // Jeśli lista jest pusta, zwracamy listę z jednym elementem
    // Tworzy nową listę, zastępując pierwszy element i zachowując resztę listy
    return listOf(item) + lst.drop(1)
}


// Zadanie 7: Znajduje pierwszą liczbę, której nie da się uzyskać jako sumy dwóch z N poprzednich
fun check(N: Int, list: List<Int>): Int {
    for (i in N until list.size) { // Iterujemy od N-tego elementu do końca listy
        val preamble = list.subList(i - N, i).toSet() // Pobieramy N poprzednich elementów jako zbiór
        val target = list[i] // Liczba, którą sprawdzamy
        // Sprawdzamy, czy istnieją dwie różne liczby w preamble, których suma daje target
        if (!preamble.any { num -> target - num in preamble }) {
            return target // Jeśli nie znaleziono takiej sumy, zwracamy target
        }
    }
    return -1 // Jeśli wszystkie liczby spełniają warunek, zwracamy -1
}


// Funkcja główna uruchamiająca program i testująca rozwiązania
fun main() {
    println("Zadanie 1")
    println("r(\"a\", 3) -> ${r("a", 3)}\n")

    println("Zadanie 2")
    val list = listOf(1, 2, 3, 4, 5)
    println(list)
    println("list.head -> ${list.head}\n")
    println("list.tail -> ${list.tail}\n")

    println("Zadanie 3")
    println("isSorted(listOf(1, 2, 3, 4))\n")
    println("${isSorted(listOf(1, 2, 3, 4)) { i, j -> i < j }}\n")

    println("Zadanie 4")
    println("tailToHead(listOf(1, 2, 3))")
    println("${tailToHead(listOf(1,2,3))}\n")

    println("Zadanie 5")
    println("setHead(listOf(1, 2, 3), 5)\n")
    println("${setHead(listOf(1, 2, 3), 6)}\n")

    println("Zadanie 7")
    println("check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576))")
    println("${check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576))}\n")
    println("check(3, listOf(2, 3, 5, 7, 12, 30))")
    println("${check(3,listOf(2,3,5,7,12,30))}\n")
}
