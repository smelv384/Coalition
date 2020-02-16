/**
 * Made by the U of C-MRU Coalition for the Purpose of Victory in CalgaryHacks2020
 * Author: Shaemus Melvin
 */

package CalgaryHacks2020;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class StudentReader {
    private String fileName;

    public StudentReader(String fileName) {
        this.fileName = fileName;
    }

    public Student read(String scheduleFileName) {
        Scanner in = new Scanner(System.in);
        try {
            File inFile = new File(fileName);
            in = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.println("This should literally never happen");
        }
        String studentName = in.nextLine();
        Schedule studentSchedule;
        ScheduleBuilder studentScheduleBuilder = new ScheduleBuilder();
        studentSchedule = studentScheduleBuilder.build(scheduleFileName); //this is made assuming classical naming conventions for the builder method
        String studentUcID = in.nextLine();

        Student newStudent = new Student(studentName, studentSchedule, studentUcID);
        return newStudent;



        in.close();
    }
}