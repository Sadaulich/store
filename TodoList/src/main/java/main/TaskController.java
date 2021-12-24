package main;

import main.model.Task;
import main.model.TaskRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {
    private final TaskRepositor tasksRepository;

    public TaskController(TaskRepositor taskRepositor) {
        tasksRepository = taskRepositor;
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int id, Model model) {
        tasksRepository.deleteById(id);
        taskLoader(model);
        return "index";
    }

    @RequestMapping("/")
    public String index(Model model) {
        taskLoader(model);
        return "index";
    }

    @PostMapping("/")
    public String add(Task task, Model model) {
        Task newTask = tasksRepository.save(task);
        taskLoader(model);
        return "index";
    }

    private void taskLoader(Model model) {
        Iterable<Task> taskIterable = tasksRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();

        for (Task task : taskIterable) {
            tasks.add(task);
        }
        model.addAttribute("tasks", tasks)
                .addAttribute("taskCount", tasks.size());
    }

    /*@GetMapping("/tasks/")
    public List<Task> list() {
        List<Task> taskList = new ArrayList<>();
        for (Task task : tasksRepository.findAll()) {
            taskList.add(task);
        }
        return taskList;
    }

    @PostMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public void add(@PathVariable String id) {
        return;
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Task> task = tasksRepository.findById(id);

        if (!task.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(task.get(), HttpStatus.OK);
    }

    @PutMapping("/tasks/")
    public void putAll(List<Task> taskList) {
        tasksRepository.deleteAll();
        tasksRepository.saveAll(taskList);
    }

    @DeleteMapping("/tasks/")
    public void deleteAll() {
        tasksRepository.deleteAll();
    }*/
}
