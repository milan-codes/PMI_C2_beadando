package controller;

import java.util.ArrayList;
import java.util.UUID;

/**
 * An abstract class that all controllers must extend.
 *
 * @param <T> The type of the controller.
 */
public abstract class BaseController<T> {
    public abstract ArrayList<T> getAll();

    public abstract T getByName(String name);

    public abstract T create(T newObj);

    public abstract T update(T oldObj, T newObj);

    public abstract void delete(String name);
}
