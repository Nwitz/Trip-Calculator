class Purchase(var amount: Float) {
    private val contributors = mutableListOf<Contributor>()
    lateinit var purchaser: String
    //TODO add enum

    fun addContribution(contributor: Contributor) {
       contributors.add(contributor)
    }
}