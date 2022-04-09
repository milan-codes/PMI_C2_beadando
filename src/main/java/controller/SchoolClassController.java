package controller;

import model.SchoolClass;
import utils.XMLReader;

import java.util.ArrayList;
import java.util.UUID;

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
    public SchoolClass getById(UUID id) {
        return null;
    }

    @Override
    public SchoolClass create() {
        return null;
    }

    @Override
    public SchoolClass update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
