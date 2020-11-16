package home.petproject.studentorder.validator;

import home.petproject.studentorder.domain.Person;
import home.petproject.studentorder.domain.register.AnswerCityRegister;
import home.petproject.studentorder.domain.Child;
import home.petproject.studentorder.domain.register.AnswerCityRegisterItem;
import home.petproject.studentorder.domain.register.CityRegisterResponse;
import home.petproject.studentorder.domain.StudentOrder;
import home.petproject.studentorder.exception.CityRegisterException;
import home.petproject.studentorder.exception.TransportException;
import home.petproject.studentorder.validator.register.CityRegisterChecker;
import home.petproject.studentorder.validator.register.FakeCityRegisterChecker;

import java.util.List;

public class CityRegisterValidator {
    public static final String IN_CODE = "NO_GRN";

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));

        for (Child child : so.getChildren()) {
            ans.addItem(checkPerson(child));
        }

        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;

        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting() ?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportException ex) {
            ex.printStackTrace();
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        }

        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status, person, error);

        return ans;
    }
}
