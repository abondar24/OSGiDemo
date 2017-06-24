package org.abondar.experimental.tasklist.model;

import java.util.Collection;

/**
 * Created by abondar on 6/23/17.
 */
public interface TaskService {
    Task getTask(String id);
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(String id);
    Collection<Task> getTasks();
}
