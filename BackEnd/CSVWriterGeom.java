package BackEnd;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVWriterGeom extends WriterGeom {

    public CSVWriterGeom(String fileName, ArrayList<GeomObject> g) {
        super(fileName, g);
    }

    // abstract method
    public void write() throws FileNotFoundException {
        ArrayList<GeomObject> arr = super.getGeomObjects();
        try (
                // create a file
                java.io.PrintWriter outputFile = new PrintWriter(super.getFileName() + ".csv");) {
            for (int i = 0; i < arr.size(); i++) {
                outputFile.println(Arrays.toString(arr.get(i).getElements())
                        .replace("[", "") // remove the right bracket
                        .replace("]", "") // remove the left bracket
                        + ", " + arr.get(i).getColorName());
            }
        }
    }
}
