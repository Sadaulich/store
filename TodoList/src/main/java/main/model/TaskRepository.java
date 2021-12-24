package main.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskRepository {
    private AtomicInteger id = new AtomicInteger(1);
    private Hashtable<Integer, Task> tasks = new Hashtable<>();

    public int add(Task task) {
        tasks.put(id.get(), task);
        task.setId(id.getAndIncrement());
        return task.getId();
    }

    public List<Task> listBooks() {
        return new ArrayList<>();
        //return tasks.values().stream().toList();
    }

    public Task getById(int id) {
        return tasks.getOrDefault(id, null);
    }

    public int putById(Task task, int id) {
        if (tasks.get(id) == null) { return -1; }
        tasks.put(id, task);
        return id;
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }
}
