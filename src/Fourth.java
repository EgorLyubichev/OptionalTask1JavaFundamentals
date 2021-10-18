//4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение)
// и вывести результат на консоль.

public class Fourth {
    public static void main(String[] args) {
        int array = 0;

        for (int i = 0; i < args.length; i++) {
            array = (int)(array + Integer.valueOf(args[i]));
        }
        System.out.println(array);
    }
}
