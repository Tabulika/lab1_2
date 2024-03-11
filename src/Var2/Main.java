package Var2;

import java.util.Scanner;

class Mountains {
    String name, location;
    int height;
}

public class Main {
    //МЕТОДЫ ДЛЯ ВСЕХ ПОДЗАДАЧ для работы с объектами класса Mountains
    public static Mountains[] setMountainArr(int k) {
        Scanner sc = new Scanner(System.in);
        Mountains mountain[] = new Mountains[k];

        System.out.println("Введите информацию о горах: ");
        for (int i = 0; i < mountain.length; i++) {
            mountain[i] = new Mountains();

            System.out.println("Введите название " + (i + 1) + "-й горы:");
            mountain[i].name = sc.nextLine();

            System.out.println("Введите её местоположение: ");
            mountain[i].location = sc.nextLine();

            System.out.println("Введите её высоту: ");
            mountain[i].height = sc.nextInt();

            sc.nextLine();
        }

        return mountain;
    }

    //ВЫВОД МАССИВА
    public static void showArray(Mountains mntn[]) {
        for (int i = 0; i < mntn.length; i++) {
            System.out.println("" + mntn[i].name + "\t" + mntn[i].location + "\t" + mntn[i].height + " м");
        }
    }

    //ИНФОРМАЦИЯ ОБ ОДНОЙ ГОРЕ
    public static void showMountain(Mountains mntn) {
        System.out.println("" + mntn.name + "\t" + mntn.location + "\t" + mntn.height + " м");
    }

    //САМАЯ ВЫСОКАЯ ГОРА
    public static int NomMax(Mountains mt[]) {
        int nommax = 0;
        int max = mt[nommax].height;

        for (int i = 0; i < mt.length; i++) {
            if (mt[i].height > max) {
                max = mt[i].height;
                nommax = i;
            }
        }

        return nommax;
    }

    //ГОРЫ ВЫШЕ 1000 М
    public static Mountains[] aboveThousand(Mountains mntn[]) {
        for (int i = 0; i < mntn.length; i++) {
            if (mntn[i].height > 1000) {
                System.out.println("" + mntn[i].name + "\t" + mntn[i].location + "\t" + mntn[i].height + " м");
            }
        }
        return mntn;
    }

    //СОРТИРОВКА ПО ВЫСОТЕ
    public static void sortHeight(Mountains mntn[]) {
        for (int i = 0; i < mntn.length - 1; i++) {
            for (int j = 0; i < mntn.length - 1 - i; i++) {
                if (mntn[j].height > mntn[j+1].height) {
                    Mountains temp = mntn[j];
                    mntn[j] = mntn[j+1];
                    mntn[j+1] = temp;
                }
            }
        }
    }

    //ПОИСК ПО НАЗВАНИЮ
    public static Mountains findForName(Mountains mntn[], String name) {
        int n = -1;
        for (int i = 0; i < mntn.length; i++) {
            if (name.equalsIgnoreCase(mntn[i].name)) {
                n = i;
            }
        }
        if (n != -1) {
            return mntn[n];
        }
        else {
            return null;
        }
    }

    //ГЛАВНЫЙ КЛАСС С МЕТОДАМИ
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество гор: ");
        int amount = sc.nextInt();

        Mountains mountain[] = setMountainArr(amount); //ввод информации о странах

        System.out.println("\nХарактеристики гор: ");
        showArray(mountain); //вывод полученной информации

        int nommax = NomMax(mountain);
        System.out.println("\nСамая высокая гора: ");
        showMountain(mountain[nommax]); //самая высокая гора

        System.out.println("\nВершины выше 1000 м: ");
        Mountains above[] = aboveThousand(mountain);
        showArray(above);
        //выше 1000 м

        sortHeight(mountain);
        System.out.println("\nОтсортированный список по высоте: ");
        showArray(mountain); //сортировка вершин по высоте

        System.out.println("\nПОИСК ВЕРШИНЫ \nВведите название вершины: ");
        sc.nextLine();
        String sname = sc.nextLine();
        Mountains sfind = findForName(mountain, sname);
        if (sfind != null) {
            showMountain(sfind);
        }
        else {
            System.out.println("Не найдено");
        }
    }
}
