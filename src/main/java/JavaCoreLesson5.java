import java.util.Arrays;

public class JavaCoreLesson5 {
    public static void main(String[] args) {
        ReadCSV readFile = new ReadCSV("src/inputFile.csv");

        AppData ourFile = new AppData(readFile.getHeader(),readFile.getData());
        System.out.println("ourFile.printHeader()\n");
        ourFile.printHeader();
        System.out.println("ourFile.printData()\n");
        ourFile.printData();
        System.out.println("readFile.printFile()\n");
        readFile.printFile();


        WriteCSV outFile = new WriteCSV();
        outFile.writeString("id;first;second;third");
        ReadCSV newFile =  new ReadCSV("src/outputFile.csv");
        newFile.printFile();

        outFile.save(ourFile);
        newFile.printFile();

        outFile.writeString("Hello world!");
        newFile.printFile();

    }
}
