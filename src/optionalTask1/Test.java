package optionalTask1;                          // mainArray - главный массив чисел
                                                //
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your numbers");
        String numbersInLine = scanner.nextLine();
        String[] arrayOfNumbersInString = numbersInLine.split(" "); // строчный массив чисел
        int[] mainArray = new int[arrayOfNumbersInString.length];
        for (int i = 0; i < arrayOfNumbersInString.length; i++) {
           mainArray[i] = Integer.valueOf(arrayOfNumbersInString[i]);
            System.out.print((i+1) + ": " + mainArray[i] + " | ");
        } // получение чисел в главный массив

        System.out.println();
// получение наименьшего числа массива и его длины:
        int theSmallestNumber = theSmallestNumberOfArray(mainArray);
        System.out.println("The smallest number is " + theSmallestNumber);
        System.out.println("The smallest number length = " + lengthNumber(theSmallestNumber));
// получение наибольшего числа массива и его длины:
        int theBiggestNumber = theBiggestNumberOfArray(mainArray);
        System.out.println("The biggest number is " + theBiggestNumberOfArray(mainArray));
        System.out.println("The biggest number length = " + lengthNumber(theBiggestNumber));
// сортированные массивы от меньшего к большему и обратно:
        int[] sortUpArray = arraySortUp(mainArray);
        System.out.println("Sort up: " + Arrays.toString(sortUpArray));
        int[] arrayReverse = arraySortReverse(mainArray);
        System.out.println("Sort down: " + Arrays.toString(arrayReverse));
// числа, длина которых меньше средней длины по всем числам; их длина:
        System.out.println(smallerPartOfArrayWithLengths(mainArray));
// 4) Найти число, в кот. кол-во различных цифр минимально. Если их несколько, то 1-е из них.
        System.out.println("1-е число ряда чисел, в кот. кол-во различных цифр минимально: "
                + minDifferentNumbersIn(mainArray));
// 5) Найти кол-во чисел, содержащих только четные цифры, а среди оставшихся - кол-во чисел с равным числом
//      четных и нечетных цифр.
        System.out.println(exercise5(mainArray));
// 6) Найти число, цифры в котором идут в строгом порядке возрастания, если их несколько, то первое из них.
        System.out.println(increaseDigits(mainArray));
