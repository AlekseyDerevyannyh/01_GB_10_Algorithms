import java.util.Random;

public class Program {

    private static final Random random = new Random();
    public static void main(String[] args) {

        int[] arr = ArrayUtils.prepareArray();
        System.out.println("Исходный массив:");
        ArrayUtils.printArray(arr);
        SortUtils.heapSort(arr);
        System.out.println("Отсортированный массив (пирамидальная сортировка):");
        ArrayUtils.printArray(arr);

    }

    static class ArrayUtils {

        /**
         * Метод генерирования массива случайных чисел
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
         * Метод распечатывания массива на экран
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
         * Метод сортировки кучей (пирамидальной сортировки)
         * @param array
         */
        public static void heapSort(int[] array) {
            for (int i = array.length / 2 - 1; i >= 0; i--)
                heapify(array, array.length, i);

            for (int i = array.length - 1; i >= 0; i --) {
                int tmp = array[0];
                array[0] = array[i];
                array[i] = tmp;
                heapify(array, i, 0);
            }
        }

        /**
         * Вспомогательный метод просеивания кучи для сортировки кучей (пирамидальной сортировки)
         * @param array
         * @param heapSize
         * @param rootIndex
         */
        private static void heapify(int[] array, int heapSize, int rootIndex) {
            int largest = rootIndex;
            int leftChild = 2 * rootIndex + 1;
            int rightChild = 2 * rootIndex + 2;

            if (leftChild < heapSize && array[leftChild] > array[largest])
                largest = leftChild;

            if (rightChild < heapSize && array[rightChild] > array[largest])
                largest = rightChild;

            if (largest != rootIndex) {
                int tmp = array[rootIndex];
                array[rootIndex] = array[largest];
                array[largest] = tmp;

                heapify(array, heapSize, largest);
            }
        }
    }
}
