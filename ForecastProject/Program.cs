using System;
using System.Collections.Generic;

class FinancialForecasting
{
    // Naive recursive version (e.g., Fibonacci-style)
    public static int PredictRevenueNaive(int n)
    {
        if (n <= 1) return 1;
        return PredictRevenueNaive(n - 1) + PredictRevenueNaive(n - 2);
    }

    // Memoized version
    public static int PredictRevenueMemoized(int n, Dictionary<int, int> memo = null)
    {
        memo ??= new Dictionary<int, int>();
        if (n <= 1) return 1;

        if (memo.ContainsKey(n))
            return memo[n];

        int value = PredictRevenueMemoized(n - 1, memo) + PredictRevenueMemoized(n - 2, memo);
        memo[n] = value;
        return value;
    }

    // Bottom-up DP version
    public static int PredictRevenueDP(int n)
    {
        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    static void Main(string[] args)
    {
        int year = 10;

        Console.WriteLine("📈 Naive Recursion:");
        Console.WriteLine($"Year {year} prediction: {PredictRevenueNaive(year)}");

        Console.WriteLine("\n📈 Memoized Recursion:");
        Console.WriteLine($"Year {year} prediction: {PredictRevenueMemoized(year)}");

        Console.WriteLine("\n📈 Dynamic Programming:");
        Console.WriteLine($"Year {year} prediction: {PredictRevenueDP(year)}");
    }
}
