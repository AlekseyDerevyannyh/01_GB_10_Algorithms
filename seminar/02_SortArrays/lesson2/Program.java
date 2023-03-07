import java.util.Arrays;
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

        arr = ArrayUtils.prepareArray();
        ArrayUtils.printArray(arr);
        SortUtils.heapSort(arr);
        ArrayUtils.printArray(arr);

        int[] testArr = ArrayUtils.prepareArray(100000);
        long startTime = System.currentTimeMillis();
        SortUtils.directSort(testArr.clone());
        long endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения сортировки выбором: %d  мс\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.quickSort(testArr.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения быстрой сортировки %d  мс\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        Arrays.sort(testArr.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения встроенной быстрой сортировки %d  мс\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        SortUtils.heapSort(testArr.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время выполнения сортировки кучей (пирамидальной) %d  мс\n", endTime - startTime);

        int[] testArr2 = new int[]{-5, 100, -1, 3, 4, 5, 9, 22, 9, 101, -6};
        ArrayUtils.printArray(testArr2);
        SortUtils.quickSort(testArr2);
        ArrayUtils.printArray(testArr2);
        int searchElement = 9;
        int res = SearchUtils.binarySearch(testArr2, searchElement);
        System.out.printf("Элемент %d %s\n", searchElement,
                res >= 0 ? String.format("найден в массиве по индексу %d", res) :
                "не найден");

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

        /**
         * Быстрая сортировка
         * @param arr
         */
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
    }

    static class SearchUtils {
        static int binarySearch(int[] array, int value) {
            return binarySearch(array, value,0, array.length - 1);
        }
        static int binarySearch(int[] array, int value, int left, int right) {
            if (right < left) {
                return -1;
            }
            int middle = (left + right) / 2;

            if (array[middle] == value) {
                return middle;
            } else if (array[middle] < value) {
                return binarySearch(array, value, middle + 1, right);
            } else {
                return binarySearch(array, value, left, middle - 1);
            }
        }


    }
}
