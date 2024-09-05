import java.util.ArrayList;
@SuppressWarnings({"unchecked", "deprecation"})
public class placement extends question{
    ArrayList<String> possible_ans = new ArrayList<>();
    ArrayList<String> correct_ans = new ArrayList<>();
    placement(){

    }
    placement(String code,String description,ArrayList<String>possible_ans,ArrayList<String>correct_ans){
        super(code,description);
        this.correct_ans = correct_ans;
        this.possible_ans = possible_ans;

    }
    public String toString(){
        return super.toString() + "Possible words: " + possible_ans.toString() + "\n"  + "Correct oreder words: " + correct_ans.toString() + "\n";
    }
    public String getAnswer(){
        return this.correct_ans.toString();
    }
    public void setPossible(ArrayList<String>possible_ans){
        this.possible_ans = possible_ans;
    }
    public void setCorrect(ArrayList<String>correct_ans){
        this.correct_ans = correct_ans;
    }
    public String getArrayList(){
        return this.possible_ans.toString();
    }
}