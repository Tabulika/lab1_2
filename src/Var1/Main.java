package Var1;

import java.util.Scanner;

class Mountains {
    String name, location;
    int height;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество гор: ");
        int amount = sc.nextInt();
        Mountains mountain[] = new Mountains[amount];
        System.out.println("Введите информацию о горах: ");
        for (int i = 0; i < mountain.length; i++) {
            sc.nextLine();
            mountain[i] = new Mountains();
            System.out.println("Введите название " + (i + 1) + "-й горы:");
            mountain[i].name = sc.nextLine();
            System.out.println("Введите её местоположение: ");
            mountain[i].location = sc.nextLine();
            System.out.println("Введите её высоту: ");
            mountain[i].height = sc.nextInt();
        }

        System.out.println("\nХарактеристики гор: ");
        for (Mountains mntn : mountain) {
            System.out.println("" + mntn.name + "\t" + mntn.location + "\t" + mntn.height + " м");
        }

        int nommax = 0;
        double max = mountain[nommax].height;
        for (int i = 0; i < mountain.length; i++) {
            if (mountain[i].height > max) {
                max = mountain[i].height;
                nommax = i;
            }
        }
        System.out.println("\nСамая высокая гора: ");
        System.out.println("" + mountain[nommax].name + "\t" + mountain[nommax].location + "\t" + mountain[nommax].height + " м");

        System.out.println("\nВершины выше 1000 м: ");
        for (int i = 0; i < mountain.length; i++) {
            if (mountain[i].height > 1000) {
                System.out.println("" + mountain[i].name + "\t" + mountain[i].location + "\t" + mountain[i].height + " м");
            }
        }

        for (int i = 0; i < mountain.length - 1; i++) {
            for (int j = 0; j < mountain.length - 1 - i; i++) {
                if (mountain[j].height > mountain[j+1].height) {
                    Mountains temp = mountain[j];
                    mountain[j] = mountain[j+1];
                    mountain[j+1] = temp;
                }
            }
        }
        System.out.println("\nОтсортированный список по высоте: ");
        for (Mountains mntn : mountain) {
            System.out.println("" + mntn.name + "\t" + mntn.location + "\t" + mntn.height + " м");
        }

        sc.nextLine();
        System.out.println("\nВведите название искомой горы: ");
        String name = sc.nextLine();
        int nom = -1;
        for (int i = 0; i < mountain.length; i++) {
            if (name.equalsIgnoreCase(mountain[i].name)) {
                nom = i;
            }
        }
        if (nom != -1) {
            System.out.println("Найдено: " + mountain[nom].name + "\t" + mountain[nom].location + "\t" + mountain[nom].height + " м");
        }
        else {
            System.out.println("Не найдено.");
        }
    }
}
