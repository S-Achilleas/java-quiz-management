import java.util.ArrayList;
import java.util.HashMap;
@SuppressWarnings({"unchecked", "deprecation"})
public class array_to_hash  { //convert arraylist of student/question objects to hashmap

   public HashMap<String, student> tohashs(ArrayList<student> Student_list){ //when input is arraylist with student objects,
      HashMap<String, student> map = new HashMap<>();
      for (student current : Student_list) {        //it turns it to hashmap where its key should be student code
         map.put(current.getCode(), current);       //and its value should be the student object of that code
      }
      return map;
   }

   public HashMap<String, question> tohashq( ArrayList<question> Question_list){ // same for question
      HashMap<String, question> map = new HashMap<>();
      for (question current : Question_list) {
         map.put(current.getCode(), current);
      }
      return map;
   }
}