package BackEnd;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class WriterGeom {
    private String fileName;
    private ArrayList<GeomObject> geomObjects;

    public WriterGeom(String fileName, ArrayList<GeomObject> g) {
        this.fileName = fileName;
        this.geomObjects = g;
    }

    public String getFileName() {
        return fileName;
    }

    public ArrayList<GeomObject> getGeomObjects() {
        return geomObjects;
    }

    // abstract method
    public void write() throws FileNotFoundException {
    };
}
