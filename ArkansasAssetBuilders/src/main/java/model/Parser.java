package model;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// https://mkyong.com/java/how-to-export-data-to-csv-file-java/

public class Parser {
    public static void main(String[] args) throws IOException {

        List<String[]> csvData = createCsvDataSimple();

        // default all fields are enclosed in double quotes
        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(new FileWriter("c:\\test\\test.csv"))) {
            writer.writeAll(csvData);
        }
    }

    private static List<String[]> createCsvDataSimple() {
        String[] header = {"id", "name", "address", "phone"};
        String[] record1 = {"1", "first name", "address 1", "11111"};
        String[] record2 = {"2", "second name", "address 2", "22222"};

        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);

        return list;
    }
}
//    public static void main(String[] args) throws IOException {
//
//        List<String[]> csvData = createCsvDataSimple();
//
//        // default all fields are enclosed in double quotes
//        // default separator is a comma
//        try (CSVWriter writer = new CSVWriter(new FileWriter("c:\\test\\test.csv"))) {
//            writer.writeAll(csvData);
//        }
//        System.out.println("test");
//
//        // List<MyBean> beans comes from somewhere earlier in your code.
//        Writer writer = new FileWriter("yourfile.csv");
//        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
//        beanToCsv.write(beans);
//        writer.close();
//    }
//
//    private static List<String[]> createCsvDataSimple() {
//        String[] header = {"id", "name", "address", "phone"};
//        String[] record1 = {"1", "first name", "address 1", "11111"};
//        String[] record2 = {"2", "second name", "address 2", "22222"};
//
//        List<String[]> list = new ArrayList<>();
//        list.add(header);
//        list.add(record1);
//        list.add(record2);
//
//        return list;
//    }
