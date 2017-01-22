package services;

import models.Task;

/**
 * Created by aleksei on 21.01.17.
 */
public interface TaskService {

    Iterable<Task> getAllTasks();

    Task getTaskById(Integer id);

    void saveTask(Task task);

    void deleteTaskById(Integer id);

    void deleteTask(Task task);

    void deleteAllTasks();
}