// 7) Число, состоящее только из различных цифр. Если таких несколько, то первое из них.
        diferentDigits(mainArray);
    }

    static int theSmallestNumberOfArray(int[] x){
            int a = x[0];
            for (int i = 0; i < x.length; i++) {
                if(a > x[i]){
                    a = x[i];
                }
            } return a;
    }
    static int lengthNumber(int x) {
        int lengthNumber = String.valueOf(x).length();
        return lengthNumber;
    }
    static int theBiggestNumberOfArray(int[] x){
        int a = x[0];
        for (int i = 0; i < x.length; i++) {
            if(a < x[i]){
                a = x[i];
            }
        } return a;
    }
    static int[] arraySortUp(int[] x){
        Arrays.sort(x);
        return x;
    }
    static int[] arraySortReverse(int[] x){
        int[] arrayReverse = new int[x.length];
        int a = 0;
        for (int i = x.length-1; i >= 0 ; i--) {
            arrayReverse[a] = x[i];
            a++;
        }
        return arrayReverse;
    }
    static String smallerPartOfArrayWithLengths(int[] x){
        int sum = 0;
        double index = 0d;
        for (int i = 0; i < x.length; i++) {
            int length = String.valueOf(x[i]).length();
            sum = sum + length;
        }
        index = (double) sum / (double) x.length; // получил среднее значение длины чисел - index

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            if(String.valueOf(x[i]).length() < index){
                stringBuilder = stringBuilder.append(x[i] + " ");
            }
        }
        String s = new String(stringBuilder); // преобразование StringBuilder в String
        String[] ss = s.split(" ");
        StringBuilder stringBuilder1 = new StringBuilder("Числа, с длиной меньше средней и их длина: ");
        for (int i = 0; i < ss.length; i++) {
            stringBuilder1 = stringBuilder1.append("number:" + ss[i] + ", length:" + ss[i].length() + " | ");
        }
        String result = new String(stringBuilder1);
        return result;
    }
    static int minDifferentNumbersIn (int[] x){
        int lengthNumber;
        double ratio; //коэффициент
        double[] valuesCoefficients = new double[x.length];
        double c = 0;
        int e = 0;

        for (int i = 0; i < x.length; i++) {
            lengthNumber = String.valueOf(x[i]).length(); //получил длину числа
            String[] stringArray = String.valueOf(x[i]).split(""); //получил массив цифр в строчном виде
            int[] arrayOfSingleNumbers = new int[stringArray.length];
            for (int j = 0; j < stringArray.length; j++) {
                arrayOfSingleNumbers[j] = Integer.valueOf(stringArray[j]);
            } //получил заполненный цифровой массив arrayOfSingleNumbers
            Arrays.sort(arrayOfSingleNumbers); //получил сортированный массив цифр
            int a = 0; //число, кот. будет меняться по ходу цифрового массива, будет принимать новое значение по ходу действий
            int b; //счетчик различных в цифровом массиве цифр
            if (a == arrayOfSingleNumbers[0]){
                b=1;
            }else{b=0;}
            for (int k = 0; k < arrayOfSingleNumbers.length; k++) {
                if (a != arrayOfSingleNumbers[k]){
                    a = arrayOfSingleNumbers[k];
                    b++;
                }else{continue;}
            }
            ratio = (double) lengthNumber / (double)b;
            valuesCoefficients[i] = ratio; //получил массив коэффициентов
        }
        for (int m = 0; m < valuesCoefficients.length; m++) {
            if (valuesCoefficients[m] > c) {
                c = valuesCoefficients[m];
                e = m;
            }else{continue;}
        }
        return x[e];}
    static String exercise5(int[] x){
        int[]returnArr = new int[2];
        int counter1 = 0; //счетчик чисел с четными цифрами
        int counter2 = 0; //счетчик чисел с равным количеством четн и нечетн цифр
        for (int i = 0; i < x.length; i++) {
            String[] strDigitsArray = String.valueOf(x[i]).split("");//создал строчный массив цифр
            int[] intDigitsArray = new int[strDigitsArray.length];
            int even = 0;
            int odd = 0;
            for (int j = 0; j < strDigitsArray.length; j++) {
                intDigitsArray[j] = Integer.valueOf(strDigitsArray[j]); // тут я получил цифровой массив [i] числа

                if (intDigitsArray[j] == 0 || intDigitsArray[j] == 2 ||intDigitsArray[j] == 4 ||
                        intDigitsArray[j] == 6 ||intDigitsArray[j] == 8){
                    even++;
                }else{odd++;}
            }
            if(even == intDigitsArray.length){
                counter1++;
            }
            if(even == odd){
                counter2++;
            }

        }return "Кол-во чисел, состоящих только из четных цифр: " + counter1+ "\n" +
                "Количество чисел из равного кол-ва четных и нечетных: " + counter2;
    }
    static String increaseDigits(int[] x) {
        int result = -1;
        for (int i = 0; i < x.length; i++) {
            int marker = 0; //маркер суммы чисел в цифровом массиве
            String[] str = String.valueOf(x[i]).split(""); // строчный массив цифр
            int[] digitsArray = new int[str.length]; //числовой массив цифр - пустой
            int a = -1;
            for (int j = 0; j < digitsArray.length; j++) {
                digitsArray[j] = Integer.valueOf(str[j]);

                if(a < digitsArray[j]){
                    a = digitsArray[j];
                    marker++;
                }else{break;}
            }
            if(marker == digitsArray.length && digitsArray.length != 1){
                result = x[i];
                break;
            }else{continue;}
        }
        if(result == -1){return "В представленном массиве числа, с увеличивающимися по порядку цифрами, нет.";}
        else{return "Первое число массива, где цифры идут по возрастающей: " + result;}
    }
    static String diferentDigits(int[] x) {
        int result = -1;
        for (int i = 0; i < x.length; i++) {
            String[] str = String.valueOf(x[i]).split("");
            int[] digitsArray = new int[str.length];
            for (int j = 0; j < str.length; j++) {
                digitsArray[j] = Integer.valueOf(str[j]);
            }
            Arrays.sort(digitsArray);
            int a = -1;
            int marker = 0;
            for (int j = 0; j < digitsArray.length; j++) {
                if(a < digitsArray[j]){
                    a = digitsArray[j];
                    marker++;
                }else{break;}
            }
            if(marker == digitsArray.length && digitsArray.length != 1){
                result = x[i];
                break;
            }else{continue;}
        }
        if(result != -1){return "Первое число в массиве, " +
                "где все цифры различны: " + result;}
        else{return "Числа, состоящего только из различных цифр нет";}
    }
}


