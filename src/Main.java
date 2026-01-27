import service.MenuService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuService(new Scanner(System.in));
        menuService.iniciar();
    }
}
