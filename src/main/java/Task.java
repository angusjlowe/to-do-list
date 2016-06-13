import java.time.LocalDateTime;
import java.util.ArrayList;
public class Task {

    private String title;
    private boolean complete;
    private LocalDateTime createdAt;
    private static ArrayList<Task> instances = new ArrayList<Task>();
    private int id;

    public Task(String title) {
        this.title = title;
        complete = false;
        createdAt = LocalDateTime.now();
        instances.add(this);
        id = instances.size();
    }

    public String getTitle() {
        return title;
    }

    public boolean isComplete() {
        return complete;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static ArrayList<Task> all() {
        return instances;
    }

    public static void clear() {
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Task find(int id) {
        try {
            return instances.get(id - 1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

}
