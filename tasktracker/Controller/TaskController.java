package com.example.tasktracker.Controller;

import com.example.tasktracker.ApiResponse.ApiResponse;
import com.example.tasktracker.Module.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task-tracker")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get-tasks")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/add-task")
    public ApiResponse addTask(@RequestBody Task task) {
        tasks.add(task);
        return new ApiResponse("Task added successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteTask(@PathVariable int id) {
        tasks.remove(id);
        return new ApiResponse("Task deleted successfully");
    }

    @GetMapping("/search/{title}")
    public Task getTaskByTitle(@PathVariable String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateTask(@PathVariable int id, @RequestBody Task task) {
        tasks.set(id, task);
        return new ApiResponse("Task updated successfully");
    }

    @PutMapping("/change-status/{id}")
    public ApiResponse changeStatus(@PathVariable int id) {
        tasks.get(id).setStatus(!tasks.get(id).isStatus());
        return new ApiResponse("Status updated successfully");
    }


}
