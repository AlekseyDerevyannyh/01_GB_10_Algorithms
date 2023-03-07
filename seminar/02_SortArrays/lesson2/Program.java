import java.util.Random;

public class Program {

    private static final Random random = new Random();
    public static void main(String[] args) {

        int[] arr = ArrayUtils.prepareArray();
        ArrayUtils.printArray(arr);
        SortUtils.directSort(arr);
        ArrayUtils.printArray(arr);

        arr = ArrayUtils.prepareArray();
        ArrayUtils.printArray(arr);
        SortUtils.quickSort(arr);
        ArrayUtils.printArray(arr);



    }

    static class ArrayUtils {

        /**
         * Подготовить массив случайных чисел
         * @return
         */
        static int[] prepareArray() {
            int[] arr = new int[random.nextInt(15) + 5];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(100) - 50;
            }
            return arr;
        }

        /**
         * Подготовить массив случайных чисел
         * @param length кол-во элементов
         * @return
         */
        static int[] prepareArray(int length) {
            int[] arr = new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(101) - 50;
            }
            return arr;
        }

        /**
         * Распечатать массив на экран
         * @param arr
         */
        static void printArray(int[] arr) {
            for (int item : arr) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }

    static class SortUtils {

        /**
         * Сортировка выбором
         * @param arr
         */
        static void directSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int min_index = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[min_index])
                        min_index = j;
                }
                if (min_index != i) {
                    int tmp = arr[i];
                    arr[i] = arr[min_index];
                    arr[min_index] = tmp;
                }
            }
        }

        static void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        private static void quickSort(int[] arr, int start, int end) {
            int left = start;
            int right = end;
            int pivot = arr[(start + end) / 2];

            do {
                while (arr[left] < pivot) {
                    left++;
                }
                while (arr[right] > pivot) {
                    right--;
                }

                if (left <= right) {
                    if (left < right) {
                        int tmp = arr[left];
                        arr[left] = arr[right];
                        arr[right] = tmp;
                    }
                    left++;
                    right--;
                }
            } while (left <= right);
            if (left < end) {
                quickSort(arr, left, end);
            }
            if (start < right) {
                quickSort(arr, start, right);
            }
        }
    }
}
