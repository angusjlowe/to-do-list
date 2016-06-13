import org.junit.*;
import static org.junit.Assert.*;

public class CategoryTest {
    @After
    public void tearDown() {
        Category.clear();
        Task.clear();
    }
    @Test
    public void instantiationTest() {
        Category category = new Category("Home");
        assertEquals("Home", category.getName());
    }
    @Test
    public void returnMultipleCategories() {
        Category first = new Category("Home");
        Category second = new Category("Work");
        assertTrue(Category.all().contains(first));
        assertTrue(Category.all().contains(second));
    }
    @Test
    public void getID() {
        Category category = new Category("Home");
        assertEquals(1, category.getID());

    }
    @Test
    public void testFind() {
        Category first = new Category("Home");
        Category second = new Category("Work");
        assertEquals(Category.find(second.getID()), second);
    }
    @Test
    public void nullFind() {
        assertTrue(Category.find(999)==null);
    }
    @Test
    public void initialGetTasks() {
        Category category = new Category("Home");
        assertEquals(0, category.getTasks().size());
    }
    @Test
    public void addTasks() {
        Category category = new Category("Home");
        Task task = new Task("Mow the lawn");
        category.addTask(task);
        assertTrue(category.getTasks().contains(task));

    }
}
