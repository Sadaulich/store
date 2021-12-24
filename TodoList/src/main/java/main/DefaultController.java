/*
package main;

import main.model.Task;
import main.model.TaskRepositor;
import main.model.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class DefaultController {
    private final TaskRepositor taskRepository;

    public DefaultController(TaskRepositor taskRepositor) {
        taskRepository = taskRepositor;
    }

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();

        for (Task task : taskIterable) {
            tasks.add(task);
        }
        model.addAttribute("tasks", tasks)
                .addAttribute("taskCount", tasks.size());
        return "index";
    }
}
*/
