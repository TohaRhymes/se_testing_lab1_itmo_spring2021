package tohaScenario

class Person(fName: String) {
    var firstName: String = fName.capitalize()
    init {
        println("$firstName added.")
    }
    var actions = ArrayList<Pair<String, Thing>>()


    fun commitAction(action:String, thing_name: String){
        val thing: Thing = Thing(thing_name)
        val thingObj:Pair<String, Thing> = Pair(action, thing)
        this.actions.add(thingObj)
    }

    fun checkAction(checked_action: String, checked_Thing:String): Boolean {
        for (action in this.actions) {
            if (checked_action.equals(action.first) && action.second.name.equals(checked_Thing) )
                return true
        }
        return false
    }


}