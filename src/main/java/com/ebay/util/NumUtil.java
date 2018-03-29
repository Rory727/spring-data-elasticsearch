package com.ebay.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created by ruirli on 2018/3/29.
 * Parses the parameters of the number type then return non-null.
 */
public class NumUtil {
    public static Long parseLong(String src) throws Exception{
        if(StringUtils.isEmpty(src)){
            return 0L;
        }else{
            return Long.parseLong(src);
        }
    }

    public static Integer parseInteger(String src) throws Exception{
        if(StringUtils.isEmpty(src)){
            return 0;
        }else{
            return Integer.parseInt(src);
        }
    }

    public static Double parseDouble(String src) throws Exception{
        if(StringUtils.isEmpty(src)){
            return 0.00;
        }else{
            return Double.parseDouble(src);
        }
    }

    public static Float parseFloat(String src) throws Exception{
        if(StringUtils.isEmpty(src)){
            return 0.00F;
        }else{
            return Float.parseFloat(src);
        }
    }
}
