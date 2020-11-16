package home.petproject.studentorder;

import home.petproject.studentorder.dao.StudentOrderDaoImpl;
import home.petproject.studentorder.domain.*;
import home.petproject.studentorder.domain.children.AnswerChildren;
import home.petproject.studentorder.domain.register.AnswerCityRegister;
import home.petproject.studentorder.domain.student.AnswerStudent;
import home.petproject.studentorder.domain.wedding.AnswerWedding;
import home.petproject.studentorder.exception.DaoException;
import home.petproject.studentorder.mail.MailSender;
import home.petproject.studentorder.validator.ChildrenValidator;
import home.petproject.studentorder.validator.CityRegisterValidator;
import home.petproject.studentorder.validator.StudentValidator;
import home.petproject.studentorder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

   public void checkAll() {
        try {
            List<StudentOrder> soList = readStudentOrders();

            for (StudentOrder so : soList) {
                System.out.println();
                checkOneOrder(so);
                System.out.println();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<StudentOrder> readStudentOrders() throws DaoException {
        return  new StudentOrderDaoImpl().getStudentOrders();

        //        List<StudentOrder> soList = new LinkedList<>();

//        for (int i = 0; i < 5; i++) {
//           // StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
//            soList.add(so);
//        }
//        return soList;
    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//
//        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}
