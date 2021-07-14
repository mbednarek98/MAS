package sample.GUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectsModel<T> extends AbstractListModel<T> {
    ArrayList<T> objects;

    public ObjectsModel(List<T> objs) {
        objects = new ArrayList<T>(objs);
    }

    @Override
    public T getElementAt(int index) {
        return objects.get(index);
    }

    @Override
    public int getSize() {
        return objects.size();
    }

}