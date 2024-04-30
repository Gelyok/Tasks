import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        if (name == null || surname == null) {
            throw new IllegalStateException("Имя и фамилия должны быть указаны");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAddress() {
        return address != null && !address.isEmpty();
    }

    public OptionalInt getAge() {
        return age >= 0 ? OptionalInt.of(age) : OptionalInt.empty();
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
    }

    public void happyBirthday() {
        age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.setSurname(this.surname);
        return builder;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", возраст: " + age + ", город: " + (hasAddress() ? address : "неизвестен");
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}