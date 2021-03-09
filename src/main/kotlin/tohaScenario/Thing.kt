package tohaScenario

class Thing (name: String) {
    val name: String = name.decapitalize()
    init {
        println("First Name = $name")
    }
    var interactions = ArrayList<Pair<Pair<String, String>, Thing>>()

    fun interact_between(thing2:Thing, interact: String, description: String){
        this.interactions.add(Pair(Pair(interact, description), thing2))
        thing2.interactions.add(Pair(Pair(interact, description), this))
    }


}