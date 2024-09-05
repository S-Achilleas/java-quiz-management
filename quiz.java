import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
public class quiz{
    static student st1 = new student("1","Achilleas","Sarras");
    static student st2 = new student ("2","Agapi","Kapola");
    static Scanner input = new Scanner(System.in);
    static WriteFileQuestions  fileq = new WriteFileQuestions();
    static WriteFileAnswers filea = new WriteFileAnswers();
    static HashMap<String,student> students = new HashMap<>();
    static HashMap<String,question> questions = new HashMap<>();
    static ArrayList<answer> answers = new ArrayList<>();
    static boolean loop = true;
    static String code;
    static String uanswer;
    @SuppressWarnings({"unchecked", "deprecation"})
    public static void main(String args[]){
        students.put("1",st1);
        students.put("2",st2);
        ReadFileQuestions app1 = new ReadFileQuestions();
        ReadFileStudent app2 = new ReadFileStudent();
        ReadFileAnswers app3 = new ReadFileAnswers();
        array_to_hash has = new array_to_hash();
        try{
            app1.ReadFile();
            questions = has.tohashq(app1.questions);
        }catch( Exception e){
            System.out.println("Questions file is empty");
        }
        try {
            app2.ReadFile();
            students = has.tohashs(app2.students);
            app3.ReadFile(app2.students,app1.questions); 
            answers = app3.answers;
        } catch (Exception e) {
            System.out.println("Student file is empty.");
        }
        while (loop) {
            System.out.println("1. Add new Student");
            System.out.println("2. Add new Question");
            System.out.println("3. Add new Answer");
            System.out.println("4. Show Questions");
            System.out.println("5. Show specific Students' Answers");
            System.out.println("6. Display the number of correct answers per student");
            System.out.println("7. Display the percentage of correct answers per student");
            int choice = Integer.parseInt(input.nextLine());

            if (choice==1) {
                System.out.print("Enter student name: ");
                    String name = input.nextLine();
                    System.out.print("Surname: ");
                    String surname = input.nextLine();
                    System.out.print("User code: ");
                    code = input.nextLine();
                    if (students.containsKey(code)) {
                        System.out.println("Student already exists");
                        break;
                    }
                    student s_obj = new student(code, name, surname);
                    students.put(code, s_obj);
            }
            else if (choice == 2){
                System.out.print("Question code: ");
                code = input.nextLine();
                if (questions.containsKey(code)) {
                    System.out.println("Question already exists");
                    break;
                }
                System.out.print("Question description: ");
                    String description = input.nextLine();
                    System.out.println("1. Multiple Choice");
                    System.out.println("2. One Word Question");
                    System.out.println("3. Ordered Word Question");
                    int qchoice = Integer.parseInt(input.nextLine());
                    if (qchoice == 1){
                        ArrayList<String> possible_ans = new ArrayList<>();
                        ArrayList<Integer> correct_ans = new ArrayList<>();
                        System.out.println("Enter the possible answers. To stop inserting answers write !STOP!");
                        String ans = input.nextLine();

                        while (!(ans.equals("!STOP!"))) {
                            possible_ans.add(ans);
                            System.out.println("Enter another answer or !STOP! to finish:");
                            ans = input.nextLine(); // Get the next input from the user
                        }
                        System.out.println("Enter the right answers. To stop inserting answers write 0");
                        int w_ans = Integer.parseInt(input.nextLine());

                        while (!(w_ans == 0)) {
                            correct_ans.add(w_ans);
                            System.out.println("Enter another answer or 0 to finish:");
                            w_ans =  Integer.parseInt(input.nextLine()); // Get the next input from the user
                        }
                        multiple mul_obj = new multiple(code,description,possible_ans,correct_ans);
                        questions.put(code,mul_obj);
                    }
                    else if (qchoice == 2){
                        System.out.print("Insert right answer: ");
                        uanswer = input.nextLine();
                        word word_obj = new word(code, description, uanswer);
                        questions.put(code, word_obj);
                    }
                    else if (qchoice == 3){
                        ArrayList<String> possible_words = new ArrayList<>();
                        ArrayList<String> correct_words = new ArrayList<>();
                        System.out.println("Enter the words unordered. To stop inserting answers write !STOP!");
                        String words = input.nextLine();

                        while (!(words.equals("!STOP!"))) {
                            possible_words.add(words);
                            System.out.println("Enter another answer or !STOP! to finish:");
                            words = input.nextLine(); // Get the next input from the user
                        }

                        System.out.println("Enter the words in correct order. To stop inserting answers write !STOP!");
                        String w_words = input.nextLine();
                        while (!(w_words.equals("!STOP!"))) {
                            correct_words.add(w_words);
                            System.out.println("Enter another answer or !STOP! to finish:");
                            w_words = input.nextLine(); // Get the next input from the user
                        }
                        placement placement_obj = new placement(code,description,possible_words,correct_words);
                        questions.put(code,placement_obj);
                    }
            }
            else if (choice == 3){
                System.out.print("Give question's code: ");
                uanswer = input.nextLine();
                question tempq = null; //
                if (questions.containsKey(uanswer)) {
                    tempq = questions.get(uanswer);
                }
                System.out.print("Give students' code: ");
                uanswer = input.nextLine();
                student temps = null;
                if (students.containsKey(uanswer)) {
                    temps = students.get(uanswer);
                }
                if (tempq instanceof multiple){
                    ArrayList<Integer> given_a = new ArrayList();
                    System.out.println("Enter the number of the answers. To stop inserting answers write 0");
                    int g_ans = Integer.parseInt(input.nextLine());

                    while (!(g_ans == 0)) {
                        given_a.add(g_ans);
                        System.out.println("Enter another answer or 0 to finish:");
                        g_ans = Integer.parseInt(input.nextLine()); // Get the next input from the user
                    }
                    a_multiple amul_obj = new a_multiple(tempq, temps, given_a);
                    answers.add( amul_obj);
                }
                else if (tempq instanceof word){
                    System.out.println("enter the one word answer: ");
                    uanswer = input.nextLine();
                    a_word aword_obj = new a_word(tempq, temps, uanswer);
                    answers.add(aword_obj);
                }
                else if (tempq instanceof placement){
                    ArrayList<String> given_w = new ArrayList();
                    System.out.println("Enter the words in correct order. To stop inserting answers write !STOP!");
                    String o_words = input.nextLine();
                    while (!(o_words.equals("!STOP!"))) {
                        given_w.add(o_words);
                        System.out.println("Enter another answer or !STOP! to finish:");
                        o_words = input.nextLine(); // Get the next input from the user
                    }
                    a_placement aplc_obj = new a_placement(tempq, temps, given_w);
                    answers.add(aplc_obj);
                }
                
            }
            else if (choice == 4){
                for (question q : questions.values()){
                    System.out.println(q);
                }
            }
            else if (choice== 5){
                System.out.print("Give students code: ");
                uanswer = input.nextLine();
                for (answer a : answers){
                    if (a.getStudentCode().equals(uanswer)){
                        System.out.println(a);
                    }
                }
            }
            else if (choice == 6){
                ArrayList<student> ordered_students = new ArrayList<>();
                for (student s : students.values()){
                    ordered_students.add(s);
                    s.correct_answers = 0;
                }
                for (answer a :answers){
                    if (a.check(a,questions)){
                        for (student s : students.values()){
                            if ((a.getStudentCode()).equals(s.getCode())){
                                s.correct_answers++;
                            }
                        }
                    }
                }
               ordered_students.sort(Comparator.comparingInt(student::getCorrect).reversed());
               for (student s : ordered_students){
                System.out.println(s);
                System.out.println("Had " + s.getCorrect() + " correct answers!\n");
               }
            }
            else if (choice == 7){
                ArrayList<student> ordered_students_per = new ArrayList<>();
                for (student s : students.values()){
                    ordered_students_per.add(s);
                    s.number = 0;
                    s.correct_answers = 0;
                }
                for (answer a :answers){
                    if (a.check(a,questions)){
                        for (student s : students.values()){
                            if ((a.getStudentCode()).equals(s.getCode())){
                                s.correct_answers++;
                                s.number++;
                            }
                        }
                    }
                }
               ordered_students_per.sort(Comparator.comparingInt(student::getCorrectper).reversed());
               for (student s : ordered_students_per){
                System.out.println(s);
                System.out.println("Had " + s.getCorrect() + "% correct answers!\n");
               }
            }
            else{
                System.out.println("Out of range choice, exiting...and saving");
                loop = false;
                fileq.CreateFile(questions);
                filea.CreateFile(answers);
            }
        }
    }
}