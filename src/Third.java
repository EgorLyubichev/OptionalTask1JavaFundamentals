//3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

public class Third {
    public static void main(String[] args) {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] = (int) Math.round(Math.random()*100));
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");

        }
    }
}
