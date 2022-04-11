package view.submenu;

import view.MenuType;

import java.util.Scanner;

public abstract class BaseSubMenu<T> {

    public abstract void onGetAll();

    public abstract void onGetByName();

    public abstract void onCreate();

    public abstract void onUpdate();

    public abstract void onDelete();

    abstract T getNewObj();

    protected String getTargetName(MenuType menuType) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a %s name: ", menuType.name());
        return scanner.nextLine();
    }
}
