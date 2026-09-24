import java.util.ArrayList;

public class Sorting {

    //returns negative if a belongs before b, positive if after, 0 if equal (COMPARE IS A HELPER METHOD ~ so we dont need to implement this on everysingle method after)
    private static int compare(Student a, Student b, boolean byGpa) {
        if (byGpa) {
            return Double.compare(a.getGpa(), b.getGpa());
        } else {
            return a.getName().compareTo(b.getName());
        }
    }

    //  Bubble Sort 
    public static void bubbleSort(ArrayList<Student> list, boolean byGpa) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (compare(list.get(j), list.get(j + 1), byGpa) > 0) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    //  Quick Sort 
    public static void quickSort(ArrayList<Student> list, int low, int high, boolean byGpa) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, byGpa);
            quickSort(list, low, pivotIndex - 1, byGpa);
            quickSort(list, pivotIndex + 1, high, byGpa);
        }
    }

    private static int partition(ArrayList<Student> list, int low, int high, boolean byGpa) {
        Student pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(list.get(j), pivot, byGpa) < 0) {
                i++;
                Student temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        Student temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }

    //  Merge Sort 
    public static void mergeSort(ArrayList<Student> list, boolean byGpa) {
        if (list.size() <= 1) {
            return;
        }
        int mid = list.size() / 2;
        ArrayList<Student> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, byGpa);
        mergeSort(right, byGpa);
        merge(list, left, right, byGpa);
    }

    private static void merge(ArrayList<Student> list, ArrayList<Student> left, ArrayList<Student> right, boolean byGpa) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (compare(left.get(i), right.get(j), byGpa) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    //  Bucket Sort (by GPA, range 0.0-4.0) 
    public static void bucketSortByGpa(ArrayList<Student> list) {
        int bucketCount = 8; // buckets: 0.0-0.5, 0.5-1.0, ... 3.5-4.0
        ArrayList<ArrayList<Student>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Student s : list) {
            int index = (int) (s.getGpa() / 0.5);
            if (index >= bucketCount) {
                index = bucketCount - 1; // GPA == 4.0 edge case
            }
            buckets.get(index).add(s);
        }

        for (ArrayList<Student> bucket : buckets) {
            bubbleSort(bucket, true);
        }

        list.clear();
        for (ArrayList<Student> bucket : buckets) {
            list.addAll(bucket);
        }
    }

    // p Radix Sort (by GPA, scaled to an integer) 
    public static void radixSortByGpa(ArrayList<Student> list) {
        int maxScaled = 400; // GPA max 4.00 -> scaled 400
        for (int digitPlace = 1; maxScaled / digitPlace > 0; digitPlace *= 10) {
            countingSortByDigit(list, digitPlace);
        }
    }

    private static void countingSortByDigit(ArrayList<Student> list, int digitPlace) {
        int n = list.size();
        Student[] output = new Student[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int scaled = (int) Math.round(list.get(i).getGpa() * 100);
            int digit = (scaled / digitPlace) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int scaled = (int) Math.round(list.get(i).getGpa() * 100);
            int digit = (scaled / digitPlace) % 10;
            output[count[digit] - 1] = list.get(i);
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            list.set(i, output[i]);
        }
    }
}
