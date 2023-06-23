/**
 * 1) Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть
 * WHERE этого запроса,
 * используя StringBuilder. Данные для фильтрации приведены ниже в виде
 * json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Пример данной строки {"name":"Ivanov", "country":"Russia", "city":"Moscow",
 * "age":"null"}
 * Вывод: select * from students WHERE name=Ivanov AND country=Russia AND
 * city=Moscow
 */

public class Task_1 {

    public static void main(String[] args) {
        getString("HW_2/task_1.txt");
    }

    public static void getString(String track) {
        String str = "";
        File fl = new File(track);
        try {
            FileReader file = new FileReader(fl);
            char[] arr = new char[(int) fl.length()];
            file.read(arr);
            for (char c : arr) {
                System.out.print(c);
                str += c;
            }
            file.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    
        str = str.replace("{", "").replace("}", "").replace("\"", "");

        StringBuilder result = new StringBuilder("select * from students WHERE ");

        String[] list = str.split(",");
        for (int i = 0; i < list.length; i++) {
            String[] arr = list[i].split(":");
            if (arr[1].equals("null") == false) {
                if (i != 0) {
                    result.append(" AND");
                    result.append(arr[0]);
                    result.append("=");
                    result.append(arr[1]);
                } else {
                    result.append(arr[0]);
                    result.append("=");
                    result.append(arr[1]);
                }
            }
        }
        System.out.println();
        System.out.println(result);

    }
}
