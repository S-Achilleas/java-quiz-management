
import java.util.HashMap;
@SuppressWarnings({"unchecked", "deprecation"})

public class answer{
    private question Question;
    private student Student;
    answer(){

    }
    answer(question Question,student Student){
        this.Question = Question;
        this.Student = Student;
    }
    public String toString(){
        return Question.toString() +"\n" ;
    }
    public String getStudentCode(){
        return Student.getCode();
    }
    public String getAnswer(){
        return "";
    }
    public String getQuestionCode(){
        return this.Question.getCode();
    }
    public boolean check(answer a,HashMap<String,question>questions){
        for (question q : questions.values()){
            if (q.getCode().equals(a.getQuestionCode())){
                if (a.getAnswer().equals(q.getAnswer())){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    public void setStudent(student Student){
        this.Student = Student;
    }
    public void setQuestion(question Question){
        this.Question = Question;
    }
}