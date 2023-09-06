package application.controllers;

import application.services.UserDeleteService;
import application.utils.AppStarter;
import application.views.UserDeleteView;

public class UserDeleteController {

    UserDeleteService service;
    UserDeleteView view;

    public UserDeleteController(UserDeleteService service, UserDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deleteContact() {
        view.getOutput(service.deleteUser(view.getData()));
        AppStarter.startApp();
    }

}
