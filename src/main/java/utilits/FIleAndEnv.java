package utilits;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FIleAndEnv {
    public static Map<String ,String > fileandenv=new HashMap<>();
    public static Properties propMain=new Properties();
    public static  Properties propPreSet=new Properties();
    public static Map<String ,String > envAndFile() throws IOException {
//        String environment = System.getProperty("env");
//        if (environment.equalsIgnoreCase("dev")) {
            FileInputStream fisDev = new FileInputStream(System.getProperty("user.dir") + "/inputs/dev.properties");
            propMain.load(fisDev);
            fileandenv.put("ServerUrl", propMain.getProperty("ServerUrl"));
            fileandenv.put("Username", propMain.getProperty("Username"));
            fileandenv.put("Password", propMain.getProperty("Password"));
//            } else if (environment.equalsIgnoreCase("qa")) {
//                FileInputStream fisQa=new FileInputStream(System.getProperty("user.dir")+"/inputs/qa.properties");
//                propMain.load(fisQa);
//                fileandenv.put("ServerValue", propMain.getProperty("ServerUrl"));
//                fileandenv.put("Username", propMain.getProperty("Username"));
//                fileandenv.put("Password", propMain.getProperty("Password"));
//            }
            return fileandenv;
        }
//    public static Map<String ,String > getConfigReader()  {
//        if (fileandenv==null){
//            fileandenv=envAndFile();
//        }
//        return fileandenv;
//    }


}
