package home.petproject.studentorder.validator;

import home.petproject.studentorder.domain.wedding.AnswerWedding;
import home.petproject.studentorder.domain.StudentOrder;

public class WeddingValidator {
    public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding is running");
        AnswerWedding aw = new AnswerWedding();
        return aw;
    }
}
