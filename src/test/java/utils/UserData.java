package utils;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by olga on 19.08.17.
 */
public class UserData {

    private static final String FILENAME = "";

    public enum EnumSingleton {
        INSTANCE();

        private final HashMap<String, String> usersData;

        private EnumSingleton() {
            usersData = new HashMap<>();
//            BufferedReader in = null;
//            try {
//                in = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));
//                String str = null;
//                while ((str = in.readLine()) != null) {
//                    //TODO check format Preconditions
//                    String arr[] = str.split(" ");
//                    usersData.put(arr[0], arr[1]);
//                    //TODO add logins to set
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);



        }

        public LoginPassword getNextLoginPassword() {
            return null;
        }

        public void freeLoginPasword(LoginPassword lp) {

        }
    }

    @Data
    class LoginPassword {

    }
}
