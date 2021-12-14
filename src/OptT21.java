import java.util.InputMismatchException;
import java.util.Scanner;

public class OptT21 {
    public static void main(String[] args) {
        int n;
        int m;
        int k;
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
        System.out.println("Enter номер столбца k для сортировки строк матрицы: ");

        try {
            k = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат номера столбца! Описание: " + e);
            return;
        }
        int[][] a = new int[n][n];
        if ((n > 0) & (m > 0) & (k >= 0)&(k<n)) {
            System.out.println();
            System.out.println("Матрица из случайных чисел: ");
            System.out.println();
            a=OptT24.matGen(n,m);// вызываем метод генерации матрицы из класса OptT24
            for (int i = 0; i < a.length; i++, System.out.println()) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(a[i][j] + " ");
                }
            }
            System.out.println();
            System.out.println("Матрица по возрастанию элементов столбца " + k);
            System.out.println();
            sortLines(a,k);//вызываем метод вывода на консоль строк матрицы в порядке возрастания элементов заданного столбца

        } else {
            System.out.println("Размер матрицы и диапазон должны быть целые положительные числа, а номер столбца неотрицательным числом меньшим размера матрицы");
        }


    }
        //Метод выводит на консоль строки матрицы в порядке возрастания элементов заданного столбца
        static void sortLines(int[][] arr, int k1) {

            int [] temp=new int[arr.length];
            boolean sorted = false;
            while (!sorted) {
                sorted = true;

                for (int i = 0; i < arr[i].length - 1; i++) {
                    if (arr[i][k1] > arr[i + 1][k1]) {
                        for (int j = 0; j < arr[i].length; j++) {
                            temp[j] = arr[i][j];
                            arr[i][j] = arr[i + 1][j];
                            arr[i + 1][j] = temp[j];
                            sorted = false;
                        }
                    }
                }
            }
            for (int i = 0; i < arr.length; i++, System.out.println()) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }


        }
}
