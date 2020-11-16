package home.petproject.studentorder;

import home.petproject.studentorder.dao.StudentOrderDaoImpl;
import home.petproject.studentorder.dao.StudentOrderDao;
import home.petproject.studentorder.domain.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {


    public static void main(String[] args) throws Exception{
//        List<Street> d = new DictionaryDaoImpl().findStreet("про");
//        for (Street s : d) {
//            System.out.println(s.getStreetName());
//        }
//
//        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
//        for (PassportOffice p : po) {
//            System.out.println(p.getOfficeName());
//        }
//
//        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
//        for (RegisterOffice r : ro) {
//            System.out.println(r.getOfficeName());
//        }


//
//        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
//        for (CountryArea c : ca1) {
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }
//        System.out.println("---");
//        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
//        for (CountryArea c : ca2) {
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }
//        System.out.println("---");
//        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
//        for (CountryArea c : ca3) {
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }
//        System.out.println("---");
//        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
//        for (CountryArea c : ca4) {
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }

//        StudentOrder s = buildStudentOrder(10);
        StudentOrderDao dao = new StudentOrderDaoImpl();
//        Long id = dao.saveStudentOrder(s);
//        System.out.println(id);

        List<StudentOrder> soList = dao.getStudentOrders();
        for (StudentOrder so: soList) {
            System.out.println(so.getStudentOrderId());
        }
    }

    static StudentOrder buildStudentOrder(long id) {
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
