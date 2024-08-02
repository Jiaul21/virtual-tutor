package com.jiaul.virtualtutor.entities.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllIncompleteTask(){
        return taskRepository.findAllByIsDoneOrderByDateTimeAsc(false);
    }

    public Task createTask(Task task){ return taskRepository.save(task); }
    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(long id){
        return taskRepository.findById(id);
    }

    public String deleteById(long id){
        taskRepository.deleteById(id);
        return "deleted";
    }
}
