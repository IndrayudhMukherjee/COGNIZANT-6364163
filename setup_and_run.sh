#!/bin/bash

echo "📁 Creating folders..."
mkdir -p DesignPatternsDemo/SingletonPattern
mkdir -p DesignPatternsDemo/FactoryMethodPattern

echo "📦 Moving Singleton files..."
mv FactoryMethodPatternExample/Logger.cs DesignPatternsDemo/SingletonPattern/
mv FactoryMethodPatternExample/LoggerTest.cs DesignPatternsDemo/SingletonPattern/

echo "📦 Moving Factory Method files..."
mv FactoryMethodPatternExample/IDocument.cs DesignPatternsDemo/FactoryMethodPattern/
mv FactoryMethodPatternExample/DocumentFactory.cs DesignPatternsDemo/FactoryMethodPattern/
mv FactoryMethodPatternExample/PdfDocument.cs DesignPatternsDemo/FactoryMethodPattern/
mv FactoryMethodPatternExample/WordDocument.cs DesignPatternsDemo/FactoryMethodPattern/
mv FactoryMethodPatternExample/ExcelDocument.cs DesignPatternsDemo/FactoryMethodPattern/
mv FactoryMethodPatternExample/PdfFactory.cs DesignPatternsDemo/FactoryMethodPattern/
mv FactoryMethodPatternExample/WordFactory.cs DesignPatternsDemo/FactoryMethodPattern/
mv FactoryMethodPatternExample/ExcelFactory.cs DesignPatternsDemo/FactoryMethodPattern/
mv FactoryMethodPatternExample/FactoryTest.cs DesignPatternsDemo/FactoryMethodPattern/

echo "🧹 Cleaning up..."
rm -rf FactoryMethodPatternExample SingletonPatternExample

echo "🔧 Updating Program.cs entry point..."
cat <<EOL > DesignPatternsDemo/Program.cs
using System;
using SingletonPattern;
using FactoryMethodPattern;

class Program
{
    static void Main(string[] args)
    {
        // LoggerTest.Main(args); // Uncomment for Singleton test
        FactoryTest.Main(args);   // Factory Method test
    }
}
EOL

cd DesignPatternsDemo

if [ ! -f DesignPatternsDemo.csproj ]; then
    echo "📄 Creating new .csproj file..."
    dotnet new console -n DesignPatternsDemo --force
    rm -rf Program.cs obj bin
fi

echo "🚀 Running project..."
dotnet run
