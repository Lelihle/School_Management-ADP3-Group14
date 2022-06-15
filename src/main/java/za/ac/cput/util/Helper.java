package za.ac.cput.util;

import org.apache.commons.lang3.StringUtils;

public class Helper {
    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){
        if (isEmptyOrNull(str)) return StringUtils.EMPTY;
        return str;
    }

    public static void checkStringParam(String paramName, String paramValue){
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }

    public static String checkId(String id) {
        if(isEmptyOrNull(id))
            throw new IllegalArgumentException("invalid details provided");
        return id;
    }
}
