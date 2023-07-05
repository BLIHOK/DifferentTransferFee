fun main(args: Array<String>) {
    println("Введите сумму перевода")
    val amount = readln().toInt()
    printDiscount(
        amount,
        DiscountCalc().calcDiscountByCardType(amount)
    )
    printDiscount(
        amount,
        DiscountCalc().calcDiscountByCardType(amount, card = "Visa")
    )
    printDiscount(
        amount,
        DiscountCalc().calcDiscountByCardType(amount, 77000, card = "MasterCard")
    )
    printDiscount(
        amount,
        DiscountCalc().calcDiscountByCardType(amount, 77000, card = "Visa")
    )
}

fun printDiscount(amount: Int, resultFee: Int) {
    println(
        """
        Сумма перевода: $amount
        Размер комиссии составит: $resultFee
        """.trimIndent()
    )
}

