package org.abondar.experimental.tasklist.commands;

import org.abondar.experimental.tasklist.model.Task;
import org.abondar.experimental.tasklist.model.TaskService;
import org.apache.karaf.shell.table.ShellTable;
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
        @Property(name = "osgi.command.function", value = "list")
})
public class TaskListCommand {
    @Inject
    @OsgiService
    private TaskService service;

    public void list() throws Exception {
        ShellTable table = new ShellTable();
        table.column("id");
        table.column("title");
        for (Task task : service.getTasks()) {
            table.addRow().addContent(task.getId(), task.getTitle());
        }
        table.print(System.out);
    }
}
