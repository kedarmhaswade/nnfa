package org.foobar;

import java.io.*;

import org.apache.commons.io.IOUtils;

public class Plugin
{
    private static final File config;

    static {
        //create the temporary file to pass on to fannj as a file on disk
        try {
            //change the name of the class here, Plugin
            InputStream is = Plugin.class.getClassLoader().getResourceAsStream("org/foobar/fann-model.txt");
            BufferedInputStream bis = new BufferedInputStream(is);
            config = File.createTempFile("fann-model", ".txt");
            OutputStream fos = new BufferedOutputStream(new FileOutputStream(config));
            IOUtils.copy(bis, fos);
            bis.close();
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException("loading failed");
        }
    }
    public Plugin() {
        System.out.println("constructed ...");
        System.out.println("File copied at: " + config.getAbsolutePath());
    }

    public static void main(String[] args) {
        new Plugin();
    }
}

