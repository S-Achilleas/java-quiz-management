import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
@SuppressWarnings({"unchecked", "deprecation"})

public class WriteFileQuestions {
    void CreateFile(HashMap<String,question> questions) {
        System.out.println(" >>>>>>> Write data from ARRAYLIST to FILE...");
        FileWriter writer = null;

        try {
            writer = new FileWriter(new File("questions.txt"));
            writer.write("QUESTION_LIST" + "\n{\n");
            for (question q : questions.values()){
                if (q instanceof multiple){
                    writer.write("\tQUESTION"+"\n"+"\t{"+"\n"+"\t"+"\tTYPE MC "+"\n"+"\t"+"\tCODE "+ q.getCode()
								+ "\n"+"\t"+ "\t" +"DECSR \""+ q.getText() + "\""
								+ "\n"+"\t"+"\t" +"NUMBERLIST "	+ "\"" + ((multiple)q).getAnswer().substring(1,(((multiple)q).getAnswer()).length()-1) + "\""
								+ "\n"+"\t"+"\t" +"ANSWERS "	+ "\"" + ((multiple)q).getArrayList().substring(1, ((multiple)q).getArrayList().length()-1) + "\""
								+ "\n"+"\t}"+"\n");
                }
                if (q instanceof word){
                    writer.write("\tQUESTION"+"\n"+"\t{"+"\n"+"\t"+"\tTYPE WORD "+"\n"+"\t"+"\tCODE "+ q.getCode()
								+ "\n"+"\t"+ "\t" +"DECSR \""+ q.getText() + "\""
								+ "\n"+"\t"+"\t" +"WORD "	+ "\"" + ((word)q).getAnswer().substring(0, ((word)q).getAnswer().length()) + "\""
								+ "\n"+"\t}"+"\n");
                }
                if (q instanceof placement){
                    writer.write("\tQUESTION"+"\n"+"\t{"+"\n"+"\t"+"\tTYPE FILL "+"\n"+"\t"+"\tCODE "+ q.getCode()
								+ "\n"+"\t"+ "\t" +"DECSR \""+ q.getText() + "\""
								+ "\n"+"\t"+"\t" +"ORDEREDWORDLIST "	+ "\"" + ((placement)q).getAnswer().substring(1,(((placement)q).getAnswer()).length()-1) + "\""
								+ "\n"+"\t"+"\t" +"WORDLIST "	+ "\"" + ((placement)q).getArrayList().substring(1, ((placement)q).getArrayList().length()-1) + "\""
								+ "\n"+"\t}"+"\n");
                }
            }
            writer.write("}");
            writer.close();

        } catch (IOException ioe) {
            System.out.println("Path not found");
        }
    }
}