import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

        @org.junit.jupiter.api.Test
    void toJson() {
        Person person = new Person("Elizabeth","Green", Gender.Female, 19);
        assertEquals(
                "{\"name\":\"Elizabeth\",\"surname\":\"Green\",\"gender\":\"Female\",\"age\":19}",
                person.toJson());
    }
    @org.junit.jupiter.api.Test
    void fromJson(){
        String json = "{\"name\": \"Jennifer\",\"surname\":\"Black\", \"gender\":\"Female\", \"age\":\"19\"}";
        Person p = Person.fromJson(json);
        assertEquals(p, new Person("Jennifer","Black", Gender.Female, 19));
    }
    @org.junit.jupiter.api.Test
    void equalsContract() {
        EqualsVerifier.forClass(Person.class).verify();
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Person person1 = new Person("Ellen","White", Gender.Female, 21);
        Person person2 = new Person("Ellen","White", Gender.Female, 21);
        Person person3 = new Person("Bob","Marley", Gender.Female, 60);
        assertEquals(person1, person2);
        assertNotEquals(person1, person3);
    }
}