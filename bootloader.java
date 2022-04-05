import java.io.File;

public class bootLoader {

    static String baseFolder = "C:\\SeleniumDocs";
    static String screenShotFolder = "C:\\SeleniumDocs\\ScreenShot";
    public static void load() {
        createDirectories(baseFolder);
        createDirectories(screenShotFolder);
        return;
    }

    public static void createDirectories(String path) {
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdir();
        }
        return;
    }

}
