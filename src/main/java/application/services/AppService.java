package application.services;

import application.controllers.UserCreateController;
import application.controllers.UserDeleteController;
import application.controllers.UserReadController;
import application.controllers.UserUpdateController;
import application.exceptions.OptionException;
import application.repositories.UserCreateRepository;
import application.repositories.UserDeleteRepository;
import application.repositories.UserReadRepository;
import application.repositories.UserUpdateRepository;
import application.utils.AppStarter;
import application.utils.Constants;
import application.views.UserCreateView;
import application.views.UserDeleteView;
import application.views.UserReadView;
import application.views.UserUpdateView;

public class AppService {

    public void createUser() {
        UserCreateRepository repository = new UserCreateRepository();
        UserCreateService service = new UserCreateService(repository);
        UserCreateView view = new UserCreateView();
        UserCreateController controller = new UserCreateController(service, view);
        controller.createUser();
    }

    public void readUsers() {
        UserReadRepository repository = new UserReadRepository();
        UserReadService service = new UserReadService(repository);
        UserReadView view = new UserReadView();
        UserReadController controller = new UserReadController(service, view);
        controller.readUsers();
    }

    public void updateUser() {
        UserUpdateRepository repository = new UserUpdateRepository();
        UserUpdateService service = new UserUpdateService(repository);
        UserUpdateView view = new UserUpdateView();
        UserUpdateController controller = new UserUpdateController(service, view);
        controller.updateUser();
    }

    public void deleteUser() {
        UserDeleteRepository repository = new UserDeleteRepository();
        UserDeleteService service = new UserDeleteService(repository);
        UserDeleteView view = new UserDeleteView();
        UserDeleteController controller = new UserDeleteController(service, view);
        controller.deleteContact();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }


    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }

}
