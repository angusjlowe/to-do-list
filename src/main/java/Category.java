import java.util.ArrayList;

public class Category {
    private String name;
    private static ArrayList<Category> instances = new ArrayList<Category>();
    private ArrayList<Task> tasks;
    private int id;

    public Category(String name) {
        this.name = name;
        instances.add(this);
        id = instances.size();
        tasks = new ArrayList<Task>(0);
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Category> all() {
        return instances;
    }

    public int getID() {
        return id;
    }

    public static Category find(int id) {
        try {
            return instances.get(id-1);
        } catch(IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public static void clear() {
        instances.clear();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
