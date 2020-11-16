package home.petproject.studentorder.dao;

import home.petproject.studentorder.domain.CountryArea;
import home.petproject.studentorder.domain.PassportOffice;
import home.petproject.studentorder.domain.RegisterOffice;
import home.petproject.studentorder.domain.Street;
import home.petproject.studentorder.exception.DaoException;

import java.util.List;

public interface DictionaryDao {

    List<Street> findStreet(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffices(String areaID) throws DaoException;
    List<RegisterOffice> findRegisterOffices(String areaID) throws DaoException;
    List<CountryArea> findAreas(String areaID) throws DaoException;
}
