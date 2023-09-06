package application.services;

import application.entities.User;
import application.exceptions.CreateException;
import application.repositories.UserCreateRepository;
import application.utils.Constants;
import application.utils.AgeValidator;

import java.util.HashMap;
import java.util.Map;

public class UserCreateService {

    UserCreateRepository repository;

    public UserCreateService(UserCreateRepository repository) {
        this.repository = repository;
    }

    public String createUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {

        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);

        if (data[1].isEmpty())
            errors.put("last name", Constants.INPUT_REQ_MSG);

        if (AgeValidator.isAgeValid(data[2]))
            errors.put("age", Constants.WRONG_AGE_MSG);

        if (data[3].isEmpty())
            errors.put("profession", Constants.INPUT_REQ_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setFirstName(data[0]);
        user.setLastName(data[1]);
        user.setAge(data[2]);
        user.setProfession(data[3]);
        return user;
    }

}
