package ru.usetech.usetechvtb.util;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;

public class DirUtils {

    public static String getSourceDirectory() {

        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");

        return dir.toString() + File.separator + "source_directory" + File.separator;
    }

    public static String getOutputDirectory() {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");

        return dir.toString() + File.separator + "output_directory" + File.separator;
    }
}
