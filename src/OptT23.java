import java.util.InputMismatchException;
import java.util.Scanner;

public class OptT23 {
    public static void main(String[] args)  {
        int[][] a;
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
        System.out.println();
        System.out.println("Матрица из случайных чисел: ");
        System.out.println();
        a=OptT24.matGen(n,m);// вызываем метод генерации матрицы из класса OptT24
            for (int i = 0; i < a.length; i++, System.out.println()) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(a[i][j] + " ");
                }

            }

        sumBetweenFirstTwoPositiveNumb(a);// вызываем метод подсчета суммы между положительными элементами строк матрицы
        }
        else {System.out.println("Размер матрицы и диапазон должны быть целые положительные числа ");}
    }

    public static void sumBetweenFirstTwoPositiveNumb(int[][] arr){

        for (int i = 0; i < arr.length; i++) {
            int sum = 0; // сумма элементов между первыми двумя положительными числами в строке
            int positive_cnt = 0; // счетчик положительных чисел локальный для каждой строки

            //проверяем количество положительных  чисел в строке
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > 0){
                    positive_cnt++;
                }
            }
            //если количество положительных чисел в строке больше или равно двум,
            //то это удовлетворяет нашему условию для нахождения суммы между ними
            if (positive_cnt>=2){
                positive_cnt=0; //обнуляем счетчик положительных чисел

                //снова проходим по строке циклом
                for (int j = 0; j < arr.length-1; j++) {
                    //находим положительное число и увеличиваем значения счетчика
                    if (arr[i][j] > 0){
                        positive_cnt++;
                    }
                    //если значение счетчика равно 1 и последующий элемент строки меньше 0,
                    //то прибавляем следующий элемент строки к сумме, пока значение счетчика не станет равным 2
                    if (positive_cnt == 1 && arr[i][j+1] < 0 ){
                        sum += arr[i][j+1];
                    }
                }
            }
            System.out.println("Cумма элементов между первыми двумя положительными числами в " + i + " строке: ");
            System.out.println(sum);
        }

    }

}
