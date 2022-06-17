package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class XMLWriterGeom extends WriterGeom {
    public XMLWriterGeom(String fileName, ArrayList<GeomObject> g) {
        super(fileName, g);

    }

    // abstract method
    public void write() throws FileNotFoundException {
        ArrayList<GeomObject> arr = super.getGeomObjects();
        try (
                // create a file
                java.io.PrintWriter outputFile = new PrintWriter(new File(super.getFileName()) + ".xml");) {
            for (int i = 1; i <= arr.size(); i++) {
                GeomObject g = arr.get(i - 1);
                outputFile.print("<" + g.getName() + " id=" + i + "> \n");
                for (int j = 0; j <= g.getElements().length; j++) {
                    outputFile.print("  <" + g.getElementsName()[j] + ">");
                    if (j < g.getElements().length) {
                        outputFile.print(g.getElements()[j]);
                    } else {
                        outputFile.print(g.getColorName());
                    }
                    outputFile.print("</" + g.getElementsName()[j] + ">\n");
                }
                outputFile.print("</" + g.getName() + "> \n");
            }
        }
    }
}
