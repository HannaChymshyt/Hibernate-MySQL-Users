package application.utils;

import application.controllers.AppController;
import application.services.AppService;
import application.views.AppView;

public class AppStarter {

    public static void startApp() {
        AppService service = new AppService();
        AppView view = new AppView();
        AppController controller = new AppController(view, service);
        controller.runApp();
    }

}
