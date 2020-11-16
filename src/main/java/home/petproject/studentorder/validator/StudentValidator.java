package home.petproject.studentorder.validator;

import home.petproject.studentorder.domain.student.AnswerStudent;
import home.petproject.studentorder.domain.StudentOrder;

public class StudentValidator {
    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Student is running");
        AnswerStudent as = new AnswerStudent();
        return as;
    }
}
