@SuppressWarnings({"unchecked", "deprecation"})
public class student{
    private String code,name,surname;
     int correct_answers = 0;
     int number = 0;

    public student() {
    }
     
    student(String code,String surname,String name){
        this.code = code;
        this.name = name;
        this.surname = surname;
    }
    public String toString(){
        return "Code: " + code + "\n" + "Name: " + name + "\n"  + "Surname: "  + surname + "\n";
    }
    public String getCode(){
        return this.code;
    }
    public int getCorrect(){
        return this.correct_answers;
    }
    public int getCorrectper(){
        return (this.correct_answers/number)*100;
    }
    public void setCode(String code){
        this.code = code;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
}