//some class with properties and getters, setters
data class Product(val id: Int, val name: String, val producer: Producer, val price: Double)
//converter will just ignore missing ingredients field in model