package util;

import java.util.UUID;

public class CreateUUID {
    public static String createID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
