package implement;

import entity.Student;
import org.junit.Test;

import static entity.Student.Gender.*;
import static org.junit.Assert.*;

public class AverageGradeTest {


    Student one = new Student("Alex", 3, "A", FEMALE);
    Student two = new Student("Jon", 4, "A", FEMALE);
    Student three = new Student("Viltor", 5, "V", FEMALE);
    Student foth = new Student("Victoria", 4.5, "C", MALE);
    AverageGrade averageGrade = new AverageGrade(one, two, three, foth);

    @Test
    public void getResultToText() {
        averageGrade.printResult();
    }

}