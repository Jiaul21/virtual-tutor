package com.jiaul.virtualtutor.entities.dashbord;


import com.jiaul.virtualtutor.entities.dashbord.dto.DashboardCourseDto;
import com.jiaul.virtualtutor.entities.dashbord.dto.DashboardStudentDto;
import com.jiaul.virtualtutor.entities.dashbord.dto.DashboardTeacherDto;
import com.jiaul.virtualtutor.entities.dashbord.dto.TotalCount;
import com.jiaul.virtualtutor.entities.teacher.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<TotalCount> getTotalCountInfo(){
        return ResponseEntity.ok(dashboardService.getTotaLCount());
    }

    @PatchMapping("/active-status/{email}/{enabled}")
    public ResponseEntity<String> updateUserCredentialActiveStatus(@PathVariable String email, @PathVariable boolean enabled){
        return ResponseEntity.ok(dashboardService.updateUserCredentialActiveStatus(email,enabled));
    }
}
