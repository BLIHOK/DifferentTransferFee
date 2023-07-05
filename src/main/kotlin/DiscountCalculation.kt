class DiscountCalc {
    private val MasterCardAndMaestroFee = 0.006
    private val MasterCardAndMaestroMinFee = 20
    private val VisaAndMirFee = 0.0075
    private val VisaAndMirMinFee = 35
    private var basicFee = 0

    fun calcDiscountByCardType(amount: Int, transfer: Int = 0, card: String = "VKPay"): Int {
        val previousTransfers = amount + transfer

        val totalDiscount: Int = when (card) {
            "MasterCard", "Maestro" -> MasterAndMAestroCalculate(previousTransfers)
            "Visa", "Mir" -> VisaAndMirCalculate(previousTransfers)
            else -> basicFee
        }
        return totalDiscount
    }

    private fun MasterAndMAestroCalculate(previousTransfers: Int): Int {
        val master: Int = when {
            previousTransfers <= 75_000 -> basicFee
            else -> (previousTransfers * MasterCardAndMaestroFee + MasterCardAndMaestroMinFee).toInt()
        }
        return master
    }

    private fun VisaAndMirCalculate(previousTransfers: Int): Int {
        val visa: Int = when {
            previousTransfers * VisaAndMirFee > VisaAndMirMinFee -> (previousTransfers * VisaAndMirFee).toInt()
            else -> VisaAndMirMinFee
        }
        return visa
    }
}