package org.sjwimmer.tacharting.chart.utils;

import java.io.*;

public class InitUtils {

    /**
     * Export a resource embedded into a Jar file to the local file path.
     *
     * @param ressource the path of the ressource
     * @param exportPath the path of the export location
     * @return false if the export could not be finished
     * @throws Exception Exception
     */
    public static boolean exportResource(String ressource, String exportPath) throws Exception {
        OutputStream outputStream = null;

        try(InputStream stream = InitUtils.class.getClassLoader().getResourceAsStream(ressource)){
            if(stream == null) {
                throw new FileNotFoundException("Cannot get resource \"" + ressource + "\" from Jar file.");
            }
            int readBytes;
            byte[] buffer = new byte[4096];
            outputStream = new FileOutputStream(exportPath);
            while ((readBytes = stream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, readBytes);
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
