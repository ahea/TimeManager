package com.controllers;

import com.models.Task;
import com.services.TaskService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Created by aleksei on 23.01.17.
 */

@Controller
public class TaskController {

    private TaskService taskService;
    private UserService userService;

    @Autowired
    public void setTaskService(TaskService taskService){
        this.taskService = taskService;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    String dashboard(Principal principal, Model model){
        String email = principal.getName();
        String name = userService.getUserByEmail(email).getName();
        Collection<Task> tasks = userService.getUserByEmail(email).getTasks();
        model.addAttribute("name", name);
        model.addAttribute("tasks", tasks);
        return "dashboard";
    }

    @RequestMapping(value = "/dashboard/new", method = RequestMethod.GET)
    String newTask(Model model){
        Task task = new Task();
        task.setDate(new Date());
        model.addAttribute("task", task);
        return "taskform";
    }

    @RequestMapping(value = "/dashboard/new", method = RequestMethod.POST)
    String saveTask(@RequestParam(value ="taskCompleted", defaultValue = "false") boolean taskCompleted , Principal principal, @Valid Task task, BindingResult bindingResult){
        if( bindingResult.hasErrors())
        {
            System.out.println(bindingResult);
        }
        task.setOwner(userService.getUserByEmail(
                principal.getName()));
        task.setCompleted(taskCompleted);
        System.out.println(task.getOwner().getEmail());
        taskService.saveTask(task);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/dashboard/edit/{id}", method = RequestMethod.GET)
    String editTask(@PathVariable Integer id, Task task, Model model){
        task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "taskform";
    }

    @RequestMapping(value = "/dashboard/delete/{id}", method = RequestMethod.GET)
    String deleteTask(@PathVariable Integer id){
        taskService.deleteTaskById(id);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    String deleteAllTasks(Principal principal){
        String email = principal.getName();
        Collection<Task> tasks = userService.getUserByEmail(email).getTasks();
        for (Task task : tasks) {
            taskService.deleteTask(task);
        }
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/dashboard/done/{id}", method = RequestMethod.GET)
    String markDone(@PathVariable Integer id){
        Task task = taskService.getTaskById(id);
        if (task.isCompleted()){
            task.setCompleted(false);
        } else {
            task.setCompleted(true);
        }
        taskService.saveTask(task);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    String logout(){
        return "home";
    }
}
