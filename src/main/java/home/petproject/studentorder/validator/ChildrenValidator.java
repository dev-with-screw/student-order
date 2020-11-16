package home.petproject.studentorder.validator;

import home.petproject.studentorder.domain.children.AnswerChildren;
import home.petproject.studentorder.domain.StudentOrder;

public class ChildrenValidator {
    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children is running");
        AnswerChildren ac = new AnswerChildren();
        return ac;
    }
}
