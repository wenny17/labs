import com.google.gson.*;

import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private final Gender gender;
    private final int age;

    public Person(String name, String surname, Gender gender, int age){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    public static Person fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return this.gender == other.gender &&
                this.age == other.age &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.surname, other.surname);
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.surname != null ? this.surname.hashCode() : 0);
        hash = 53 * hash + (this.gender != null ? this.gender.hashCode() : 0);
        hash = 53 * hash + this.age;
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }
}
