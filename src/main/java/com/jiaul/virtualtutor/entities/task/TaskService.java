package com.jiaul.virtualtutor.entities.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(long id){
        return taskRepository.findById(id);
    }

    public String deleteById(long id){
        taskRepository.deleteById(id);
        return "deleted";
    }
}