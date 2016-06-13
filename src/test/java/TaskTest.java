import org.junit.*;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TaskTest {
    @After
    public void tearDown() {
        Task.clear();
    }
    @Test
    public void taskInstantiatesCorrectly() {
        Task testTask = new Task("Buy groceries");
        assertEquals(true, testTask instanceof Task);
    }
    @Test
    public void taskHasCorrectDescription() {
        Task testTask = new Task("Buy groceries");
        assertEquals("Buy groceries", testTask.getTitle());
    }
    @Test
    public void isFalseAfterInstantiation() {
        Task testTask = new Task("Mow the lawn");
        assertEquals(false, testTask.isComplete());
    }
    @Test
    public void timeCreated() {
        Task testTask = new Task("Mow the lawn");
        assertEquals(LocalDateTime.now().getDayOfWeek(), testTask.getCreatedAt().getDayOfWeek());
    }
    @Test
    public void allReturned() {
        Task firstTask = new Task("mow the lawn");
        Task secondTask = new Task("Buy groceries");
        assertTrue(Task.all().contains(firstTask));
        assertTrue(Task.all().contains(secondTask));
    }
    @Test
    public void clear_emptiesAllTasksFromArrayList_0() {
        Task myTask = new Task("Mow the lawn");
        Task.clear();
        assertEquals(Task.all().size(), 0);
    }
    @Test
    public void getId_tasksInstantiateWithAnID_1() {
        Task.clear();  // THIS TEST WILL FAIL WITHOUT THIS LINE!
        Task myTask = new Task("Mow the lawn");
        assertEquals(1, myTask.getId());
    }
    @Test
    public void find_returnsTaskWithSameId_secondTask() {
        Task firstTask = new Task("Mow the lawn");
        Task secondTask = new Task("Buy groceries");
        assertEquals(Task.find(secondTask.getId()), secondTask);
    }
    @Test
    public void find_returnsNullWhenNoTaskFound_null() {
        assertTrue(Task.find(999) == null);
    }

}
