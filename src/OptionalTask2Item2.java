import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionalTask2Item2 {
    public static void main(String[] args) {
        int matrixDimension;
        int matrixElementsScope;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        try {
            matrixDimension = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат размера матрицы! Описание: " + e);
            return;
        }

        System.out.println("Введите диапазон для целочисленных элементов матрицы: ");

        try {
            matrixElementsScope = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат диапазона чисел! Описание: " + e);
            return;
        }
          int[][] array;
        if ((matrixDimension > 0) & (matrixElementsScope > 0)) {
            System.out.println();
            System.out.println("Матрица из случайных чисел: ");
            System.out.println();
            array = OptionalTask2Item4.generateRandomMatrix(matrixDimension, matrixElementsScope);// вызываем метод генерации матрицы из класса OptionalTask2Item4
            for (int i = 0; i < array.length; i++, System.out.println()) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }

            }

            printMaxNumberOfIncrementingMatrixElements(array);// вызываем метод вывода наибольшего числа возрастающих элементов матрицы идущих подряд
        }
        else {System.out.println("Размер матрицы и диапазон должны быть целые положительные числа ");}

    }
    // Метод выводит на консоль количество идущих подряд возрастающих элементов и эти элементы по строкам
    static void printMaxNumberOfIncrementingMatrixElements(int[][] array) {
        int matrixDimension = array.length;
        int[][] incrementingElementsPointerArray = new int[matrixDimension][matrixDimension];
        int maxIncrementingMatrixElementsCountNumber = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] > array[i][j - 1])
                    incrementingElementsPointerArray[i][j] = incrementingElementsPointerArray[i][j - 1] + 1;
                else incrementingElementsPointerArray[i][j] = 0;
                maxIncrementingMatrixElementsCountNumber = Math.max(incrementingElementsPointerArray[i][j], maxIncrementingMatrixElementsCountNumber);
            }

        }

        System.out.println();
        System.out.println("Наибольшее количество возрастающих элементов, идущих подряд "+(maxIncrementingMatrixElementsCountNumber + 1));
        System.out.println("Эти элементы по строкам матрицы: ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (incrementingElementsPointerArray[i][j] == maxIncrementingMatrixElementsCountNumber) {
                    System.out.print("Строка " + i + ": ");
                    for (int l = j - incrementingElementsPointerArray[i][j]; l <= j; l++)
                        System.out.print(array[i][l] + " ");
                        System.out.println();
                }
            }
        }

    }

}












