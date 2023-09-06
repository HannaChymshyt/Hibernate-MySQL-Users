package application.controllers;

import application.services.UserReadService;
import application.utils.AppStarter;
import application.views.UserReadView;

public class UserReadController {

    UserReadService service;
    UserReadView view;

    public UserReadController(UserReadService service, UserReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readUsers() {
        view.getOutput(service.readUsers());
        AppStarter.startApp();
    }

}
