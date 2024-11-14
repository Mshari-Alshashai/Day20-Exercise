package com.example.tasktracker.Module;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {

    private String ID;
    private String title;
    private String description;
    private boolean status;
}
