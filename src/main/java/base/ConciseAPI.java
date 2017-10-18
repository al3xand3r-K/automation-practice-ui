package base;

import java.util.Random;

public class ConciseAPI {

    public String genEmail() {
        Random rand = new Random();
        String uid = "";
        for (int i = 0; i < 7; i++) {
            // generates random int between 0 and 9
            int randomNum = rand.nextInt(9 + 1);
            String strRandomNum = String.valueOf(randomNum);
            uid = uid.concat(strRandomNum);
        }
        return "qatest2278+" + uid + "@gmail.com";
    }

}
