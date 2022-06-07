//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.io.*;
//import java.util.Scanner;
//import com.gembox.spreadsheet.*;
//
//
//
//
//
//public class FirstClass {
//
//    private Passenger[] passengers;
//    private File csvFile;
//
//    public FirstClass(Passenger[] passengers,File csvFile) {
////        this.passengers = passengers;
//        this.csvFile = csvFile;
//        SpreadsheetInfo.setLicense("FREE-LIMITED-KEY");
//    }
////    public void load(ActionEvent event) throws IOException {
////        FileChooser fileChooser = new FileChooser();
//////        fileChooser.setTitle("Open file");
//////        File file = fileChooser.showOpenDialog(table.getScene().getWindow());
////        ExcelFile workbook = ExcelFile.load(file.getAbsolutePath());
////        ExcelWorksheet worksheet = workbook.getWorksheet(0);
////        String[][] sourceData = new String[100][26];
////        for (int row = 0; row < sourceData.length; row++) {
////            for (int column = 0; column < sourceData[row].length; column++) {
////                ExcelCell cell = worksheet.getCell(row, column);
////                if (cell.getValueType() != CellValueType.NULL)
////                    sourceData[row][column] = cell.getValue().toString();
////            }
////        }
////        fillTable(sourceData);
////    }
//
//    public static String readFromCsvFile(String path) {
//        String csvFromFile = null;
//
//        try {
//            File file = new File(path);
//            FileReader reader = new FileReader(path);
//            Scanner scanner = new Scanner(reader);
//            if (scanner.hasNextLine()) {
//                csvFromFile = scanner.nextLine();
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        return csvFromFile;
//
////    public void readFromFileCsv()  {
////        BufferedReader in = new BufferedReader(new FileReader(fileCsv));
////        String list = null;
////        while (list = in.readLine() != null){
////
////        }
////    }
//    }
//}
