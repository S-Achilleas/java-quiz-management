import java.util.ArrayList;
@SuppressWarnings({"unchecked", "deprecation"})
public class a_placement extends answer{
    ArrayList<String> given_a = new ArrayList();

    public a_placement() {
    }
    
    a_placement(question Question,student Student,ArrayList<String>given_a){
        super(Question,Student);
        this.given_a = given_a;
    }
    public String toString(){
        return super.toString() + "Given answers: " + given_a + "\n";
    }
    public String getAnswer(){
        return given_a.toString();
    }
    public void setPlacement(ArrayList<String>given_a){
        this.given_a = given_a;
    }
}