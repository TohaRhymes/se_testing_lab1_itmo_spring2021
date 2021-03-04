package tohaScenario

class Event() {
    var people = ArrayList<Person>()
    lateinit var action: Pair<String, Thing>


    fun makeEvent(people_array: ArrayList<Person>, cur_action: String, thing_name: String) {
        val thing: Thing = Thing(thing_name)
        this.action = Pair(cur_action, thing)
        for (p in people_array) {
            p.commitAction(cur_action, thing_name)
            this.people.add(p)
        }
    }

    fun addGuy(p:Person){
        p.commitAction(action.first, action.second.name)
        this.people.add(p)
    }

    fun checkGuy(checked_person: String): Boolean {
        for (p in this.people) {
            if (p.firstName.equals(checked_person)) {
                return true
            }
        }
        return false
    }


}