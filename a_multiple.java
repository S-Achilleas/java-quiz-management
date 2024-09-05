import java.util.ArrayList;
@SuppressWarnings({"unchecked", "deprecation"})
public class a_multiple extends answer{
    ArrayList<Integer> given_a = new ArrayList();

    public a_multiple() {
    }
    
    a_multiple(question Question,student Student,ArrayList<Integer>given_a){
        super(Question,Student);
        this.given_a = given_a;
    }
    public String toString(){
        return super.toString() + "Given answers: " + given_a + "\n";
    }
    public String getAnswer(){
        return given_a.toString();
    }
    public void setMultiple(ArrayList<Integer>given_a){
        this.given_a= given_a;
    }
}