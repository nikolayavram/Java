// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
// 1 3 4 2
// 1 3 2 4
// 1 2 3 4

public class Task_2 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 8, 4, 7};
        try {
            FileWriter writer = new FileWriter("HW_2/task_2.txt");
            writer.write(Arrays.toString(nums));
            writer.write("\n");
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 0; j < nums.length-i-1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int t = nums[j + 1];
                        nums[j + 1] = nums[j];
                        nums[j] = t;
                    }
                }
                writer.write(Arrays.toString(nums));
                writer.write("\n");
            }
            System.out.println("Получилось");
            writer.close();
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }

}
