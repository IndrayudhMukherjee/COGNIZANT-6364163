import java.util.Arrays;

class SearchProduct {
    int productId;
    String name;
    String category;

    public SearchProduct(int productId, String name, String category) {
        this.productId = productId;
        this.name = name;
        this.category = category;
    }
}

class SearchFunctions {
    // Linear Search - Time Complexity: O(n)
    public static int linearSearch(SearchProduct[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].name.equals(name)) return i;
        }
        return -1;
    }

    // Binary Search - Time Complexity: O(log n), requires sorted array
    public static int binarySearch(SearchProduct[] arr, String name) {
        Arrays.sort(arr, (a, b) -> a.name.compareTo(b.name));
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = arr[mid].name.compareTo(name);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
