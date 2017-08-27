package ru.mail.test.utils;

import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toSet;

/**
 * Created by olga on 19.08.17.
 */
public class UserDataService {

    private static final int WAIT_TIME_IN_MINUTES = 1;
    private static final LinkedBlockingQueue<LoginPassword> usersData = new LinkedBlockingQueue<>();

    {
        File file = new File(Constants.FILENAME);
        try {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            usersData.addAll(lines.stream()
                .map(s -> {
                    String[] loginPasswordPair = s.split(" +");
                    return new LoginPassword(loginPasswordPair[0], loginPasswordPair[1]);
                })
                .collect(toSet()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static LoginPassword getNextLoginPassword() throws InterruptedException {
        LoginPassword loginPassword;
//        while ((loginPassword = (WAIT_TIME_IN_MINUTES, TimeUnit.MINUTES)) == null) {
//        }
        usersData.take();
        return loginPassword;
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
