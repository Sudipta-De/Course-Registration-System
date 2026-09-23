import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Programme implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private final List<String> usernames = new ArrayList<>();
    public Programme(String name){ this.name=name; }
    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }
    public List<String> getUsernames(){ return usernames; }
    public String toString(){ return name; }
}
