package application.services;

import application.entities.User;
import application.repositories.UserReadRepository;
import application.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserReadService {

    UserReadRepository repository;

    public UserReadService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readUsers() {

        List<User> list = repository.readUsers();

        if (list != null) {

            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((user) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(user.getId())
                                .append(", ")
                                .append(user.getFirstName())
                                .append(" ")
                                .append(user.getLastName())
                                .append(", ")
                                .append(user.getAge())
                                .append(", ")
                                .append(user.getProfession())
                                .append("\n")
                );
                return "\n______ USERS ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }

}
