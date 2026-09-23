import java.io.*;
import java.util.*;

public class DataStore implements Serializable {
    private static final long serialVersionUID=2L;
    private final List<Course> courses=new ArrayList<>(); private final List<Student> students=new ArrayList<>(); private final List<Programme> programmes=new ArrayList<>();
    private static final File FILE=new File("CRSData.ser");
    public static DataStore load(){if(!FILE.exists()){DataStore d=new DataStore();d.ensureDefaults();d.save();return d;} try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(FILE))){DataStore d=(DataStore)in.readObject(); d.ensureDefaults(); return d;}catch(Exception e){DataStore d=new DataStore();d.ensureDefaults();return d;}}
    public void save(){try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(FILE))){out.writeObject(this);}catch(IOException e){e.printStackTrace();}}
    public List<Course> courses(){return courses;} public List<Student> students(){return students;} public List<Programme> programmes(){return programmes;}
    public Student findUsername(String u){for(Student s:students)if(s.getUsername().equalsIgnoreCase(u))return s;return null;}
    public Student findStudentId(String id){for(Student s:students)if(s.getStudentId().equalsIgnoreCase(id))return s;return null;}
    public Programme findProgramme(String n){for(Programme p:programmes)if(p.getName().equalsIgnoreCase(n))return p;return null;} public Programme programme(String n){return findProgramme(n);}
    public Course findCourse(String id){for(Course c:courses)if(c.getCourseID().equalsIgnoreCase(id))return c;return null;}
    public void ensureDefaults(){if(programmes.isEmpty())programmes.add(new Programme("Computer Science")); if(courses.stream().noneMatch(Course::isDefaultCourse)){String p=programmes.get(0).getName();courses.add(new Course("PAC II","CSCI-GA.1144",7,"Mohamed Zahran",1,"CIWW 312",p,true));courses.add(new Course("Fundamental Algorithms","CSCI-GA.1170",4,"Joel Spencer",1,"CIWW 109",p,true));courses.add(new Course("Programming Languages","CSCI-GA.2110",7,"Benjamin Goldberg",1,"CIWW 109",p,true));}}
}
