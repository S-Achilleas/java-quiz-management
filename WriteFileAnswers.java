import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteFileAnswers {
    void CreateFile(ArrayList<answer> answers) {
        System.out.println(" >>>>>>> Write data from ARRAYLIST to FILE...");
        FileWriter writer = null;

        try {
            writer = new FileWriter(new File("answers.txt"));
            writer.write("ANSWER_LIST" + "\n{\n");
            for (answer a : answers){
                if (a instanceof a_multiple){
                    writer.write("\tANSWER"+"\n"+"\t{"+"\n"+"\t"+"\tTYPE MC "+"\n"+"\t"+"\tRATEDPERSON_CODE "+ a.getStudentCode()
								+ "\n"+"\t"+ "\t" +"QUESTION_CODE "+ a.getQuestionCode() 
								+ "\n"+"\t"+"\t" +"ANSWERS "	+ "\"" + ((a_multiple)a).getAnswer().substring(1, ((a_multiple)a).getAnswer().length()-1) + "\""
								+ "\n"+"\t}"+"\n");
                }
                if (a instanceof a_word){
                    writer.write("\tANSWER"+"\n"+"\t{"+"\n"+"\t"+"\tTYPE WORD "+"\n"+"\t"+"\tRATEDPERSON_CODE "+ a.getStudentCode()
								+ "\n"+"\t"+ "\t" +"QUESTION_CODE " + a.getQuestionCode() 
								+ "\n"+"\t"+"\t" +"WORD "	+ "\"" + ((a_word)a).getAnswer().substring(0, ((a_word)a).getAnswer().length()) + "\""
								+ "\n"+"\t}"+"\n");
                }
                if (a instanceof a_placement){
                    writer.write("\tANSWER"+"\n"+"\t{"+"\n"+"\t"+"\tTYPE FILL "+"\n"+"\t"+"\tRATEDPERSON_CODE "+ a.getStudentCode()
								+ "\n"+"\t"+ "\t" +"QUESTION_CODE "+ a.getQuestionCode() 
								+ "\n"+"\t"+"\t" +"WORDLIST "	+ "\"" + ((a_placement)a).getAnswer().substring(1, ((a_placement)a).getAnswer().length()-1) + "\""
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