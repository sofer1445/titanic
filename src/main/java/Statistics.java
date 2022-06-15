import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Statistics extends JPanel {
    private List<Passenger> list;



    public Statistics(List<Passenger> list ) {
        this.list = list;

    }

    public double survivorPercentageInClass(int pClass) {
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
        return percentage;
    }

    public double statisticsInSex(String sex) {
        double passenger;
        double survivorPass;
        double percentage;
        List<Passenger> survivor;
        if (!sex.isEmpty() && !sex.equals("All")) {
            System.out.println("statisticsInSex: start");
            this.list = list.stream().filter(passenger1 -> passenger1.getSex().equals(sex)).collect(Collectors.toList());
            passenger = list.size();
            survivor = this.list.stream().filter(Passenger::isSurvived).collect(Collectors.toList());
            survivorPass = survivor.size();
            percentage = (survivorPass / passenger) * Final.PERCENTAGE;
            System.out.println("Percentage of survivors by sex " + sex + " is:" + percentage + " %");
        }else {
            survivorPass = (int) this.list.stream().filter(Passenger::isSurvived).count();
            percentage = (survivorPass / list.size()) * Final.PERCENTAGE;
            System.out.println("Percentage of survivors by sex " + sex + " is:" + percentage + " %");
        }
        return percentage;
    }

    public List<Double> ageFilterStatistics() {
        System.out.println("ageFilter: start");
        List<Double> doubles = new ArrayList<>();
        double zeroToTen;
        double elevenToTwenty;
        double twentyOneToThirty;
        double thirtyOneToForty;
        double fortyOneToFifty;
        double fiftyOnePlus;
        double percentage;
        double pass;
        if (!list.isEmpty()) {
            System.out.println("0-10");
            pass = (int) list.stream().filter(passenger -> (passenger.getAge() <= 10 && passenger.getAge() >= 0)).count();
            zeroToTen = (int) list.stream().filter(passenger -> (passenger.getAge() <= 10 && passenger.getAge() >= 0) && (passenger.isSurvived())).count();
            percentage = (zeroToTen / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("Percentage of survivors among the ages zeroToTen is: " + percentage + " %");

            System.out.println("11-20");
            pass = (int) list.stream().filter(passenger -> (passenger.getAge() <= 20 && passenger.getAge() >= 11)).count();
            elevenToTwenty = (int) list.stream().filter(passenger -> (passenger.getAge() <= 20 && passenger.getAge() >= 11) && (passenger.isSurvived())).count();
            percentage = (elevenToTwenty / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("Percentage of survivors among the ages elevenToTwenty is: " + percentage + " %");

            System.out.println("21-30");
            pass = (int) list.stream().filter(passenger -> (passenger.getAge() <= 30 && passenger.getAge() >= 21)).count();
            twentyOneToThirty = (int) list.stream().filter(passenger -> (passenger.getAge() <= 30 && passenger.getAge() >= 21) && (passenger.isSurvived())).count();
            percentage = (twentyOneToThirty / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("Percentage of survivors among the ages twentyOneToThirty is: " + percentage + " %");

            System.out.println("31-40");
            pass = (int) list.stream().filter(passenger -> (passenger.getAge() <= 40 && passenger.getAge() >= 31)).count();
            thirtyOneToForty = (int) list.stream().filter(passenger -> (passenger.getAge() <= 40 && passenger.getAge() >= 31) && (passenger.isSurvived())).count();
            percentage = (thirtyOneToForty / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("Percentage of survivors among the ages thirtyOneToForty is: " + percentage + " %");

            System.out.println("41-50");
            pass = (int) list.stream().filter(passenger -> (passenger.getAge() <= 50 && passenger.getAge() >= 41)).count();
            fortyOneToFifty = (int) list.stream().filter(passenger -> (passenger.getAge() <= 50 && passenger.getAge() >= 41) && (passenger.isSurvived())).count();
            percentage = (fortyOneToFifty / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("Percentage of survivors among the ages fortyOneToFifty is: " + percentage + " %");

            System.out.println("51+");
            pass = (int) list.stream().filter(passenger -> (passenger.getAge() >= 51)).count();
            fiftyOnePlus = (int) list.stream().filter(passenger -> (passenger.getAge() >= 51) && (passenger.isSurvived())).count();
            percentage = (fiftyOnePlus / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("Percentage of survivors the ages fiftyOnePlus is: " + percentage + " %");

        } else {
            System.out.println("There are no passengers meeting the typed parameters");
        }

        return doubles;

    }

    public List<Double> isFamilyInDeck() {
        System.out.println("isFamilyInDeck: start");
        List<Double> doubles = new ArrayList<>();
        double withoutFamily;
        double withFamily;
        double percentage;
        double pass;

        if (!list.isEmpty()) {
            pass = (double) list.stream().filter(passenger -> !Objects.equals(passenger.getSibSp(), "0")).count() + (double) list.stream().filter(passenger -> !Objects.equals(passenger.getParch(), "0")).count();
            withFamily = (double) list.stream().filter(passenger -> !Objects.equals(passenger.getSibSp(), "0") && passenger.isSurvived()).count() + (double) list.stream().filter(passenger -> !Objects.equals(passenger.getParch(), "0") && passenger.isSurvived()).count();
            percentage = (withFamily / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("The percentage of survivors with a family are: " + percentage + " %");

            pass = (double) list.stream().filter(passenger -> Objects.equals(passenger.getSibSp(), "0")).count() + (double) list.stream().filter(passenger -> Objects.equals(passenger.getParch(), "0")).count();
            withoutFamily = (double) list.stream().filter(passenger -> Objects.equals(passenger.getSibSp(), "0") && passenger.isSurvived()).count() + (double) list.stream().filter(passenger -> Objects.equals(passenger.getParch(), "0") && passenger.isSurvived()).count();
            percentage = (withoutFamily / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("The percentage of survivors without a family is: " + percentage + " %");
        } else {
            System.out.println("There are no passengers meeting the typed parameters");
        }
        return doubles;
    }

    public List<Double> surviveByTicketPrice() {
        System.out.println("surviveByTicketPrice: start");
        List<Double> doubles = new ArrayList<>();
        double tenMinus;
        double elevenToThirty;
        double thirtyPlus;
        double percentage ;
        double pass;
        if (!list.isEmpty()) {
            System.out.println("tenMinus");
            pass = (int) list.stream().filter(passenger -> passenger.getFare() <= 10).count();
            tenMinus = (int) list.stream().filter(passenger -> passenger.getFare() <= 10 && passenger.isSurvived()).count();
            percentage = (tenMinus / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("Percentage of survivors according to ticket price tenMinus " + percentage + " %");

            System.out.println("elevenToThirty");
            pass = (int) list.stream().filter(passenger -> passenger.getFare() <= 30 && passenger.getFare() >= 11).count();
            elevenToThirty = (int) list.stream().filter(passenger -> (passenger.getFare() < 30 && passenger.getFare() >= 11) && passenger.isSurvived()).count();
            percentage = (elevenToThirty / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("Percentage of survivors according to ticket price elevenToThirty " + percentage + " %");

            System.out.println("thirtyPlus");
            pass = (int) list.stream().filter(passenger -> passenger.getFare() >= 30).count();
            thirtyPlus = (int) list.stream().filter(passenger -> (passenger.getFare() >= 30) && passenger.isSurvived()).count();
            percentage = (thirtyPlus / pass) * Final.PERCENTAGE;
            doubles.add(percentage);
            System.out.println("Percentage of survivors according to ticket price thirtyPlus " + percentage + " %");
        }
        return doubles;


    }

    public double embarkedStatistics(String cabinType) {
        System.out.println("embarkedStatistics: start");
        double live;
        double percentage;
        double pass;
        if (!Objects.equals(cabinType, "All")) {
            this.list = this.list.stream().filter(passenger1 -> Objects.equals(passenger1.getEmbarked(), cabinType)).collect(Collectors.toList());

        }
        pass = list.size();
        live = (int) this.list.stream().filter(Passenger::isSurvived).count();
        percentage = (live / pass) * Final.PERCENTAGE;

        System.out.println("The percentage of survivors in Cabin " + cabinType + ": is " + percentage + " %");
        return percentage;
    }
    //C – צ'רבורג, Q – קווינסטאון, S – סאות'המפטון

}


