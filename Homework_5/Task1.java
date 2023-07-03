import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

public class Task1 {
    public static void main(String[] args) {
        Map<String,ArrayList> contacts = new HashMap<>() {
        {
            put("Козлов", new ArrayList<Integer>() {
                    {
                        add(856397);
                        add(898247);
                    }
                });
            put("Петров", new ArrayList<Integer>() {
                    {
                        add(896512);
                        add(898536);
                        add(874523);
                        add(875896);
                    }
                });
            put("Боширов", new ArrayList<Integer>() {
                    {
                        add(895246);
                    }
                });
        }    
    };
    Scanner scan = new Scanner(System.in,"cp866");
    Boolean getOut = false;
    String command;
    while(!getOut){
        System.out.println("Введите номер команды(1-распечатать имеющиеся контакты, 2-добавить контакт, 3- выйти): ");
        command = scan.nextLine();
        switch (command) {
            case "1":
                sortedPrint(contacts);
                break;
            case "2":
                addContact(contacts);
                break;
            case "3":
                getOut = true;
                System.out.println();
                System.out.println("Досвидания");
                System.out.println();
                break;
            default:
                break;
        }

    }
        
    }
    static void addContact(Map<String, ArrayList> map){
        Scanner sc = new Scanner(System.in,"cp866");
        String nameContact;
        String phoneContact;
        System.out.println("Введите фамилию абонента: ");
        nameContact = sc.nextLine();
        if (!map.containsKey(nameContact)){
            System.out.println("Введите номера телефонов через запятую: ");
            phoneContact = sc.nextLine();
            String[] arr = phoneContact.split(",");
            ArrayList<Integer> arrInt = new ArrayList<>();
            for (String item: arr) {
                arrInt.add(Integer.parseInt(item.trim())) ;
            }
            map.put(nameContact, arrInt);
            System.out.println();
        }
        else{
            System.out.println("Ошибка. Такая фамилия уже есть");
        }
        
    }


    static void sortedPrint(Map<String, ArrayList> map) {
     Set<String> keySet = map.keySet();
    int maxCount = 0;
    int minCount = 1_000_000;
        
    for (var item : map.entrySet()) {
        if (maxCount < item.getValue().size())
            maxCount = item.getValue().size();
        if (minCount > item.getValue().size())
            minCount = item.getValue().size();
            
    }
     
    Stack<String> st = new Stack<>();
    int num = minCount;
    while (num <= maxCount) {
        for (var item : map.entrySet()) {
            if (item.getValue().size() == num) {
                st.push(item.getKey());
            }  
        }
         num += 1;
    }

    String name;
    for (int i = 0; i < keySet.size(); i++) {
        name = st.pop();
        for (var item : map.entrySet()) {
            if (name == item.getKey()) {
                System.out.printf("%8s: ", item.getKey());
                System.out.println(item.getValue());
            }
        }
    }
    System.out.println();
    }
}
