public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        System.out.println("У " + mom + " есть сын, " + son);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            System.err.println("Не удалось создать объект Person: " + e.getMessage());
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            System.err.println("Не удалось создать объект Person: " + e.getMessage());
        }

        Person person = new PersonBuilder()
                .setName("Антошка")
                .setSurname("Лопатов")
                .setAge(48)
                .build();
        
        System.out.println("Создан объект Person: " + person);
    }
}