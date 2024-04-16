import org.example.Employee;
import org.example.Main;
import static org.example.Main.jsonToList;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MainTest {

    @Test
    public void testJsonToList_validJson_success() throws ParseException {
        String json = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Inav\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";


        List<Employee> employees = Main.jsonToList(json);


        Assertions.assertEquals(2, employees.size());
        Assertions.assertEquals(1, employees.get(0).getId());
        Assertions.assertEquals("John", employees.get(0).getFirstName());
        Assertions.assertEquals("Smith", employees.get(0).getLastName());

    }

    @Test
    public void testJsonToList_emptyJson_emptyList() throws ParseException {

        String json = "[]";

        List<Employee> employees = Main.jsonToList(json);

        Assertions.assertTrue(employees.isEmpty());
    }

    @Test
    public void testJsonToList_invalidJson_exceptionThrown() {

        String json = "invalid JSON";

        Assertions.assertThrows(Exception.class, () -> Main.jsonToList(json));
    }

    @Test
    public void testJsonToList_emptyJson_returnsEmptyList() throws ParseException {

        String emptyJson = "[]";

        List<Employee> result = jsonToList(emptyJson);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }
}
