import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;



public class OptT24 {
    //Метод создает матрицу из целых случайных чисел от -m до m размера n
    static int[][] matGen(int n, int m) {
        Random random = new Random();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = random.nextInt(2*m+1)  - m;
            }
        }
        return arr;

    }

    //Метод обрезает строки и столбцы матрицы arr, содержащие элемент max, создавая матрицу newArr
    static int[][] matFix(int max, int[][] arr) {
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> column = new ArrayList<Integer>();
        // Поиск колонок и столбцов, которые надо удалить
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max == arr[i][j]) {
                    if (rows.indexOf(i) == -1)
                        rows.add(i);
                    if (column.indexOf(j) == -1)
                        column.add(j);
                }
            }
        }
        int[][] newArr = new int[arr.length - rows.size()][arr.length - column.size()];
        int newArrI = 0;
        int newArrJ = 0;
        // Заполняем новый массив без столбцов и строк с мах числом
        for (int i = 0; i < arr.length; i++) {
            if (rows.indexOf(i) == -1) {
                newArrJ = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    if (column.indexOf(j) == -1) {
                        newArr[newArrI][newArrJ]
                                = arr[i][j];
                        newArrJ++;
                    }
                }
                newArrI++;
            }
        }
        return newArr;
    }

    // Метод находит max максимальный элемент матрицы arr
    static int maxElem(int[][] arr) {
       int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) max = arr[i][j];
            }
        }
        return max;

    }
// Главный метод предусматривает неверное введение параметров размера и диапазона матрицы
    public static void main(String[] args) {

        int[][] a;
        int max;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter размер матрицы n: ");
        int n;
        try {
            n = input.nextInt();}
        catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат размера матрицы! Описание: " + e);
            return;}

        System.out.println("Enter диапазон для целочисленных элементов матрицы M: ");
        int m;
        try {
            m = input.nextInt();}
        catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат диапазона чисел! Описание: " + e);
            return;}
        if ((n>0)&(m>0)) {
           a=matGen(n,m);
           max=maxElem(a);
           System.out.println();
           System.out.println("Матрица из случайных чисел: ");
           System.out.println();

           for (int i = 0; i < a.length; i++, System.out.println()) {
               for (int j = 0; j < a[i].length; j++) {
                   System.out.print(a[i][j] + " ");
               }

           }
           System.out.println();
           System.out.println("Максимальный элемент матрицы: ");
           System.out.println(max);
           System.out.println("Матрица с удаленными строками и столбцами, содержавшими его: ");

           int[][] a1=matFix(max,a);
           for (int i = 0; i < a1.length; i++, System.out.println()) {
               for (int j = 0; j < a1[i].length; j++) {
                   System.out.print(a1[i][j] + " ");
               }
           }




    }
        else {System.out.println("Размер матрицы и диапазон должны быть целые положительные числа ");}
    }
}
