package lk.ijse.backendforpossystemusingspring.util;

import java.util.UUID;

public class AppUtil {

    public static String OrderDetailsId(){
        return "ORDER_DETAIL-" + UUID.randomUUID();
    }

}
