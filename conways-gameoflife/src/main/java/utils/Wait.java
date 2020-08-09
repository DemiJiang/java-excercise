package utils;

import java.util.concurrent.TimeUnit;

public class Wait {
    public static void pause() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
