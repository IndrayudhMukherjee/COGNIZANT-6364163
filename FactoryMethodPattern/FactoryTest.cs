using System;

namespace FactoryMethodPatternExample
{
    public class FactoryTest
    {
       public static void Run()
{
    DocumentFactory factory;
    IDocument doc;

    factory = new PdfFactory();
    doc = factory.CreateDocument();
    doc.Open();

    factory = new ExcelFactory();
    doc = factory.CreateDocument();
    doc.Open();
}
    }}