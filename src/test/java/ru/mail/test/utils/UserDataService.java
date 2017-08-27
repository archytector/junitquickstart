package ru.mail.test.utils;

import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import static java.util.stream.Collectors.toList;

/**
 * Created by olga on 19.08.17.
 */
public class UserDataService {

    private static final LinkedBlockingQueue<LoginPassword> usersData = new LinkedBlockingQueue<>();

    static {
        File file = new File(Constants.FILENAME);
        try {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            usersData.addAll(lines.stream()
                .map(s -> {
                    String[] loginPasswordPair = s.split(" +");
                    return new LoginPassword(loginPasswordPair[0], loginPasswordPair[1]);
                })
                .collect(toList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static LoginPassword getNextLoginPassword() throws InterruptedException {
        return usersData.take();
    }

    public static void freeLoginPasword(LoginPassword loginPassword) {
        usersData.add(loginPassword);
    }

    @Data
    public static class LoginPassword implements Comparable<LoginPassword> {
        private final String login;
        private final String password;

        @Override
        public int compareTo(LoginPassword loginPassword) {
            return this.hashCode() - loginPassword.hashCode();
        }
    }
}
