package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

//Header with token for Performance Design Save...
    public static Map<String,String> headerWithToken1()
    {
        String token= "NDY2MGIyZTUtNTRmMS00YzJiLWEwZDQtNjQyYWYzMTYwN2Q0X2phdmVkLmFsaUBwZW9wbGVzdHJvbmcuY29tX19fX18xOQ==";
        Map<String ,String > headerWithToken1=new HashMap<String,String>();
        headerWithToken1.put("Accept","application/json, text/plain, */*");
        headerWithToken1.put("Accept-Language","en-US,en;q=0.9");
        headerWithToken1.put("Connection","keep-alive");
        headerWithToken1.put("Content-Type","application/json;charset=UTF-8");
        headerWithToken1.put("Cookie","__utmc=202868750; __utmz=202868750.1706072527.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _gid=GA1.2.257253781.1706076065; AccessToken=; RefreshToken=; SessionToken=\"MGI0ZmIwOTAtYmE3YS00OTc3LWFmZGMtZDNhOTg2ODdkNDlmX3NvbWVuLmRhc0BwZW9wbGVzdHJvbmcuY29tX19fX18xOQ==\"; _ga_48310Z67ZG=GS1.2.1706090396.4.1.1706091623.0.0.0; __utma=202868750.284459157.1706072527.1706090380.1706093817.6; _ga=GA1.1.284459157.1706072527; _ga_PNQ03PRKNY=GS1.1.1706094043.4.0.1706094056.0.0.0; qliqueSess=eyJvcmdNZXRhZGF0YSI6eyJPUkdfUkVQTFlfRU1BSUwiOiJwZXJmb3JtYW5jZTEyM0BwZW9wbGVzdHJvbmcuY29tIiwiT1JHX0hSX0VNQUlMX0lEIjoicGVyZm9ybWFuY2UxMjNAcGVvcGxlc3Ryb25nLmNvbSIsIk9SR19FTUFJTF9GUk9NX05BTUUiOiJBbHQgUGVyZm9ybWFuY2UxMjMiLCJPUkdfR09BTF9OQU1FIjoiT2JqZWN0aXZlIiwiT1JHX01JTEVTVE9ORV9OQU1FIjoiS2V5IFJlc3VsdCIsIk9SR19JRFBfTkFNRSI6IklEUCIsIk9SR19QUk9CQVRJT05fTkFNRSI6IlByb2JhdGlvbiBSZXZpZXciLCJPUkdfTVVMVElSQVRFUl9OQU1FIjoiTXVsdGkgUmF0ZXIiLCJPUkdfUElQX05BTUUiOiJQSVAgIiwiT1JHX0FVVEhfVFlQRSI6IkNVU1RPTV9TU08iLCJPUkdfTkFNRSI6IlBlcmZvcm1hbmNlIiwiT1JHX09SSUdJTkFMX05BTUUiOiJQZW9wbGVTdHJvbmciLCJDTElFTlRTSURFX0JBU0VfVVJMIjoiaHR0cHM6Ly9zdGFnaW5nLWhybXMtcGVyZm9ybWFuY2UucGVvcGxlc3Ryb25nLmNvbSIsIlNFUlZFUlNJREVfQkFTRV9VUkwiOiJodHRwczovL3N0YWdpbmctZW1wc2VydmVyLnBlb3BsZXN0cm9uZy5jb20iLCJHT0FMX0NMSUVOVFNJREVfQkFTRV9VUkwiOiJodHRwczovL3N0YWdpbmctaHJtcy1wZXJmb3JtYW5jZS5wZW9wbGVzdHJvbmcuY29tIiwiR09BTF9TRVJWRVJTSURFX0JBU0VfVVJMIjoiaHR0cHM6Ly9zdGFnaW5nLWdvYWxzZXJ2ZXIucGVvcGxlc3Ryb25nLmNvbSIsIk9SR19DT1JQX1NPRlRfTkFNRSI6Ik5vdGljZSBCb2FyZCIsIkNMSUVOVFNJREVfU1VSVkVZX1VSTCI6Imh0dHBzOi8vc3RhZ2luZy1ocm1zLXBlcmZvcm1hbmNlc3VydmV5LnBlb3BsZXN0cm9uZy5jb20iLCJTRVJWRVJTSURFX1NVUlZFWV9VUkwiOiJodHRwczovL3N0YWdpbmctaHJtcy1wZXJmb3JtYW5jZXN1cnZleS5wZW9wbGVzdHJvbmcuY29tOjcwMTAiLCJTRVJWRVJTSURFX0RBU0hCT0FSRF9VUkwiOiJodHRwczovL3N0YWdpbmctZW1wc2VydmVyLnBlb3BsZXN0cm9uZy5jb20iLCJDTElFTlRTSURFX0RBU0hCT0FSRF9VUkwiOiJodHRwczovL3N0YWdpbmctaHJtcy1wZXJmb3JtYW5jZWRhc2hib2FyZC5wZW9wbGVzdHJvbmcuY29tIiwiT05FX1dFQl9VUkwiOiJodHRwczovL3N0YWdpbmctaHJtcy5wZW9wbGVzdHJvbmcuY29tIiwiSVNfT05FX0VYUCI6MSwiSVNfU0VORE1BSUxfT05fU09DSUFMIjoiTiIsIk9SR19IT01FX1VSTCI6Imluc2lnaHRzIiwiR09BTF9FTkFCTEVfTUFJTF9TRU5EIjoiWSIsIkVOQUJMRV9EQUlMWV9XT1JLTElTVCI6Ik4iLCJRSUxPX0lNUExFTUVOVEFUSU9OX1RZUEUiOiJQTVMiLCJFTlRJVFlfSUQiOjEyLCJFTlRJVFlfTkFNRSI6IlBlb3BsZVN0cm9uZyBIUiBTZXJ2aWNlcyBQdnQuIEx0ZC4iLCJPUkdfR09BTF9NRU5VX05BTUUiOiJPS1IifX0=; qliqueSess.sig=uwaSjT63lD6F-wc2p7ES5dxmCwQ");
        headerWithToken1.put("Origin","https://staging-hrms-performancedashboard.peoplestrong.com");
        headerWithToken1.put("Referer","https://staging-hrms-performancedashboard.peoplestrong.com");
        headerWithToken1.put("Sec-Fetch-Dest","empty");
        headerWithToken1.put("Sec-Fetch-Mode","cors");
        headerWithToken1.put("Sec-Fetch-Site","same-origin");
        headerWithToken1.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        headerWithToken1.put("sec-ch-ua","\"Not_A Brand\";v=\"8\", \"Chromium\";v=\"120\", \"Google Chrome\";v=\"120\"");
        headerWithToken1.put("sec-ch-ua-mobile","?0");
        headerWithToken1.put("sec-ch-ua-platform","\"Windows\"");
        headerWithToken1.put("x-access-token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDc2NTE4MTQyMzIsImlzcyI6InBlcmZvcm1hbmNlIiwidXNlckluZm8iOnsidXNlcl9pZCI6MjkxNjQsIm9yZ19pZCI6ODEsInVzZXJuYW1lIjoiamF2ZWQuYWxpQHBlb3BsZXN0cm9uZy5jb20iLCJlbXBfY29kZSI6IjIxMTU3In19.br2RA9qFY5kvDzz2S-9THs20hWjbiFSvJjBIy8ygVLw");
        headerWithToken1.put("x-key","29164");
        headerWithToken1.put("x-org","81");
        headerWithToken1.put("x-session-token",token);
        return headerWithToken1;
    }
    public static Map<String,String> headerWithToken(){
        String token= "Mjk0ZDQ3YzItYjgyNy00YTBiLWI3NGQtYjU3NmQzOTE1N2U3X2phdmVkLmFsaUBwZW9wbGVzdHJvbmcuY29tX19fX18xOQ==";
        Map<String ,String > headerWithToken=new HashMap<String,String>();
        headerWithToken.put("Accept","*/*");
        headerWithToken.put("Accept-Language","en-US,en;q=0.9");
        headerWithToken.put("Connection","keep-alive");
        headerWithToken.put("Origin","https://staging-hrms.peoplestrong.com");
        headerWithToken.put("Referer","https://staging-hrms.peoplestrong.com/pmsxp/");
        headerWithToken.put("Sec-Fetch-Dest","empty");
        headerWithToken.put("Sec-Fetch-Mode","cors");
        headerWithToken.put("Sec-Fetch-Site","same-site");
        headerWithToken.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        headerWithToken.put("bundleId","1");
        headerWithToken.put("bundle_name","EN");
        headerWithToken.put("Content-Type","application/json;charset=UTF-8");
        headerWithToken.put("device_info","chrome-5.0_(windows_nt_10.0;_win64;_x64)_applewebkit/537.36_(khtml,_like_gecko)_chrome/120.0.0.0_safari/537.36");
        headerWithToken.put("platform","web");
        headerWithToken.put("sec-ch-ua","\"Not_A Brand\";v=\"8\", \"Chromium\";v=\"120\", \"Google Chrome\";v=\"120\"");
        headerWithToken.put("sec-ch-ua-mobile","?0");
        headerWithToken.put("sec-ch-ua-platform","\"Windows\"");
        headerWithToken.put("session_token",token);
        headerWithToken.put("sessiontoken",token);
        headerWithToken.put("timezone","Asia/Calcutta");
        return headerWithToken;
    }

