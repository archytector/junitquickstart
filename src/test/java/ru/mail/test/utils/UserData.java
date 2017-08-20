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
public class UserData {

    private static final String FILE_NAME = "src/test/resourses/test_logins.txt";

    public enum EnumSingleton {
        INSTANCE();

        private final LinkedBlockingQueue<LoginPassword> usersData = new LinkedBlockingQueue<>();

        EnumSingleton() {
            File file = new File(FILE_NAME);
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

        public LoginPassword getNextLoginPassword() throws InterruptedException {
            return usersData.poll(30, TimeUnit.SECONDS);
        }

        public void freeLoginPasword(LoginPassword loginPassword) {
            usersData.add(loginPassword);
        }
    }

    @Data
    public static class LoginPassword implements Comparable<LoginPassword>{
        private final String login;
        private final String password;

        @Override
        public int compareTo(LoginPassword loginPassword) {
            return this.hashCode() - loginPassword.hashCode();
        }
    }
}
