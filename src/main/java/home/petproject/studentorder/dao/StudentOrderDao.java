package home.petproject.studentorder.dao;

import home.petproject.studentorder.domain.StudentOrder;
import home.petproject.studentorder.exception.DaoException;

import java.util.List;

public interface StudentOrderDao {
    Long saveStudentOrder(StudentOrder so) throws DaoException;

    List<StudentOrder> getStudentOrders() throws DaoException;
}
