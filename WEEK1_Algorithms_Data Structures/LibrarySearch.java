class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

class BookSearch {
    // Linear Search - Time Complexity: O(n)
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equals(title)) return b;
        }
        return null;
    }

    // Binary Search - Time Complexity: O(log n)
    public static Book binarySearch(Book[] books, String title) {
        Arrays.sort(books, (a, b) -> a.title.compareTo(b.title));
        int l = 0, r = books.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int cmp = books[mid].title.compareTo(title);
            if (cmp == 0) return books[mid];
            if (cmp < 0) l = mid + 1;
            else r = mid - 1;
        }
        return null;
    }
}
