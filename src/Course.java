import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    private static final long serialVersionUID = 2L;
    private String courseName, courseID, instructorName, courseLocation, programme;
    private int maxStudents, courseSection;
    private boolean defaultCourse;
    private final List<String> studentUsernames = new ArrayList<>();
    public Course(String name,String id,int max,String instructor,int section,String location,String programme,boolean def){
        courseName=name; courseID=id; maxStudents=max; instructorName=instructor; courseSection=section; courseLocation=location; this.programme=programme; defaultCourse=def;
    }
    public boolean isDefaultCourse(){return defaultCourse;} public String getCourseName(){return courseName;} public String getCourseID(){return courseID;}
    public int getMaxStudents(){return maxStudents;} public int getCurrentStudents(){return studentUsernames.size();} public String getInstructorName(){return instructorName;}
    public int getCourseSection(){return courseSection;} public String getCourseLocation(){return courseLocation;} public String getProgramme(){return programme;} public List<String> getStudentUsernames(){return studentUsernames;}
    public void setCourseName(String v){courseName=v;} public void setCourseID(String v){courseID=v;} public void setMaxStudents(int v){maxStudents=v;}
    public void setInstructorName(String v){instructorName=v;} public void setCourseSection(int v){courseSection=v;} public void setCourseLocation(String v){courseLocation=v;} public void setProgramme(String v){programme=v;}
    public boolean register(String username){if(studentUsernames.contains(username)||studentUsernames.size()>=maxStudents)return false; studentUsernames.add(username); return true;}
    public boolean withdraw(String username){return studentUsernames.remove(username);} public String toString(){return courseID+" - "+courseName+" ["+programme+"]";}
}
