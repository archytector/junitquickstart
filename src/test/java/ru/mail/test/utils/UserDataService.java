package ru.mail.test.utils;

import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import static java.util.stream.Collectors.toList;

/**
 * Created by olga on 19.08.17.
 */
public class UserDataService {

    private static final ArrayBlockingQueue<LoginPassword> usersData;

    static {
        File file = new File(Constants.FILENAME);
        try {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            usersData = new ArrayBlockingQueue<>(
                lines.size(),
                false,
                lines.stream()
                    .map(s -> {
                        String[] loginPasswordPair = s.split(" +");
                        return new LoginPassword(loginPasswordPair[0], loginPasswordPair[1]);
                    })
                    .collect(toList())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static LoginPassword getNextLoginPassword() throws InterruptedException {
        return usersData.take();
    }

    public static void freeLoginPassword(LoginPassword loginPassword) {
        try {
            usersData.put(loginPassword);
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted");
        }
    }

    @Data
    public static class LoginPassword {
        private final String login;
        private final String password;
    }
}
