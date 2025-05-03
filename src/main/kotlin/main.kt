fun main() {
    println(calculatedTax("Mastercard", 75_000, 10_000))

}

fun calculatedTax(typeCard: String, monthlyTransferTotal: Int = 0, transfer: Int): String {
    val taxVisa = 0.75 / 100
    val minTaxVisa = 35
    val taxMastercard = 0.6 / 100
    val transferLimitMastercard = 75_000
    val transferLimitInDay = 150_000
    val transferLimitInMonth = 600_000

    if (transfer > transferLimitInDay || monthlyTransferTotal + transfer > transferLimitInMonth) {
        return "Операция отклонена: превышен лимит"
    }

    val tax = when (typeCard) {
        "Mastercard" -> {
            val total = monthlyTransferTotal + transfer
            when {
                monthlyTransferTotal >= transferLimitMastercard -> {
                    (transfer * taxMastercard + 20).toInt()
                }
                total <= transferLimitMastercard -> {
                    0
                }
                else -> {
                    val excess = total - transferLimitMastercard
                    (excess * taxMastercard + 20).toInt()
                }
            }
        }

        "Visa" -> {
            val calculatedTax = transfer * taxVisa
            if (calculatedTax < minTaxVisa) minTaxVisa else calculatedTax.toInt()
        }

        "Mir" -> 0

        else -> return "Неизвестный тип карты"
    }


    return "Комиссия составит $tax руб."


}