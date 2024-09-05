@SuppressWarnings({"unchecked", "deprecation"})
public class a_word extends answer{
    private String aword;
    a_word(){

    }
    a_word(question Question,student Student,String aword){
        super(Question,Student);
        this.aword = aword;
    }
    public String toString(){
        return super.toString() + "Given Word: " + aword + "\n";
    }
    public String getAnswer(){
        return this.aword;
    }
    public void setWord(String aword){
        this.aword = aword;
    }
}