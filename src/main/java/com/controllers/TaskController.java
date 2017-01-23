package com.controllers;

import com.models.Task;
import com.services.TaskService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Collection;

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
}
