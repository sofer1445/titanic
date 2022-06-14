import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Statistics extends JPanel {
    private List<Passenger> list;


    public Statistics(List<Passenger> list) {
        this.list = list;


    }

    public void survivorPercentageInClass(int pClass) {
        System.out.println("survivorPercentageInClass: start");
        List<Passenger> survivor;
        double live;
        double percentage;
        double pass;
        if (pClass != 0) {
            this.list = this.list.stream().filter(passenger1 -> passenger1.getPclass() == pClass).collect(Collectors.toList());
            pass = list.size();
            survivor = this.list.stream().filter(Passenger::isSurvived).collect(Collectors.toList());
            live = survivor.size();
        } else {
            pass = list.size();
            survivor = this.list.stream().filter(Passenger::isSurvived).collect(Collectors.toList());
            live = survivor.size();
        }
        percentage = (live / pass) * 100;
        System.out.println("The percentage of survivors in Class " + pClass + ": is " + percentage + " %");
    }

    public void statisticsInSex(String sex) {
        if (!sex.isEmpty() && !sex.equals("All")) {
            System.out.println("statisticsInSex: start");
            double passenger;
            double survivorPass;
            double percentage;
            List<Passenger> survivor;
            this.list = list.stream().filter(passenger1 -> passenger1.getSex().equals(sex)).collect(Collectors.toList());
            passenger = list.size();
            survivor = this.list.stream().filter(Passenger::isSurvived).collect(Collectors.toList());
            survivorPass = survivor.size();
            percentage = (survivorPass / passenger) * 100;
            System.out.println("Percentage of survivors by sex " + sex + " is:" + percentage + " %");
        }
    }

    public void ageFilterStatistics() {
        System.out.println("ageFilter: start");
        double zeroToTen;
        double elevenToTwenty;
        double twentyOneToThirty;
        double thirtyOneToForty;
        double fortyOneToFifty;
        double fiftyOnePlus;
        double percentage;
        double pass = list.size();
        if (!list.isEmpty()) {
            System.out.println("0-10");
            zeroToTen = (int) list.stream().filter(passenger -> (passenger.getAge() <= 10 && passenger.getAge() >= 0)).count();
            percentage = (zeroToTen/pass)*100;
            System.out.println("Percentage of survivors among the ages zeroToTen is: " + percentage + " %");

            System.out.println("11-20");
            elevenToTwenty = (int) list.stream().filter(passenger -> (passenger.getAge() <= 20 && passenger.getAge() >= 11)).count();
            percentage = (elevenToTwenty/pass)*100;
            System.out.println("Percentage of survivors among the ages elevenToTwenty is: " + percentage + " %");

            System.out.println("21-30");
            twentyOneToThirty = (int) list.stream().filter(passenger -> (passenger.getAge() <= 30 && passenger.getAge() >= 21)).count();
            percentage = (twentyOneToThirty/pass)*100;
            System.out.println("Percentage of survivors among the ages twentyOneToThirty is: " + percentage + " %");

            System.out.println("31-40");
            thirtyOneToForty = (int) list.stream().filter(passenger -> (passenger.getAge() <= 40 && passenger.getAge() >= 31)).count();
            percentage = (thirtyOneToForty/pass)*100;
            System.out.println("Percentage of survivors among the ages thirtyOneToForty is: " + percentage + " %");

            System.out.println("41-50");
            fortyOneToFifty = (int) list.stream().filter(passenger -> (passenger.getAge() <= 50 && passenger.getAge() >= 41)).count();
            percentage = (fortyOneToFifty/pass)*100;
            System.out.println("Percentage of survivors among the ages fortyOneToFifty is: " + percentage + " %");

            System.out.println("51+");
            fiftyOnePlus = (int) list.stream().filter(passenger -> (passenger.getAge() >= 51)).count();
            percentage = (fiftyOnePlus/pass)*100;
            System.out.println("Percentage of survivors the ages fiftyOnePlus is: " + percentage + " %");

        }else {
            System.out.println("There are no passengers meeting the typed parameters");
        }

        //0-10,11-20,21-30,31-40,41-50,51+

    }

    public void isFamilyInDeck() {
        System.out.println("isFamilyInDeck: start");
        double withoutFamily;
        double withFamily;
        double percentage;
        double pass = list.size()*2;

        if (!list.isEmpty()) {
            withFamily = (double) list.stream().filter(passenger -> !Objects.equals(passenger.getSibSp(), "0")).count() + (double) list.stream().filter(passenger -> !Objects.equals(passenger.getParch(), "0")).count();
            percentage = (withFamily / pass) * 100;
            System.out.println("The percentage of survivors with a family are: " + percentage);

            withoutFamily = (double) list.stream().filter(passenger -> Objects.equals(passenger.getSibSp(), "0")).count() + (double) list.stream().filter(passenger -> Objects.equals(passenger.getParch(), "0")).count();
            percentage = (withoutFamily / pass) * 100;
            System.out.println("The percentage of survivors without a family is: " + percentage);
        } else {
            System.out.println("There are no passengers meeting the typed parameters");
        }
    }

}
