import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriteToCsv {

    private double classP;
    private double sex;
    private List<Double> listAge;
    private List<Double> listFamily;
    private List<Double> listCost;
    private double embarked;


    public WriteToCsv(double classP, double sex, List<Double> listAge, List<Double> listFamily, List<Double> listCost, double embarked) {
        this.classP = classP;
        this.sex = sex;
        this.listAge = listAge;
        this.listFamily = listFamily;
        this.listCost = listCost;
        this.embarked = embarked;
        addToList();
        statisticsCsv();
    }
    public List<Double> addToList(){
        List<Double> newList = new ArrayList<>();
        newList.add(classP);
        newList.add(sex);
        newList.addAll(listAge);
        newList.addAll(listFamily);
        newList.addAll(listCost);
        newList.add(embarked);
        return newList;
    }
    public void statisticsCsv() {
        try {
            File output = new File("src/main/resources/statistics.csv");
            FileWriter fileWriterS = new FileWriter(output);
            PrintWriter printWriter = new PrintWriter(fileWriterS);
            printWriter.println(" classP,sex,Age 0-10,Age 11-20,Age 21-30,Age 31-40,Age 41-50,Age 51+,withFamily,withOutFamily, ticket less 10,ticket 11-30, ticket 30+,embarked ");
            for (int i = 1; i < addToList().size(); i++) {
                printWriter.print(addToList().get(i-1) + ",");
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
