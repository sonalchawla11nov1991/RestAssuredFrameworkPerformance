package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {
    /*DurgeshRestAssured*/
    public static Map<String ,String > deafultHeaders(){

        Map<String,String> deafultHeaders=new HashMap<String ,String>();
        deafultHeaders.put("Content-Type","application/json");
        return deafultHeaders;
    }

    public static Map<String,String> headerWithToken(){
        Map<String ,String > headerWithToken=new HashMap<String,String>();
        headerWithToken.put("Content-Type","application/json");
        headerWithToken.put("Access-Token","gsjjgsjkaKJAGJGASJJHSAD");
        headerWithToken.put("jwt-token","jhksalkuelmmladje");

        return headerWithToken;
    }

}
