package MAS.Object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public abstract class ObjectPlus implements Serializable {
    private static Map<Class, ArrayList<ObjectPlus>> allExtents = new Hashtable<>();

    public ObjectPlus() {
        ArrayList extent = null;
        Class theClass = this.getClass();

        if (allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);
        } else {
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }

        extent.add(this);
    }

    /**
     * Writes all extents to the given stream (a class method).
     *
     * @throws IOException
     */
    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }

    /**
     * Reads all extents from the given stream (a utility class method).
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (Hashtable) stream.readObject();
    }

    /**
     * Shows an extent of the given class (a utility class method)
     *
     * @throws Exception
     */
    public static void showExtent(Class theClass) throws Exception {
        ArrayList extent = null;

        if (allExtents.containsKey(theClass)) {
            // Extent of this class already exist
            extent = allExtents.get(theClass);
        } else {
            throw new Exception("Unknown class " + theClass);
        }

        System.out.println("Extent of the class: " + theClass.getSimpleName());

        for (Object obj : extent) {
            System.out.println(obj);
        }
    }

    public static List<ObjectPlus> getExtent(Class theClass) {
        if (allExtents.containsKey(theClass)) {
            return allExtents.get(theClass);
        } else {
            return new ArrayList<>();
        }
    }
}