package org.abondar.experimental.tasklist.persistence;

import org.abondar.experimental.tasklist.model.Task;
import org.abondar.experimental.tasklist.model.TaskService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@OsgiServiceProvider(classes = TaskService.class)
@Properties(@Property(name = "service.exported.interfaces", value = "*"))
@Singleton
public class TaskServiceImpl implements TaskService {
    private Map<String, Task> taskMap;

    public TaskServiceImpl() {
        taskMap = new HashMap<>();
        Task task = new Task("1", "Get Burger", "Don't die of hunger");
        addTask(task);
        Task anotherTask = new Task("2", "Find a job", "Don't loose all of your money");
        addTask(anotherTask);
    }

    @Override
    public Task getTask(String id) {
        return taskMap.get(id);
    }

    @Override
    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public void updateTask(Task task) {
        taskMap.put(task.getId(),task);
    }

    @Override
    public void deleteTask(String id) {
       taskMap.remove(id);
    }

    @Override
    public Collection<Task> getTasks() {
        return new ArrayList<>(taskMap.values());
    }
}
