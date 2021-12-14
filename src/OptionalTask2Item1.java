import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionalTask2Item1 {
    public static void main(String[] args) {
        int matrixDimension;
        int matrixElementsScope;
        int columnIndex;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы : ");
        try {
            matrixDimension = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат размера матрицы! Описание: " + e);
            return;
        }

        System.out.println("Введите диапазон для целочисленных элементов матрицы : ");

        try {
            matrixElementsScope = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат диапазона чисел! Описание: " + e);
            return;
        }
        System.out.println("Введите номер столбца  для сортировки строк матрицы: ");

        try {
            columnIndex = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат номера столбца! Описание: " + e);
            return;
        }
        int[][] array;
        if ((matrixDimension > 0) & (matrixElementsScope > 0) & (columnIndex >= 0)&(columnIndex<matrixDimension)) {
            System.out.println();
            System.out.println("Матрица из случайных чисел: ");
            System.out.println();
            array= OptionalTask2Item4.generateRandomMatrix(matrixDimension,matrixElementsScope);// вызываем метод генерации матрицы из класса OptionalTask2Item4
            for (int i = 0; i < array.length; i++, System.out.println()) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
            }
            System.out.println();
            System.out.println("Матрица по возрастанию элементов столбца " + columnIndex);
            System.out.println();
            printMatrixRowsSortedByIncrementingGivenColumnElements(array,columnIndex);//вызываем метод вывода на консоль строк матрицы в порядке возрастания элементов заданного столбца

        } else {
            System.out.println("Размер матрицы и диапазон должны быть целые положительные числа, а номер столбца неотрицательным числом меньшим размера матрицы");
        }


    }
        //Метод выводит на консоль строки матрицы в порядке возрастания элементов заданного столбца
        static void printMatrixRowsSortedByIncrementingGivenColumnElements(int[][] array, int columnIndex) {

            int [] swapArray=new int[array.length];
            boolean sorted = false;
            while (!sorted) {
                sorted = true;

                for (int i = 0; i < array[i].length - 1; i++) {
                    if (array[i][columnIndex] > array[i + 1][columnIndex]) {
                        for (int j = 0; j < array[i].length; j++) {
                            swapArray[j] = array[i][j];
                            array[i][j] = array[i + 1][j];
                            array[i + 1][j] = swapArray[j];
                            sorted = false;
                        }
                    }
                }
            }
            for (int i = 0; i < array.length; i++, System.out.println()) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
            }


        }
}
