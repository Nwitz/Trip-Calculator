class Purchase(var amount: Float, private var purchaser: Purchaser) {
    private val contributors = mutableListOf<Contributor>()

    fun addContribution(contributor: Contributor) {
       contributors.add(contributor)
    }
}