package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {


    public static Map<String,String> headerWithToken(){
        Map<String ,String > headerWithToken=new HashMap<String,String>();
        headerWithToken.put("Content-Type","application/json");
        headerWithToken.put("Access-Token","gsjjgsjkaKJAGJGASJJHSAD");
        headerWithToken.put("jwt-token","jhksalkuelmmladje");
        return headerWithToken;
    }

}
