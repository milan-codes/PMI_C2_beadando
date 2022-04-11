package controller;

import model.SchoolClass;
import utils.XMLReader;
import utils.XMLWriter;

import java.util.ArrayList;

/**
 * {@link controller.BaseController} subclass.
 * Contains control logic regarding {@link model.SchoolClass} objects.
 */
public class SchoolClassController extends BaseController<SchoolClass> {
    private ArrayList<SchoolClass> list;

    public SchoolClassController() {
        updateList();
    }

    private void updateList() {
        XMLReader<SchoolClass> reader = new XMLReader<>("src/main/resources/classes.xml", new SchoolClass.SchoolClassFactory());
        reader.read();
        list = reader.getList();
    }

    private void saveList() {
        XMLWriter<SchoolClass> writer = new XMLWriter<>("src/main/resources/classes.xml", new SchoolClass.SchoolClassFactory(), list);
        writer.write();
    }

    @Override
    public ArrayList<SchoolClass> getAll() {
        updateList();
        return list;
    }

    @Override
    public SchoolClass getByName(String name) {
        updateList();
        return list.stream().filter(schoolClass -> schoolClass.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public SchoolClass create(SchoolClass newObj) {
        list.add(newObj);
        saveList();
        return newObj;
    }

    @Override
    public SchoolClass update(SchoolClass objToRemove, SchoolClass newObj) {
        updateList();
        list.removeIf(schoolClass -> schoolClass.getName().equals(objToRemove.getName()));
        list.add(newObj);
        saveList();

        return newObj;
    }

    @Override
    public void delete(String name) {
        updateList();
        list.removeIf(schoolClass -> schoolClass.getName().equals(name));
        XMLWriter<SchoolClass> writer = new XMLWriter<>("src/main/resources/classes.xml", new SchoolClass.SchoolClassFactory(), list);
        writer.write();
    }
}
