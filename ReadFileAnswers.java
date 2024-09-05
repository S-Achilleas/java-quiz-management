import java.io.*;
import java.util.*;

class ReadFileAnswers {

    ArrayList<answer> answers = new ArrayList<answer>();
    

    void ReadFile(ArrayList<student> ss , ArrayList<question> qq) {
        BufferedReader reader = null;
        answer Answer = null;
        String line;
        a_multiple achoices = null;
        a_word aword = null;
        a_placement aordered= null;
        try {
            reader = new BufferedReader(new FileReader(new File("answers.txt")));
            line = reader.readLine();
            while (line != null) {
                if (line.trim().equalsIgnoreCase("ANSWER")) {
                    // question = new Question();
                    ArrayList<String> tempq = new ArrayList<String>();
                    String typeofq = null;
                    do {
                        line = reader.readLine();
                        tempq.add(line);
                        if (line.trim().toUpperCase().startsWith("TYPE")) {
                            typeofq = line.trim().substring(4).trim().toUpperCase();
                        }
                    } while (!line.trim().toUpperCase().startsWith("}"));

                    int parameter = 0;
                    for (String x : tempq) {
                        String y = x.toUpperCase();
                        if (typeofq.startsWith("MC")) {
                            ArrayList<Integer> given_a = new ArrayList();
                            if (parameter == 0) {
                                achoices= new a_multiple();
                            }
                            if (y.trim().startsWith("RATEDPERSON_CODE")) {
                                achoices.setStudent(findStudent(x.trim().substring(16).trim(),ss));
                                parameter++;
                            }
                            if (y.trim().startsWith("QUESTION")) {
                                achoices.setQuestion(findQuestion(x.trim().substring(13).trim(),qq));
                                parameter++;
                            }
                            if (y.trim().startsWith("ANSWERS")) {
                                String temp = x.trim().substring(7).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                String[] arrOfStr = temp.split(",");
                                int[] arrOfInt = new int[arrOfStr.length];
                                for (int i = 0; i < arrOfStr.length; i++) {
                                    given_a.add(Integer.parseInt(arrOfStr[i].trim()));
                                }
                                achoices.setMultiple(given_a);
                                parameter++;
                            }
                            if (parameter == 3) {
                                answers.add(achoices);
                                parameter = 0;
                                break;
                            }
                        } // MC END
                        if (typeofq.startsWith("WORD")) {
                            if (parameter == 0) {
                                aword = new a_word();
                            }
                            if (y.trim().startsWith("RATEDPERSON_CODE")) {
                                aword.setStudent(findStudent(x.trim().substring(16).trim(),ss));
                                parameter++;
                            }
                            if (y.trim().startsWith("QUESTION")) {
                                aword.setQuestion(findQuestion(x.trim().substring(13).trim(),qq));
                                parameter++;
                            }
                            if (y.trim().startsWith("WORD")) {
                                String temp = x.trim().substring(4).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                aword.setWord(temp);
                                parameter++;
                            }
                            if (parameter == 3) {
                                answers.add(aword);
                                parameter = 0;
                                break;
                            }

                        } // ONE WORD END
                        if (typeofq.startsWith("FILL")) {
                            ArrayList<String> given_a = new ArrayList();
                            if (parameter == 0) {
                                aordered = new a_placement();
                            }
                            if (y.trim().startsWith("RATEDPERSON_CODE")) {
                                aordered.setStudent(findStudent(x.trim().substring(16).trim(),ss));
                                parameter++;
                            }
                            if (y.trim().startsWith("WORDLIST")) {
                                String temp = x.trim().substring(8).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                String[] arrOfStr = temp.split(",");
                                for (String s : arrOfStr){
                                    given_a.add(s);
                                }
                                aordered.setPlacement(given_a);
                                parameter++;
                            }
                            if (y.trim().startsWith("QUESTION")) {
                                aordered.setQuestion(findQuestion(x.trim().substring(13).trim(),qq));
                                parameter++;
                            }
                            if (parameter == 3) {
                                answers.add(aordered);
                                parameter = 0;
                                break;
                            }
                        } // FILL END
                    } // Tempq for END
                    tempq.clear();
                } else {
                    line = reader.readLine();
                }
            }

        } catch (IOException ioe) {
            System.out.println("file not found");
        }
    }

    void Printlist() {
        System.out.println("\n >>>>>>> Printing List... \n");
        for (answer a : answers)
            System.out.println(a);
    }
    student findStudent(String code, ArrayList<student> ss ){
        for (student s : ss){
            if (s.getCode().equals(code)){
                return s;
            }
        }
        return null;
    }
    question findQuestion(String code, ArrayList<question> qq){
        for(question q : qq){
            if (q.getCode().equals(code)){
                return q;
            }
        }
        return null;
    }
}
