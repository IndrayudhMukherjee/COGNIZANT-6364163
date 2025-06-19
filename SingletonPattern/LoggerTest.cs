using System;
using SingletonPatternExample;

namespace SingletonPatternExample
{
    public class LoggerTest
    {
        public static void Run()
        {
            Logger logger1 = Logger.Instance;
            Logger logger2 = Logger.Instance;

            logger1.Log("Logger1 is logging.");
            logger2.Log("Logger2 is logging.");

            Console.WriteLine(Object.ReferenceEquals(logger1, logger2)); // Should print True
        }
    }
}
