package application.services;

import application.entities.User;
import application.exceptions.UpdateException;
import application.repositories.UserUpdateRepository;
import application.utils.Constants;
import application.utils.IdValidator;
import application.utils.AgeValidator;

import java.util.HashMap;
import java.util.Map;

public class UserUpdateService {

    UserUpdateRepository repository;

    public UserUpdateService(UserUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUser(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repository.updateUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {

        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setProfession(data[1]);
        return user;
    }

}
