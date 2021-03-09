import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import tohaScenario.Event
import tohaScenario.Person
import tohaScenario.Thing

class geniusScenarioTest {

    var name: String = ""
    var name2: String = ""
    var verb: String = ""
    private var thing_name: String = ""
    private var verb2: String = ""
    private var thing_name2: String = ""
    lateinit var person: Person
    lateinit var person2: Person
    lateinit var thing: Thing
    lateinit var thing2: Thing
    lateinit var event: Event
    lateinit var ship: Thing
    lateinit var engine: Thing

    @BeforeEach
    fun init() {
        name = "Toha"
        name2 = "Serge"
        verb = "jump to"
        thing_name = "switchers"
        verb2 = "go to"
        thing_name2 = "rockets"
        person = Person(name)
        person2 = Person(name2)
        thing = Thing(thing_name)
        thing2 = Thing(thing_name2)
        event = Event()
        ship = Thing("Корабль")
        engine = Thing("мотор")
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


    @Test
    fun TestSuperAction() {
        ship.interact_between(engine, "трясло", "во всех направлениях")
        Assertions.assertEquals(ship.interactions.first().first.first, "трясло")
        Assertions.assertEquals(engine.interactions.first().first.first, "трясло")
    }


}


