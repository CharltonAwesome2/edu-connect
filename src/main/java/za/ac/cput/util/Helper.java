package za.ac.cput.util;

import java.util.UUID;

/*
    Helper.java
    Utility class for validation and ID generation
    Author: Ayabonga Jervasio Yawa (221241558)
    Date: 17 March 2026
*/
public class Helper {
    public static boolean isEmptyOrNull(String str){
        if(str == null || str.isEmpty() || str.equalsIgnoreCase("null")){
            return true;
        }

        return false;
    }

    public static boolean isObjectNull(Object obj) {
        return obj == null;
    }

    public static Long generateID(){
        return UUID.randomUUID().getMostSignificantBits();
    }
}
