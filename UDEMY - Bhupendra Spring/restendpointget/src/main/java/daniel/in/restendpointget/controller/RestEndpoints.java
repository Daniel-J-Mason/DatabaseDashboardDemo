package daniel.in.restendpointget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RestEndpoints {
    
    @Value("${default.course.name}")
    private String defaultCourseName;
    
    @Value("${default.course.chapterCount}")
    private int defaultChapterCount;
    
    @Autowired
    private CourseConfiguration courseConfiguration;
    
    @RequestMapping("/course")
    public Course getEndpoint(@RequestParam(value="name", defaultValue = "Spring Boot", required = false) String name,
                              @RequestParam(value="chapterCount", defaultValue = "2", required = false) int chapterCount){
        return new Course(name, chapterCount);
    }
    
    
    @RequestMapping("/defaultCourse")
    public Course getDefaultCourse(@RequestParam(value="name", defaultValue = "Spring Boot", required = false) String name,
                              @RequestParam(value="chapterCount", defaultValue = "2", required = false) int chapterCount){
        return new Course(defaultCourseName, defaultChapterCount);
    }
    
    @RequestMapping("/courseConfiguration")
    public HashMap<String, Object> getCourseFromProperties(){
        HashMap<String, Object> returnMap = new HashMap<>();
        
        
        returnMap.put("name", courseConfiguration.getName());
        returnMap.put("chapterCount", courseConfiguration.getChapterCount());
        returnMap.put("rating", courseConfiguration.getRating());
        returnMap.put("author", courseConfiguration.getAuthor());
        return returnMap;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/register/course")
    public String saveCourse(@RequestBody Course course) {
        if (course.getChapterCount() == 1) {
            return "Your course: " + course.getName() + " with 1 chapter was saved!.";
        } else if (course.getChapterCount() != 1){
            return "Your course: " + course.getName() + " with " + course.getChapterCount() + " chapters was saved!.";
        } else {
            return "Error test";
        }
    }
}
