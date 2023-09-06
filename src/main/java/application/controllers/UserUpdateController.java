package application.controllers;

import application.services.UserUpdateService;
import application.utils.AppStarter;
import application.views.UserUpdateView;

public class UserUpdateController {

    UserUpdateService service;
    UserUpdateView view;

    public UserUpdateController(UserUpdateService service, UserUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateUser() {
        view.getOutput(service.updateUser(view.getData()));
        AppStarter.startApp();
    }

}
