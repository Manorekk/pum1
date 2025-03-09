fun foo(n: Int) {
    for (i in 1..n) {
        var output = ""

        if (i % 3 == 0) output += "Trzy"
        if (i % 5 == 0) output += "Piec"
        if (i % 7 == 0) output += "Siedem"
        if (i % 11 == 0) output += "Jedenascie"
        if (i % 13 == 0) output += "Trzynascie"

        if (output.isEmpty()) {
            println(i)
        } else {
            println(output)
        }
    }
}

fun main() {
    foo(15015)
}

