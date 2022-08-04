/* Create a quiz program that will take questions, option and answer from admin user and save it to the question bank.
        Then if any user want to give the quiz, random 5 questions will be shown to the user from the question bank.
        Program output:
        1. Add Quiz
        2. Start Quiz
        if user select option 1, then system will tell user to input a question,
        4 options and correct ans to save data in a quiz bank. The quiz bank will be a json file. For an example,

        System>Please add a ques here:
        User>Which testing is done by developer?
        System>Input options.
        Option a: Unit Testing
        Option b: Integration Testing
        Option c: Sanity Testing
        Option d: Regression Testing
        System> Please input the correct ans
        User> a
        System: Quiz saved at the database. Do you want to add more? (y/n)
        if user press y, then the previous scenario will happen again otherwise the program will be closed.

        If user select option 2,  then,
        System> You will be asked 5 questions, each questions has 1 marks
        1. Which testing is done by developer?
        a. Unit Testing
        b. Integration Testing
        c. Sanity Testing
        d. Regression Testing
        User> a
        System> Correct!
        else not correct,
        System: Not correct
        Finally 5 different random questions will appear from your question database. At least add 20 questions from any category from testing.
        Result: You got [correct_marks] out of 5 */

package json_file_manipultion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Java_quiz_program_using_json {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("1. Add Quiz");
        System.out.println("2. Start Quiz");
        System.out.println("Select any one :");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number == 1) {
            writeJSONList();
        } else if (number == 2) {
            System.out.println("You will be asked 5 questions, each questions has 1 marks");
            pointJsonList();
        }
    }

    private static void pointJsonList() throws IOException, ParseException {

        String fileName = "./src/main/resources/Quiz.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            int random = (int) (Math.random() * 20) + 1;
            JSONObject jsonObj1 = (JSONObject) jsonArray.get(random);
            String Question = (String) jsonObj1.get("Question");
            String A = (String) jsonObj1.get("Option a");
            String B = (String) jsonObj1.get("Option b");
            String C = (String) jsonObj1.get("Option c");
            String D = (String) jsonObj1.get("Option d");
            String CorrectAnswer = (String) jsonObj1.get("answer");
            System.out.println(i + "." + Question);
            System.out.println("a. " + A + "\nb. " + B + "\nc. " + C + "\nd. " + D);
            System.out.println("Give the correct answer  as the following option: ");
            String input = sc.nextLine();
            if (input.equals(CorrectAnswer)) {
                count++;
                System.out.println(" correct!");
            } else {
                System.out.println("Not Correct");
            }
            System.out.println("Your got " + count + " Marks Out of 5 ");
        }
    }

    private static void writeJSONList() throws IOException, org.json.simple.parser.ParseException {
        char ch = 'y';
        String fileName = "./src/main/resources/Quiz.json";
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONObject studentObj = new JSONObject();

            Scanner input = new Scanner(System.in);
            System.out.println("Please add a question here : ");
            studentObj.put("Question", input.nextLine());

            System.out.println("Option a : ");
            studentObj.put("Option a", input.nextLine());

            System.out.println("Option b : ");
            studentObj.put("Option b", input.nextLine());

            System.out.println("Option c : ");
            studentObj.put("Option c", input.nextLine());

            System.out.println("Option d : ");
            studentObj.put("Option d", input.nextLine());

            System.out.println("Please input the correct answer : ");
            studentObj.put("answer", input.nextLine());

            JSONArray jsonStudentArray = (JSONArray) obj;
            jsonStudentArray.add(studentObj);
            FileWriter file = new FileWriter(fileName);
            file.write(jsonStudentArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Question saved.");
            System.out.println("Do you want to add more?[y/n]");
            ch = input.next().charAt(0);
        }
        while (ch != 'n');

    }
}