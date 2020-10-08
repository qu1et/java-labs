package univer.labs.Main;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // список данных
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            File file = new File("D://data.txt");
            // создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            // создаем BufferedReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // сначала считаем первую строку
            String line = reader.readLine();
            while (line != null) {
                // разобъем строку на массив и занесем в список
                list.add(line.split((" ")));
                //System.out.println(line);
                // считываем следующую строку
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] data = list.toArray(new String[0][0]);

        // убираем черточку из названий стран
        for (String[] elem : data) {
            elem[0] = elem[0].replaceAll("-", " ");
        }

        // сортируем массив
        sortArray(data, 0, data.length - 1);

        // вывод информации
        printInfo(data);
    }

    // сортируем массив по колличеству иммигрантов в процентах от населения
    public static void sortArray(String[][] arr, int lb, int rb) {
        // берем нижнюю и верхнюю границы массива
        int l = lb, r = rb;
        // берем опорный элемент
        double piv = Double.parseDouble(arr[(r + l) / 2][3]);

        do {
            // передвигаем левую границу, пока элемент меньше чем piv
            while (Double.parseDouble(arr[l][3]) > piv) {
                l++;
            }

            // двигаем правую границу, пока элемент больше чем pic
            while (Double.parseDouble(arr[r][3]) < piv) {
                r--;
            }

            // проверяем нужно ли поменять местами элементы, на которые указывают маркеры
            if (l <= r) {
                // левый маркер будет меньше правого только, если мы должны выполнить перестановку
                if (l < r) {
                    String[] tmp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = tmp;
                }

                // Сдвигаем маркеры, чтобы получить новые границы
                l++;
                r--;
            }
        } while (l <= r);

        // Рекурсивно выполняем для частей
        if (l < rb) {
            sortArray(arr, l, rb);
        }

        if (lb < r) {
            sortArray(arr, lb, r);
        }
    }

    // вывод информации, получаенной на основе имеющихся данных
    public static void printInfo(String[][] arr) {
        // вывод таблицы данных
        for (String[] elem: arr) {
            System.out.printf("%-22s%-11s%-11s%-11s%n", elem[0], elem[1], elem[2], elem[3]);
        }

        System.out.print("\n\n");

        // вывод информации о количестве иммигрантов во всех странах
        System.out.printf("Total immigrants: %d\n", countImmigrants(arr));

        // вывод информации по проценту иммигрантов, приходящемуся на указанные страны
        System.out.printf("Total percentage of world's immigrants: %.1f\n", countImmPer(arr));

        // вывод страны с наименьшим процентом иммигрантов
        System.out.printf("Country with least immigrations: %s\n", arr[arr.length - 1][0]);

        // вывод страны с наибольшим процентом иммигрантов
        System.out.printf("Country with greatest immigrations: %s\n", arr[0][0]);

        // вывод общей численности населения всех указанных стран
        System.out.printf("Total estimated population of all countries: %d\n", countTotalPopulation(arr));
    }

    // подсчитываем общее количество иммигрантов во всех странах
    public static int countImmigrants(String[][] arr) {
        int count = 0;

        for (String[] elem: arr) {
            count += Integer.parseInt(elem[1]);
        }

        return count;
    }

    // подсчет общего процента иммигрантов в мире, приходящийся на эти страны
    public static double countImmPer(String[][] arr) {
        double count = 0;

        for (String[] elem: arr) {
            count += Double.parseDouble(elem[2]);
        }

        return count;
    }

    // подсчет общего населения всех указанных стран
    public static int countTotalPopulation(String[][] arr) {
        int total = 0;

        for (String[] elem: arr) {
            total += (int)(Double.parseDouble(elem[1]) * 100) / Double.parseDouble(elem[3]);
        }

        return total;
    }
}