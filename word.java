@SuppressWarnings({"unchecked", "deprecation"})
public class word extends question{
    private String Word;
    word(){

    }
    word(String code,String description,String Word){
        super(code,description);
        this.Word = Word;
    }
    public void setWord(String Word){
        this.Word = Word;
    }
    public String toString(){
        return super.toString() + "Word: " + Word + "\n";
    }
    public String getAnswer(){
        return this.Word;
    }
}