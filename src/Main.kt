import kotlin.random.Random

fun main() {
    var2z1()
    var2z2()
    var2z3()
}


fun var2z1() {
    println("Введіть розмір масиву:")
    val n = readln().toInt()

    val matrix = Array(n) { IntArray(n) }

    fillMatrix(matrix, n)
    printMatrix(matrix)
}

fun var2z2() {
    println("Введіть розмір масиву:")
    val n = readln().toInt()

    val matrix = Array(n) { IntArray(n) }

    fillMatrixRandomValues(matrix)

    printMatrix(matrix)

    val (sum, average) = calculateSumAndAverage(matrix, n)

    println("Сума зафарбованої частини: $sum")
    println("Середнє арифметичне зафарбованої частини: $average")
}

fun var2z3() {
    println("Введіть рядок:")
    val inputString = readln()

    val wordCount = countWords(inputString)
    println("Кількість слів у рядку: $wordCount")
}

fun fillMatrix(matrix: Array<IntArray>, n: Int) {
    for (i in 0 until n) {
        for (j in 0 until  n) {
            if (j >= n - i - 1) {
                matrix[i][j] = 1
            } else {
                matrix[i][j] = 0
            }
        }
    }
}

fun printMatrix(matrix: Array<IntArray>) {
    println("Заповнений масив:")

    for (row in matrix) {
        for (element in row) {
            print("$element ")
        }
        println()
    }
}

fun fillMatrixRandomValues(matrix: Array<IntArray>) {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            matrix[i][j] = Random.nextInt(-50, 51)
        }
    }
}

fun calculateSumAndAverage(matrix: Array<IntArray>, n: Int): Pair<Int, Double> {
    var sum = 0
    var count = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (j >= n - i - 1) {
                sum += matrix[i][j]
                count++
            }
        }
    }

    val average = if (count > 0) sum.toDouble() / count else 0.0

    return Pair(sum, average)
}

fun countWords(inputString: String): Int {
    var count = 0
    var inWord = false

    for (char in inputString) {
        if (char != ' ' && !inWord) {
            count++
            inWord = true
        } else if (char == ' ') {
            inWord = false
        }
    }

    return count
}