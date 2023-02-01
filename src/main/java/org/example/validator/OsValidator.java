package org.example.validator;

import java.io.File;
import java.util.logging.Logger;

public class OsValidator {
    private static String OS = System.getProperty("os.name").toLowerCase();
    public static boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
    public static boolean IS_MAC = (OS.indexOf("mac") >= 0);
    public static boolean IS_UNIX = (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    public static boolean IS_SOLARIS = (OS.indexOf("sunos") >= 0);
    private static Logger LOGGER = Logger.getLogger("OsValidator");

    public String getPath(){
        OS = OS.substring(0,7);
        String path = System. getProperty("user.dir") + File.separator + "chromeDriver" + File.separator;
        if (IS_WINDOWS) {
            LOGGER.info("This is Windows");
            OS = OS.substring(0,7);
            return path + OS + File.separator + "chromedriver.exe";
        } else if (IS_MAC) {
            LOGGER.info("This is Mac");
            return path + OS + File.separator + "chromedriver";
        } else if (IS_UNIX) {
            LOGGER.info("This is Unix or Linux");
            return path + OS + File.separator + "chromedriver";
        } else {
            LOGGER.info("Your OS is not support!!");
        }
        return null;
    }
}
