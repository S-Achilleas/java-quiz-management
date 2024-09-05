import java.io.*;
import java.util.*;

class ReadFileStudent {

	ArrayList<student> students = new ArrayList<student>();

	void ReadFile() {

		BufferedReader reader = null;
		student stud = null;
		String line;
		int parameter;
		try {
			reader = new BufferedReader(new FileReader(new File("students.txt")));
			line = reader.readLine();
			while (line != null) {
				if (line.trim().equalsIgnoreCase("RATEDPERSON")) {
					 stud = new student();
					parameter = 0;
					while (parameter < 3) {
						line = reader.readLine();
						if (line.trim().toUpperCase().startsWith("CODE")) {
							parameter++;
							String temp = line.trim().substring(4).trim();
							stud.setCode(temp);
						}
						if (line.trim().toUpperCase().startsWith("SURNAME")) {
							parameter++;
							String temp = line.trim().substring(7).trim().substring(1);
							temp = temp.substring(0, temp.length() - 1);
							stud.setSurname(temp);
						}
						if (line.trim().toUpperCase().startsWith("FIRSTNAME")) {
							parameter++;
							String temp = line.trim().substring(9).trim().substring(1);
							temp = temp.substring(0, temp.length() - 1);
							stud.setName(temp);
						}
					}
					students.add(stud);
				} else {
					line = reader.readLine();
				}
			}

		} catch (IOException ioe) {
			System.out.println("file not found");
		}
	}

	void PrintList() {
		System.out.println("\n >>>>>>> Printing List... \n");
		for (student student : students)
			System.out.println(student);
	}
}
