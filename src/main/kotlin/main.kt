fun main() {
    val tax = 0.75 / 100
    val minTax = 35
    val amount = 30000

    val result = if (amount * tax < minTax) minTax else amount * tax
    println(result)

}