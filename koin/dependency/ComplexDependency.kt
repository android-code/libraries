class ComplexDependency(private val networkManager: NetworkManager) {

    val info: String
        get() = "ComplexDependency is " + networkManager.url + ":" + networkManager.port

    //do some actions
}