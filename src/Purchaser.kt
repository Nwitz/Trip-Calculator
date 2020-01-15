class Purchaser(private var name: String) {
    private var amount = 0.0f


    fun setAmount(amount: Float) {
        this.amount = amount
    }

    fun getAmount() : Float{
        return amount
    }
}