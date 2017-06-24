package org.abondar.experimental.tasklist.ui;

import org.abondar.experimental.tasklist.model.Task;
import org.abondar.experimental.tasklist.model.TaskService;
import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@OsgiServiceProvider(classes = Servlet.class)
@Properties({
        @Property(name = "osgi.http.whiteboard.servlet.pattern", value = "/tasklist")
})
@Singleton
public class TasklistServlet extends HttpServlet {

    @Inject
    @OsgiService
    private TaskService taskService;

    private static final long serialVersionUID = 34543543543423232L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String taskId = req.getParameter("taskId");
        PrintWriter writer = resp.getWriter();
        if (taskId != null && taskId.length() >0){
            showTask(writer,taskId);
        } else {
            showTaskList(writer);
        }
    }

    private void showTaskList(PrintWriter writer) {
        writer.println("<h1>Tasks</h1>");
        Collection<Task> tasks = taskService.getTasks();
        for (Task task:tasks){
            writer.println("<a href=\"?taskId="+task.getId()+"\">"+task.getTitle()+"</a><BR/>");
        }
    }

    private void showTask(PrintWriter writer, String taskId) {
        Task task = taskService.getTask(taskId);
        if (task != null){
            writer.println("<h1>Task "+task.getTitle()+"</h1>");
            writer.println(task.getDescription());
        }
    }
}
