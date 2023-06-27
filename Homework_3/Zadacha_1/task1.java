package HW_3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

// Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее ариф. значение

public class HW {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = func.rand(7);
        System.out.println(list);
        
        System.out.println("Минимальный элимент: " + func.min(list));
        System.out.println("Максимальный элимент: " + func.max(list));
        System.out.println("Cреднее ариф. значение: " + func.sred(list));
        System.out.println("Без четных чисел: " + func.delete(list));
    }


}
