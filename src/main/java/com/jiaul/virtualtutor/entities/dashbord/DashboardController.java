package com.jiaul.virtualtutor.entities.dashbord;


import com.jiaul.virtualtutor.entities.dashbord.dto.DashboardCourseDto;
import com.jiaul.virtualtutor.entities.dashbord.dto.DashboardStudentDto;
import com.jiaul.virtualtutor.entities.dashbord.dto.DashboardTeacherDto;
import com.jiaul.virtualtutor.entities.dashbord.dto.TotalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dash-board")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/get/teachers-info")
    public ResponseEntity<List<DashboardTeacherDto>> getAllTeachersInfo(){
        return ResponseEntity.ok(dashboardService.getTeachersInfo());
    }
    @GetMapping("/get/students-info")
    public ResponseEntity<List<DashboardStudentDto>> getAllStudentsInfo(){
        return ResponseEntity.ok(dashboardService.getStudentsInfo());
    }
    @GetMapping("/get/courses-info")
    public ResponseEntity<List<DashboardCourseDto>> getAllCoursesInfo(){
        return ResponseEntity.ok(dashboardService.getCoursesInfo());
    }

    @GetMapping("/get/home")
    public ResponseEntity<TotalCount> getAllTeacherInfo(){
        return ResponseEntity.ok(dashboardService.getTotaLCount());
    }
}
