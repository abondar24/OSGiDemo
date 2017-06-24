package org.abondar.experimental.tasklist.commands;

import org.abondar.experimental.tasklist.model.Task;
import org.abondar.experimental.tasklist.model.TaskService;
import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
@OsgiServiceProvider(classes = TaskAddCommand.class)
@Properties({
        @Property(name = "osgi.command.scope", value = "task"),
        @Property(name = "osgi.command.function", value = "add")
})
public class TaskAddCommand {
    @Inject
    @OsgiService
    private TaskService service;

    public void add(String id, String title, String description) throws Exception {
        Task task = new Task(id,title,description);
        service.addTask(task);
    }
}
