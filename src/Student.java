import java.io.Serializable;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.Set;

public class Student implements Serializable {
    private static final long serialVersionUID = 2L;
    private String studentId, firstName, lastName, username, passwordHash, programme;
    private final Set<String> registeredCourses = new LinkedHashSet<>();
    public Student(String id,String first,String last,String user,String password,String programme){
        this.studentId=id; this.firstName=first; this.lastName=last; this.username=user; setPassword(password); this.programme=programme;
    }
    public String getStudentId(){return studentId;} public String getFirstName(){return firstName;} public String getLastName(){return lastName;}
    public String getUsername(){return username;} public String getProgramme(){return programme;} public Set<String> getRegisteredCourses(){return registeredCourses;}
    public void setStudentId(String v){studentId=v;} public void setFirstName(String v){firstName=v;} public void setLastName(String v){lastName=v;}
    public void setUsername(String v){username=v;} public void setProgramme(String v){programme=v;}
    public void setPassword(String plain){passwordHash=hash(plain);} public boolean verifyPassword(String plain){return passwordHash!=null && passwordHash.equals(hash(plain));}
    private static String hash(String s){try{MessageDigest md=MessageDigest.getInstance("SHA-256"); byte[] b=md.digest((s==null?"":s).getBytes(StandardCharsets.UTF_8)); StringBuilder x=new StringBuilder(); for(byte z:b)x.append(String.format("%02x",z)); return x.toString();}catch(Exception e){throw new IllegalStateException(e);}}
    public String getFullName(){return firstName+" "+lastName;}
    public String toString(){return studentId+" - "+getFullName()+" - "+programme+" - "+username;}
}
