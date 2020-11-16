package home.petproject.studentorder.dao;

import home.petproject.studentorder.domain.*;
import home.petproject.studentorder.exception.DaoException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class StudentOrderDaoImplTest {

    @BeforeClass
    public static void startUp() throws Exception {
        DBInit.startUp();
    }

    @Test
    public void saveStudentOrder() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test(expected = DaoException.class)
    public void saveStudentOrderError() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        so.getHusband().setSurName(null);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test
    public void getStudentOrders() throws DaoException {
        List<StudentOrder> list = new StudentOrderDaoImpl().getStudentOrders();
    }

    public StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificatedId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice ro = new RegisterOffice(1L, "", "");
        so.setMarriageOffice(ro);

        Street street = new Street(1L, "First street");

        Address address = new Address("195000", street, "12", "", "142");

        //муж
        Adult husband = new Adult("Петров","Виктор","Сергеевич", LocalDate.of(1997,8,24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(po1);
        husband.setStudentID("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L, ""));
        husband.setStudentID("HH12345");

        //жена
        Adult wife = new Adult("Петрова", "Вероника", "Алексеевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice po2 = new PassportOffice(2L, "", "");
        wife.setIssueDepartment(po2);
        wife.setStudentID("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));
        wife.setStudentID("WW12345");

        //ребенок
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018,6,29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018,6,11));
        RegisterOffice ro2 = new RegisterOffice(1L, "", "");
        child1.setIssueDepartment(ro2);
        child1.setAddress(address);

        //ребенок
        Child child2 = new Child("Петров", "Евгений", "Викторович", LocalDate.of(2018,6,29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018,7,19));
        RegisterOffice ro3 = new RegisterOffice(1L, "", "");
        child2.setIssueDepartment(ro3);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }

}