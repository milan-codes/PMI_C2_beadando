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

    public abstract T getById(UUID id);

    public abstract T create();

    public abstract T update(UUID id);

    public abstract void delete(UUID id);
}
