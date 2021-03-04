import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import tohaScenario.Event
import tohaScenario.Person
import tohaScenario.Thing

class geniusScenarioTest {

    companion object {
        const val name = "Toha"
        const val name2 = "Serge"
        const val verb = "jump to"
        const val thing_name = "switchers"
        const val verb2 = "go to"
        const val thing_name2 = "rockets"
        val person = Person(name)
        val person2 = Person(name2)
        val thing = Thing(thing_name)
        val thing2 = Thing(thing_name2)
        val event = Event()

    }

    @Test
    fun testName() {
        Assertions.assertEquals(
            person.firstName,
            name.capitalize()
        )
    }

    @Test
    fun testThingName() {
        Assertions.assertEquals(
            thing.name,
            thing_name.decapitalize()
        )
        Assertions.assertEquals(
            thing2.name,
            thing_name2.decapitalize()
        )
    }

    @Test
    fun testCommitAction() {
        Assertions.assertFalse(person.checkAction(verb, thing_name))
        Assertions.assertFalse(person.checkAction(verb2, thing_name2))
        person.commitAction(verb, thing_name)
        Assertions.assertTrue(person.checkAction(verb, thing_name))
        Assertions.assertFalse(person.checkAction(verb2, thing_name2))
    }


//    // ЗАФЕЙЛИТСЯ
//    @Test
//    fun testFAILCommitAction(){
//        Assertions.assertFalse(person.checkAction(verb, thing_name))
//        person.commitAction(verb2, thing_name)
//        Assertions.assertTrue(person.checkAction(verb, thing_name))
//    }

    @Test
    fun checkEvent() {
        Assertions.assertFalse(event.checkGuy(name))
        Assertions.assertFalse(event.checkGuy(name2))
        Assertions.assertFalse(event.checkGuy("Rostik"))
        Assertions.assertFalse(person.checkAction(verb2, thing_name2))
        Assertions.assertFalse(person2.checkAction(verb2, thing_name2))
        val people = ArrayList<Person>()
        people.add(person)
        event.makeEvent(people, verb2, thing_name2)
        Assertions.assertTrue(event.checkGuy(name))
        Assertions.assertFalse(event.checkGuy(name2))
        Assertions.assertFalse(event.checkGuy("Rostik"))
        Assertions.assertTrue(person.checkAction(verb2, thing_name2))
        Assertions.assertFalse(person2.checkAction(verb2, thing_name2))

        event.addGuy(person2)
        Assertions.assertTrue(event.checkGuy(name2))
        Assertions.assertTrue(person2.checkAction(verb2, thing_name2))

    }


}


