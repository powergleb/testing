package org.Testing.Classes;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadingProperties {
    protected static FileInputStream fileInputStream;

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
    protected static Properties PROPERTIES;

    static {
        try {
            fileInputStream = new FileInputStream("D:\\учеба\\Java\\src\\test\\java\\resourses\\configuration.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


}