//    public static Map<String,String> headerWithToken2()
//    {
//        String token= "MWNlYjg0MGItYWE0NC00MjY2LTkxYzEtOGFmMjkwOWM3NTcwX2phdmVkLmFsaUBwZW9wbGVzdHJvbmcuY29tX19fX18xOQ==";
//        Map<String ,String > headerWithToken2=new HashMap<String,String>();
//        headerWithToken2.put("Accept","application/json, text/plain, */*");
//        headerWithToken2.put("Accept-Encoding:","gzip, deflate, br");
//        headerWithToken2.put("Accept-Language","en-US,en;q=0.9");
//        headerWithToken2.put("Connection","keep-alive");
//        headerWithToken2.put("Content-Type","application/json;charset=UTF-8");
//        headerWithToken2.put("Cookie","__utmc=202868750; __utmz=202868750.1705302536.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); AccessToken=; RefreshToken=; _gid=GA1.2.1444515905.1705323451; _ga_48310Z67ZG=GS1.2.1705323453.1.1.1705323466.0.0.0; _ga=GA1.1.1987324604.1705302735; __utma=202868750.1951391506.1705302536.1705392912.1705395620.5; SessionToken=\"MjYxMDQ0YWEtZjliOC00NGNlLTgwYjAtOGNmMjM0NTQ5YjYzX2phdmVkLmFsaUBwZW9wbGVzdHJvbmcuY29tX19fX18xOQ==\"; _ga_PNQ03PRKNY=GS1.1.1705395618.7.1.1705395658.0.0.0; qliqueSess=eyJvcmdNZXRhZGF0YSI6eyJPUkdfUkVQTFlfRU1BSUwiOiJwZXJmb3JtYW5jZTEyM0BwZW9wbGVzdHJvbmcuY29tIiwiT1JHX0hSX0VNQUlMX0lEIjoicGVyZm9ybWFuY2UxMjNAcGVvcGxlc3Ryb25nLmNvbSIsIk9SR19FTUFJTF9GUk9NX05BTUUiOiJBbHQgUGVyZm9ybWFuY2UxMjMiLCJPUkdfR09BTF9OQU1FIjoiT2JqZWN0aXZlIiwiT1JHX01JTEVTVE9ORV9OQU1FIjoiS2V5IFJlc3VsdCIsIk9SR19JRFBfTkFNRSI6IklEUCIsIk9SR19QUk9CQVRJT05fTkFNRSI6IlByb2JhdGlvbiBSZXZpZXciLCJPUkdfTVVMVElSQVRFUl9OQU1FIjoiTXVsdGkgUmF0ZXIiLCJPUkdfUElQX05BTUUiOiJQSVAgIiwiT1JHX0FVVEhfVFlQRSI6IkNVU1RPTV9TU08iLCJPUkdfTkFNRSI6IlBlcmZvcm1hbmNlIiwiT1JHX09SSUdJTkFMX05BTUUiOiJQZW9wbGVTdHJvbmciLCJDTElFTlRTSURFX0JBU0VfVVJMIjoiaHR0cHM6Ly9zdGFnaW5nLWhybXMtcGVyZm9ybWFuY2UucGVvcGxlc3Ryb25nLmNvbSIsIlNFUlZFUlNJREVfQkFTRV9VUkwiOiJodHRwczovL3N0YWdpbmctZW1wc2VydmVyLnBlb3BsZXN0cm9uZy5jb20iLCJHT0FMX0NMSUVOVFNJREVfQkFTRV9VUkwiOiJodHRwczovL3N0YWdpbmctaHJtcy1wZXJmb3JtYW5jZS5wZW9wbGVzdHJvbmcuY29tIiwiR09BTF9TRVJWRVJTSURFX0JBU0VfVVJMIjoiaHR0cHM6Ly9zdGFnaW5nLWdvYWxzZXJ2ZXIucGVvcGxlc3Ryb25nLmNvbSIsIk9SR19DT1JQX1NPRlRfTkFNRSI6Ik5vdGljZSBCb2FyZCIsIkNMSUVOVFNJREVfU1VSVkVZX1VSTCI6Imh0dHBzOi8vc3RhZ2luZy1ocm1zLXBlcmZvcm1hbmNlc3VydmV5LnBlb3BsZXN0cm9uZy5jb20iLCJTRVJWRVJTSURFX1NVUlZFWV9VUkwiOiJodHRwczovL3N0YWdpbmctaHJtcy1wZXJmb3JtYW5jZXN1cnZleS5wZW9wbGVzdHJvbmcuY29tOjcwMTAiLCJTRVJWRVJTSURFX0RBU0hCT0FSRF9VUkwiOiJodHRwczovL3N0YWdpbmctZW1wc2VydmVyLnBlb3BsZXN0cm9uZy5jb20iLCJDTElFTlRTSURFX0RBU0hCT0FSRF9VUkwiOiJodHRwczovL3N0YWdpbmctaHJtcy1wZXJmb3JtYW5jZWRhc2hib2FyZC5wZW9wbGVzdHJvbmcuY29tIiwiT05FX1dFQl9VUkwiOiJodHRwczovL3N0YWdpbmctaHJtcy5wZW9wbGVzdHJvbmcuY29tIiwiSVNfT05FX0VYUCI6MSwiSVNfU0VORE1BSUxfT05fU09DSUFMIjoiTiIsIk9SR19IT01FX1VSTCI6Imluc2lnaHRzIiwiR09BTF9FTkFCTEVfTUFJTF9TRU5EIjoiWSIsIkVOQUJMRV9EQUlMWV9XT1JLTElTVCI6Ik4iLCJRSUxPX0lNUExFTUVOVEFUSU9OX1RZUEUiOiJQTVMiLCJFTlRJVFlfSUQiOjEyLCJFTlRJVFlfTkFNRSI6IlBlb3BsZVN0cm9uZyBIUiBTZXJ2aWNlcyBQdnQuIEx0ZC4iLCJPUkdfR09BTF9NRU5VX05BTUUiOiJPS1IifX0=; qliqueSess.sig=uwaSjT63lD6F-wc2p7ES5dxmCwQ");
//        headerWithToken2.put("Origin","https://staging-hrms-performancedashboard.peoplestrong.com");
//        headerWithToken2.put("Referer","https://staging-hrms-performancedashboard.peoplestrong.com");
//        headerWithToken2.put("Sec-Fetch-Dest","empty");
//        headerWithToken2.put("Sec-Fetch-Mode","cors");
//        headerWithToken2.put("Sec-Fetch-Site","same-origin");
//        headerWithToken2.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
//        headerWithToken2.put("sec-ch-ua","\"Not_A Brand\";v=\"8\", \"Chromium\";v=\"120\", \"Google Chrome\";v=\"120\"");
//        headerWithToken2.put("sec-ch-ua-mobile","?0");
//        headerWithToken2.put("sec-ch-ua-platform","\"Windows\"");
//        headerWithToken2.put("x-access-token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDc2NTE4MTQyMzIsImlzcyI6InBlcmZvcm1hbmNlIiwidXNlckluZm8iOnsidXNlcl9pZCI6MjkxNjQsIm9yZ19pZCI6ODEsInVzZXJuYW1lIjoiamF2ZWQuYWxpQHBlb3BsZXN0cm9uZy5jb20iLCJlbXBfY29kZSI6IjIxMTU3In19.br2RA9qFY5kvDzz2S-9THs20hWjbiFSvJjBIy8ygVLw");
//        headerWithToken2.put("x-key","29164");
//        headerWithToken2.put("x-org","81");
//        headerWithToken2.put("x-session-token",token);
//        return headerWithToken2;
//    }

}
