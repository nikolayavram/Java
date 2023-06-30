package HW_4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// Даны два Deque, представляющие два целых числа. 
// Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка.
// Одно или два числа могут быть отрицательными.

// Даны два Deque, цифры в обратном порядке.
// [3,2,1] - пример Deque
// [5,4,3]- пример второго Deque
// 1) 123 * 345 = 42 435
// Ответ всегда - связный список, в обычном порядке
// [4,2,4,3,5] - пример ответа

public class HW4 {
    public static void main(String[] args) {
        Deque<String> num1 = new ArrayDeque<>();
        num1.add("3");
        num1.add("2");
        num1.add("1");
        System.out.println("num1 = " + num1);

        Deque<String> num2 = new ArrayDeque<>();
        num2.add("5");
        num2.add("4");
        num2.add("3");
        System.out.println("num2 = " + num2);

        LinkedList<String> res1 = new LinkedList<>();
        fillLinkedList(res1, getInt(num1) * getInt(num2));
        System.out.println("res1 = " + res1);

        LinkedList<String> res2 = new LinkedList<>();
        fillLinkedList(res2, getInt(num1) + getInt(num2));
        System.out.println("res2 = " + res2);
    }

    public static int getInt(Deque<String> num) {
        Deque<String> temp = new ArrayDeque<>();
        for (String str : num) {
            temp.add(str);
        }

        String res = "";
        while (!temp.isEmpty()) {
            res += temp.pollLast();
        }
        return Integer.parseInt(res);
    }

    public static void fillLinkedList(LinkedList<String> ll, int number) {
        int num = number;
        if (num < 0) {
            num *= -1;
        }

        String temp = "";
        while (num != 0) {
            temp += num % 10;
            ll.addFirst(temp);
            num /= 10;
            temp = "";
        }

        if (number < 0) {
            ll.addFirst("-");
        }
    }
}
