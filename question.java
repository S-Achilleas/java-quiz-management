@SuppressWarnings({"unchecked", "deprecation"})
public class question{
    private String code;
    private String description;
    int sum = 0;
    int count = 0;
    question(){

    }
    question(String code, String description){
        this.code = code;
        this.description = description;
    }
    public String getCode(){
        return this.code;
    }
    public String toString(){
        return "Code: " + code +"\n" + "Description: " + description + "\n";
    }
    public String getAnswer(){
        return "";
    }
    public float percentage(){
        if (count!=0){
            return (sum/count)*100;
        }
        else{
            return 0;
        }
    }
    public void setCode(String Code){
        this.code = Code;
    }
    public void setDescription(String Description){
        this.description = Description;
    }
    public String getText(){
        return this.description;
    }
    public String getArrayList(){
        return "";
    }
}