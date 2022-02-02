import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;



public class OptionalTask2Item4 {
    //Метод создает матрицу из целых случайных чисел от -randomScope до randomScope размера matrixDimension
    static int[][] generateRandomMatrix(int matrixDimension, int randomScope) {
        Random random = new Random();
        int[][] randomArray = new int[matrixDimension][matrixDimension];
        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray[i].length; j++) {
                    randomArray[i][j] = random.nextInt(2*randomScope+1)  - randomScope;
            }
        }
        return randomArray;

    }

    //Метод обрезает строки и столбцы матрицы array, содержащие элемент maxElement, создавая матрицу arrayProcessed
    static int[][] removeRowsAndColumnsWithMaxElement(int maxElement, int[][] array) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();
        // Поиск колонок и столбцов, которые надо удалить
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (maxElement == array[i][j]) {
                    if (!rows.contains(i))
                        rows.add(i);
                    if (!columns.contains(j))
                        columns.add(j);
                }
            }
        }
        int[][] arrayProcessed = new int[array.length - rows.size()][array.length - columns.size()];
        int arrayProcessedICount = 0;
        int arrayProcessedJCount =0;
        // Заполняем новый массив без столбцов и строк с мах числом
        for (int i = 0; i < array.length; i++) {
            if (!rows.contains(i)) {
                arrayProcessedJCount = 0;
                for (int j = 0; j < array[i].length; j++) {
                    if (!columns.contains(j)) {
                        arrayProcessed[arrayProcessedICount][arrayProcessedJCount]
                                = array[i][j];
                        arrayProcessedJCount++;
                    }
                }
                arrayProcessedICount++;
            }
        }
        return arrayProcessed;
    }

    // Метод находит  максимальный элемент матрицы array
    static int findMatrixMaxElement(int[][] array) {
       int matrixMaxElement = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (matrixMaxElement < array[i][j]) matrixMaxElement = array[i][j];
            }
        }
        return matrixMaxElement;

    }

    public static void main(String[] args) {

        int[][] array;
        int matrixMaxElement;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int matrixDimension;
        try {
            matrixDimension = scanner.nextInt();}
        catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат размера матрицы! Описание: " + e);
            return;}

        System.out.println("Введите диапазон для целочисленных элементов матрицы : ");
        int matrixElementsScope;
        try {
            matrixElementsScope = scanner.nextInt();}
        catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат диапазона чисел! Описание: " + e);
            return;}
        if ((matrixDimension>0)&(matrixElementsScope>0)) {
           array= generateRandomMatrix(matrixDimension,matrixElementsScope);
           matrixMaxElement= findMatrixMaxElement(array);
           System.out.println();
           System.out.println("Матрица из случайных чисел: ");
           System.out.println();

           for (int i = 0; i < array.length; i++, System.out.println()) {
               for (int j = 0; j < array[i].length; j++) {
                   System.out.print(array[i][j] + " ");
               }

           }
           System.out.println();
           System.out.println("Максимальный элемент матрицы: ");
           System.out.println(matrixMaxElement);
           System.out.println("Матрица с удаленными строками и столбцами, содержавшими его: ");

           int[][] arrayWithRemovedRowsAndColumns= removeRowsAndColumnsWithMaxElement(matrixMaxElement,array);
           for (int i = 0; i < arrayWithRemovedRowsAndColumns.length; i++, System.out.println()) {
               for (int j = 0; j < arrayWithRemovedRowsAndColumns[i].length; j++) {
                   System.out.print(arrayWithRemovedRowsAndColumns[i][j] + " ");
               }
           }




    }
        else {System.out.println("Размер матрицы и диапазон должны быть целые положительные числа ");}
    }
}
