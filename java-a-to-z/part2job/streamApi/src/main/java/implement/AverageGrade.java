package implement;

import entity.Student;

import java.util.*;
import java.util.stream.Collectors;

public class AverageGrade {
    Student[] students;
    Map<String, Double> listAverageGrade = new HashMap<>();

    public AverageGrade(Student ... sStudents) {
        students = sStudents;
    }



    public Map<String, Double> getAverageGrade() {
        Map<String, Double> resultAverageGrade = new HashMap<>();
        List<OptionalDouble> avereges = new ArrayList<>();
        if (students.length != 0) {
            Arrays.stream(students).forEach(student -> {
                OptionalDouble avarage = Arrays.stream(students).filter(student1 -> student.getDepartment().equals(student1.getDepartment())
                ).mapToDouble(s -> s.getGrade()).average();
                resultAverageGrade.put(student.getDepartment(), avarage.getAsDouble());
            });
        }

        return resultAverageGrade;
    }

    public void printResult() {
        getAverageGrade().entrySet().stream().forEach(System.out::println);
    }

}
