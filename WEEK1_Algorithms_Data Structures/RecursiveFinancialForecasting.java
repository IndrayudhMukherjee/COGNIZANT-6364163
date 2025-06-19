class Forecast {
    // Time Complexity: O(n), due to memoization
    public static double forecast(double[] growth, int year, Double[] memo) {
        if (year == 0) return 1.0;
        if (memo[year] != null) return memo[year];
        memo[year] = forecast(growth, year - 1, memo) * growth[year - 1];
        return memo[year];
    }

    public static void main(String[] args) {
        double[] growthRates = {10,25,56,120};
        Double[] memo = new Double[growthRates.length + 1];
        System.out.println("Value after 4 years: " + forecast(growthRates, 4, memo));
    }
}
