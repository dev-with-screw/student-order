package home.petproject.studentorder.validator.register;

import home.petproject.studentorder.domain.register.CityRegisterResponse;
import home.petproject.studentorder.domain.Person;
import home.petproject.studentorder.exception.CityRegisterException;
import home.petproject.studentorder.exception.TransportException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException;
}
