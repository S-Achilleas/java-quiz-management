import java.io.*;
import java.util.*;
import java.util.ArrayList;
@SuppressWarnings({"unchecked", "deprecation"})
class ReadFileQuestions {

    ArrayList<question> questions = new ArrayList<question>();

    void ReadFile() {

        BufferedReader reader = null;
        question quest= null;
        String line;
        multiple choices = null;
        word Word = null;
        placement ordered = null;
        try {
            reader = new BufferedReader(new FileReader(new File("questions.txt")));
            line = reader.readLine();
            while (line != null) {
                if (line.trim().equalsIgnoreCase("QUESTION")) {
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
                            if (parameter == 0) {
                                choices = new multiple();
                            }
                            if (y.trim().startsWith("CODE")) {
                                choices.setCode(x.trim().substring(4).trim());
                                parameter++;
                            }
                            if (y.trim().startsWith("DECSR")) {
                                String temp = x.trim().substring(5).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                choices.setDescription(temp);
                                parameter++;
                            }
                            if (y.trim().startsWith("ANSWERS")) {
                                ArrayList<String>possible = new ArrayList();
                                String temp = x.trim().substring(7).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                String[] arrOfStr = temp.split(",");
                                for (String s : arrOfStr){
                                    possible.add(s);
                                }
                                choices.setPossible(possible);
                                parameter++;
                            }
                            if (y.trim().startsWith("NUMBERLIST")) {
                                ArrayList<Integer>correct = new ArrayList<>();
                                String temp = x.trim().substring(10).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                String[] arrOfStr = temp.split(",");
                                for (String s : arrOfStr) {
                                    correct.add(Integer.parseInt(s.trim()));
                                }
                                choices.setCorrect(correct);
                                parameter++;
                            }
                            if (parameter == 4) {
                                questions.add(choices);
                                parameter = 0;
                                break;
                            }
                        } // MC END
                        if (typeofq.startsWith("WORD")) {
                            if (parameter == 0) {
                                Word = new word();
                            }
                            if (y.trim().startsWith("CODE")) {
                                Word.setCode(x.trim().substring(4).trim());
                                parameter++;
                            }
                            if (y.trim().startsWith("DECSR")) {
                                String temp = x.trim().substring(5).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                Word.setDescription(temp);
                                parameter++;
                            }
                            if (y.trim().startsWith("WORD")) {
                                String temp = x.trim().substring(4).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                Word.setWord(temp);
                                parameter++;
                            }
                            if (parameter == 3) {
                                questions.add(Word);
                                parameter = 0;
                                break;
                            }

                        } // ONE WORD END
                        if (typeofq.startsWith("FILL")) {
                            if (parameter == 0) {
                                ordered = new placement();
                            }
                            if (y.trim().startsWith("CODE")) {
                                ordered.setCode(x.trim().substring(4).trim());
                                parameter++;

                            }
                            if (y.trim().startsWith("DECSR")) {
                                String temp = x.trim().substring(5).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                ordered.setDescription(temp);
                                parameter++;

                            }
                            if (y.trim().startsWith("WORDLIST")) {
                                ArrayList<String>possible = new ArrayList();
                                String temp = x.trim().substring(8).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                String[] arrOfStr = temp.split(",");
                                for (String s : arrOfStr){
                                    possible.add(s);
                                }
                                ordered.setPossible(possible);
                                parameter++;
                            }
                            if (y.trim().startsWith("ORDEREDWORDLIST")) {
                                ArrayList<String>correct = new ArrayList();
                                String temp = x.trim().substring(15).trim().substring(1);
                                temp = temp.substring(0, temp.length() - 1);
                                String[] arrOfStr = temp.split(",");
                                for (String s : arrOfStr){
                                    correct.add(s);
                                }
                                ordered.setCorrect(correct);
                                parameter++;

                            }
                            if (parameter == 4) {
                                questions.add(ordered);
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
        for (question q : questions)
            System.out.println(q);
    }
}