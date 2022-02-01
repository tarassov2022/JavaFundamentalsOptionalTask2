import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionalTask2Item3 {
    public static void main(String[] args)  {
        int[][] array;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int matrixDimension;
        try {
            matrixDimension = scanner.nextInt();}
        catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат размера матрицы! Описание: " + e);
            return;}

        System.out.println("Введите диапазон для целочисленных элементов матрицы: ");
        int matrixElementsScope;
        try {
            matrixElementsScope = scanner.nextInt();}
        catch (InputMismatchException e) {
            System.out.println("\n Ошибка неверный формат диапазона чисел! Описание: " + e);
            return;}
        if ((matrixDimension>0)&(matrixElementsScope>0)) {
        System.out.println();
        System.out.println("Матрица из случайных чисел: ");
        System.out.println();
        array= OptionalTask2Item4.generateRandomMatrix(matrixDimension,matrixElementsScope);// вызываем метод генерации матрицы из класса OptionalTask2Item4
            for (int i = 0; i < array.length; i++, System.out.println()) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }

            }

        sumMatrixElementsBetweenFirstTwoPositiveNumbersInRow(array);// вызываем метод подсчета суммы между положительными элементами строк матрицы
        }
        else {System.out.println("Размер матрицы и диапазон должны быть целые положительные числа ");}
    }

    public static void sumMatrixElementsBetweenFirstTwoPositiveNumbersInRow(int[][] array){

        for (int i = 0; i < array.length; i++) {
            int sumMatrixElementsBetweenFirstTwoPositiveNumbersInRow = 0; // сумма элементов между первыми двумя положительными числами в строке
            int positiveNumbersInEachRowCounter = 0; // счетчик положительных чисел локальный для каждой строки

            //проверяем количество положительных  чисел в строке
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > 0){
                    positiveNumbersInEachRowCounter++;
                }
            }
            //если количество положительных чисел в строке больше или равно двум,
            //то это удовлетворяет нашему условию для нахождения суммы между ними
            if (positiveNumbersInEachRowCounter>=2){
                positiveNumbersInEachRowCounter=0; //обнуляем счетчик положительных чисел

                //снова проходим по строке циклом
                for (int j = 0; j < array.length-1; j++) {
                    //находим положительное число и увеличиваем значения счетчика
                    if (array[i][j] > 0){
                        positiveNumbersInEachRowCounter++;
                    }
                    //если значение счетчика равно 1 и последующий элемент строки меньше 0,
                    //то прибавляем следующий элемент строки к сумме, пока значение счетчика не станет равным 2
                    if (positiveNumbersInEachRowCounter == 1 && array[i][j+1] < 0 ){
                        sumMatrixElementsBetweenFirstTwoPositiveNumbersInRow += array[i][j+1];
                    }
                }
            }
            System.out.println("Cумма элементов между первыми двумя положительными числами в " + i + " строке: ");
            System.out.println(sumMatrixElementsBetweenFirstTwoPositiveNumbersInRow);
        }

    }

}
