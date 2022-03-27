package daniel.in.restendpointget.controller;

public class Course {
    
    private String name;
    private int chapterCount;
    
    public Course(String name, int chapterCount) {
        this.name = name;
        this.chapterCount = chapterCount;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
    }
    
    public String getName() {
        return name;
    }
    
    public int getChapterCount() {
        return chapterCount;
    }
}
