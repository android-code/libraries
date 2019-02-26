class SimpleDependency(var color: String, var shape: String) {

    fun getInfo(): String {
        return "SimpleDependency is $color $shape"
    }

    fun changeColor(color: String) {
        this.color = color
    }
}