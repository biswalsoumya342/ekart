package com.soumya.ekart.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderUtil {

    public static String orderIdGenerator(){
        return "OD" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
