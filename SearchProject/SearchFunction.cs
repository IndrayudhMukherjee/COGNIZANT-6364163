using System;
using System.Collections.Generic;

class Product
{
    public int ProductId { get; set; }
    public string ProductName { get; set; }
    public string Category { get; set; }

    public Product(int id, string name, string category)
    {
        ProductId = id;
        ProductName = name;
        Category = category;
    }

    public override string ToString()
    {
        return $"ID: {ProductId}, Name: {ProductName}, Category: {Category}";
    }
}

class SearchFunction
{
    // Linear Search
    public static Product LinearSearch(List<Product> products, string name)
    {
        foreach (var product in products)
        {
            if (product.ProductName.Equals(name, StringComparison.OrdinalIgnoreCase))
                return product;
        }
        return null;
    }

    // Binary Search - assumes sorted by ProductName
    public static Product BinarySearch(List<Product> products, string name)
    {
        int left = 0;
        int right = products.Count - 1;

        while (left <= right)
        {
            int mid = (left + right) / 2;
            int cmp = string.Compare(products[mid].ProductName, name, StringComparison.OrdinalIgnoreCase);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    static void Main(string[] args)
    {
        var products = new List<Product>
        {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Phone", "Electronics")
        };

        Console.WriteLine("🔎 Linear Search:");
        var result1 = LinearSearch(products, "Phone");
        Console.WriteLine(result1 != null ? result1.ToString() : "Product not found.");

        Console.WriteLine("\n🔎 Binary Search (sorted by name):");
        products.Sort((a, b) => string.Compare(a.ProductName, b.ProductName, StringComparison.OrdinalIgnoreCase));
        var result2 = BinarySearch(products, "Phone");
        Console.WriteLine(result2 != null ? result2.ToString() : "Product not found.");
    }
}
