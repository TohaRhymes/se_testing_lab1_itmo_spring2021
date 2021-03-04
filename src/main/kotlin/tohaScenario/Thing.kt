package tohaScenario

class Thing (name: String) {
    val name: String = name.decapitalize()

    init {
        println("First Name = $name")
    }
}