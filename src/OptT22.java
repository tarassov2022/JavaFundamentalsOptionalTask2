import java.util.InputMismatchException;
import java.util.Scanner;

public class OptT22 {
    public static void main(String[] args) {
        int n;
        int m;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter размер матрицы n: ");
        try {
            n = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат размера матрицы! Описание: " + e);
            return;
        }

        System.out.println("Enter диапазон для целочисленных элементов матрицы M: ");

        try {
            m = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат диапазона чисел! Описание: " + e);
            return;
        }
        int[][] a = new int[n][n];
        if ((n > 0) & (m > 0)) {
            System.out.println();
            System.out.println("Матрица из случайных чисел: ");
            System.out.println();
            a = OptT24.matGen(n, m);// вызываем метод генерации матрицы из класса OptT24
            for (int i = 0; i < a.length; i++, System.out.println()) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(a[i][j] + " ");
                }

            }

            incElem(a);// вызываем метод вывода наибольшего числа возрастающих элементов матрицы идущих подряд
        }
        else {System.out.println("Размер матрицы и диапазон должны быть целые положительные числа ");}

    }
    // Метод выводит на консоль количество идущих подряд возрастающих элементов и эти элементы по строкам
    static void incElem(int[][] arr) {
        int n = arr.length;
        int[][] lens = new int[n][n];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] > arr[i][j - 1])
                    lens[i][j] = lens[i][j - 1] + 1;
                else lens[i][j] = 0;
                max = Math.max(lens[i][j], max);
            }

        }
        System.out.println();
        System.out.println("Количество возрастающих элементов, идущих подряд "+(max + 1));
        System.out.println("Эти элементы по строкам матрицы: ");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (lens[i][j] == max) {
                    System.out.print("Строка " + i + ": ");
                    for (int l = j - lens[i][j]; l <= j; l++)
                        System.out.print(arr[i][l] + " ");
                        System.out.println();
                }
            }
        }
    }

}












