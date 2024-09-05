import java.util.ArrayList;
@SuppressWarnings({"unchecked", "deprecation"})
public class multiple extends question{
    ArrayList<String> possible_ans = new ArrayList<>();
    ArrayList<Integer> correct_ans = new ArrayList<>();
    multiple(){

    }
    multiple(String code,String description,ArrayList<String>possible_ans,ArrayList<Integer>correct_ans){
        super(code,description);
        this.correct_ans = correct_ans;
        this.possible_ans = possible_ans;

    }
    public String toString(){
        return super.toString() + "Possible answers: " + possible_ans.toString() + "\n"  + "Correct answers: " + correct_ans.toString() + "\n";
    }
    public String getAnswer(){
        return this.correct_ans.toString();
    }
    public void setPossible(ArrayList<String>possible_ans){
        this.possible_ans = possible_ans;
    }
    public void setCorrect(ArrayList<Integer>correct_ans){
        this.correct_ans = correct_ans;
    }
    public String getArrayList(){
        return this.possible_ans.toString();
    }
}