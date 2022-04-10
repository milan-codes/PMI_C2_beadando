package controller;

import model.SchoolClass;
import utils.XMLReader;

import java.util.ArrayList;

/**
 * {@link controller.BaseController} subclass.
 * Contains control logic regarding {@link model.SchoolClass} objects.
 */
public class SchoolClassController extends BaseController<SchoolClass> {

    @Override
    public ArrayList<SchoolClass> getAll() {
        XMLReader<SchoolClass> reader = new XMLReader<>("src/main/resources/classes.xml", new SchoolClass.SchoolClassFactory());
        reader.read();
        return reader.getList();
    }

    @Override
    public SchoolClass getByName(String name) {
        XMLReader<SchoolClass> reader = new XMLReader<>("src/main/resources/classes.xml", new SchoolClass.SchoolClassFactory());
        reader.read();
        return reader.getList().stream().filter(schoolClass -> schoolClass.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public SchoolClass create(SchoolClass newObj) {
        return null;
    }

    @Override
    public SchoolClass update(String name) {
        return null;
    }

    @Override
    public void delete(String name) {

    }
}
