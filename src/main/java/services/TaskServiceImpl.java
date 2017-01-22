package services;

import models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.TaskRepository;

/**
 * Created by aleksei on 21.01.17.
 */
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Integer id) {
        return taskRepository.getOne(id);
    }

    @Override
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void deleteTaskById(Integer id) {
        taskRepository.delete(id);
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

}
