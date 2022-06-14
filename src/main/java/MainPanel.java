import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    private List<Passenger> passengerList;
    private JComboBox<String> passengerPClass;
    private JComboBox<String> passengerSexBox;
    private JComboBox<String> passengerEmbarkedBox;
    private JTextField passengerIDMaxim;
    private JTextField passengerIDMinim;
    private JTextField passengerAgeMaxim;
    private JTextField passengerAgeMinim;
    private JTextField passengersNames;
    private JTextField passengerSibAndSp;// אחים ובני זוג
    private JTextField passengerPraAndCh; // ילדים והורים
    private JTextField passengerTickets;
    private JTextField passengerFareMaxim; // עלות הכרטיס בפואנד
    private JTextField passengerFareMinim;
    private JTextField passengerCabins; // מספר תא
    private JButton searchButton;
    private JButton statistic;
    private String minId;
    private String maxId;
    private String minFare;
    private String maxFare;
    private String typeClassOfClass;
    private String typeClassOfSex;
    private String typeClassOfEmbarked;
    private String name;
    private String sibSp;
    private String prach;
    private String ticket;
    private String cabins;
    private String minAge;
    private String maxAge;
    private int counter = 0;

    public MainPanel(int x, int y, int width, int height) throws IOException {

        File fileOfCsv = new File(Constants.PATH_TO_DATA_FILE);
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
        createPassengerList(fileOfCsv);
        allUserFilter();

    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void allUserFilter() throws IOException {
        JLabel passengerClassLabel = new JLabel("Passenger Class: ");
        passengerClassLabel.setBounds(5, 0, 150, 30);//שינוי שם למחלקת נוסע
        this.add(passengerClassLabel);
        this.passengerPClass = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.passengerPClass.setBounds(135, 0, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerPClass);


        JLabel passengerSex = new JLabel("Passenger Sex: ");
        passengerSex.setBounds(5, -10, 100, 130);//שינוי שם למחלקת נוסע
        this.add(passengerSex);
        this.passengerSexBox = new JComboBox<>(Constants.SEX_PASSENGER);
        this.passengerSexBox.setBounds(135, 40, 80, 30);
        this.add(this.passengerSexBox);

        JLabel passengerEmbarked = new JLabel("Passenger Embarked: ");
        passengerEmbarked.setBounds(5, 30, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerEmbarked);
        this.passengerEmbarkedBox = new JComboBox<>(Constants.Embarked);
        this.passengerEmbarkedBox.setBounds(135, 80, 80, 30);
        this.add(this.passengerEmbarkedBox);


        JLabel passengerIDMin = new JLabel("Passenger ID MIN: ");
        passengerIDMin.setBounds(5, 70, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerIDMin);
        this.passengerIDMinim = new JTextField("");
        this.passengerIDMinim.setBounds(135, 120, 80, 30);
        this.add(this.passengerIDMinim);


        JLabel passengerIDMax = new JLabel("Passenger ID MAX: ");
        passengerIDMax.setBounds(5, 110, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerIDMax);
        this.passengerIDMaxim = new JTextField("");
        this.passengerIDMaxim.setBounds(135, 160, 80, 30);
        this.add(this.passengerIDMaxim);


        JLabel passengerName = new JLabel("Passenger Name: ");
        passengerName.setBounds(5, 150, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerName);
        this.passengersNames = new JTextField("");
        this.passengersNames.setBounds(135, 200, 80, 30);
        this.add(this.passengersNames);


        JLabel passengerSibSp = new JLabel("Passenger Sib&Sp: ");
        passengerSibSp.setBounds(5, 190, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerSibSp);
        this.passengerSibAndSp = new JTextField("");
        this.passengerSibAndSp.setBounds(135, 240, 80, 30);
        this.add(this.passengerSibAndSp);

        JLabel passengerPrach = new JLabel("Passenger Prach: ");
        passengerPrach.setBounds(5, 230, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerPrach);
        this.passengerPraAndCh = new JTextField("");
        this.passengerPraAndCh.setBounds(135, 280, 80, 30);
        this.add(this.passengerPraAndCh);


        JLabel passengerTicket = new JLabel("Passenger Ticket: ");
        passengerTicket.setBounds(5, 270, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerTicket);
        this.passengerTickets = new JTextField("");
        this.passengerTickets.setBounds(135, 320, 80, 30);
        this.add(this.passengerTickets);


        JLabel passengerFareMax = new JLabel("Passenger Max Fare: ");
        passengerFareMax.setBounds(5, 310, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerFareMax);
        this.passengerFareMaxim = new JTextField("");
        this.passengerFareMaxim.setBounds(135, 360, 80, 30);
        this.add(this.passengerFareMaxim);


        JLabel passengerFareMin = new JLabel("Passenger Min Fare: ");
        passengerFareMin.setBounds(5, 350, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerFareMin);
        this.passengerFareMinim = new JTextField("");
        this.passengerFareMinim.setBounds(135, 400, 80, 30);
        this.add(this.passengerFareMinim);


        JLabel passengerCabin = new JLabel("Passenger Cabin: ");
        passengerCabin.setBounds(5, 390, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerCabin);
        this.passengerCabins = new JTextField("");
        this.passengerCabins.setBounds(135, 440, 80, 30);
        this.add(this.passengerCabins);


        JLabel passengerAgeMin = new JLabel("Passenger AGE MIN: ");
        passengerAgeMin.setBounds(passengerIDMinim.getWidth() + passengerIDMinim.getX(), 70, 140, 130);
        this.add(passengerAgeMin);
        this.passengerAgeMinim = new JTextField("");
        this.passengerAgeMinim.setBounds(passengerAgeMin.getWidth() + passengerAgeMin.getX(), 120, 80, 30);
        this.add(this.passengerAgeMinim);


        JLabel passengerAgeMax = new JLabel("Passenger AGE MAX: ");
        passengerAgeMax.setBounds(passengerIDMaxim.getWidth() + passengerIDMaxim.getX(), 110, 140, 130);
        this.add(passengerAgeMax);
        this.passengerAgeMaxim = new JTextField("");
        this.passengerAgeMaxim.setBounds(passengerAgeMax.getWidth() + passengerAgeMax.getX(), 160, 80, 30);
        this.add(this.passengerAgeMaxim);


        this.searchButton = new JButton("Search Button");
        this.searchButton.setBounds(80, 480, 180, 50);
        this.add(this.searchButton);

        this.searchButton.addActionListener(e -> {
            try {
                callInitialization();
                callFiltering();
                writeToFile();
                survivedFilter();
            } catch (IOException ex) {
                ex.printStackTrace();

            }

        });
        percentageStatistics();


    }


    public int filterPassengerClass(String str) throws IOException {
        System.out.println("filterPassengerClass: start");
        int type = 0;
        if (str != null) {
            switch (str) {
                case "1st":
                    this.passengerList = passengerList.stream().filter(passenger1 -> passenger1.getPclass() == 1).collect(Collectors.toList());
                    type = 1;
                    break;
                case "2nd":
                    this.passengerList = passengerList.stream().filter(passenger1 -> passenger1.getPclass() == 2).collect(Collectors.toList());
                    type = 2;
                    break;
                case "3rd":
                    this.passengerList = passengerList.stream().filter(passenger1 -> passenger1.getPclass() == 3).collect(Collectors.toList());
                    type = 3;
                    break;
                case "All":
                    break;
            }
        }
        return type;
    }

    private void createPassengerList(File file) {
        System.out.println("createPassengerList: start");
        int index = 0;
        String lineData;
        this.passengerList = new ArrayList<>();
        try {
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    lineData = scanner.nextLine();
                    if (index != 0) {
                        Passenger passenger = new Passenger(lineData);
                        this.passengerList.add(passenger);
                    } else {
                        index++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        try {
            File output = new File("src/main/resources/pClass.csv" + counter);
            counter++;
            FileWriter fileWriter = new FileWriter(output);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked");
            for (int i = 1; i < this.passengerList.size(); i++) {
                printWriter.println(this.passengerList.get(i));
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String genderFiltering(String gender) throws IOException {
        System.out.println("genderFiltering: start");
        String sexType;
        if (!gender.isEmpty()) {
            if (gender.equals("male")) {
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getSex().equals("male")).collect(Collectors.toList());
                sexType = "male";
                return sexType;
            } else if (gender.equals("female")) {
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getSex().equals("female")).collect(Collectors.toList());
                sexType = "female";
                return sexType;
            }
        }
        return gender;

    }

    public void filterPassengerEmbark(String str) throws IOException {//"All", "C", "Q", "S"
        System.out.println("filterPassengerEmbarked: start");
        if (!str.isEmpty()) {
            switch (str) {
                case "C":
                    this.passengerList = passengerList.stream().filter(passenger -> passenger.getEmbarked().contains("C")).collect(Collectors.toList());
                    break;
                case "Q":
                    this.passengerList = passengerList.stream().filter(passenger -> passenger.getEmbarked().contains("Q")).collect(Collectors.toList());
                    break;
                case "S":
                    this.passengerList = passengerList.stream().filter(passenger -> passenger.getEmbarked().contains("S")).collect(Collectors.toList());
                    break;
                case "All":
                    break;

            }
        }
    }

    public void IdRangeFiltering(String minId, String maxId) {
        System.out.println("idFiltering: start");
        int finalMinId;
        int finalMaxId;
        if (!minId.isEmpty()) {
            finalMinId = Integer.parseInt(minId);
        } else {
            finalMinId = 0;
        }
        if (!maxId.isEmpty()) {
            finalMaxId = Integer.parseInt(maxId);
        } else {
            finalMaxId = Constants.MAX_INDEX_LIST;
        }

        this.passengerList = passengerList.stream().filter(passenger -> (passenger.getPassengerId() <= finalMaxId && passenger.getPassengerId() >= finalMinId)).collect(Collectors.toList());
    }

    public void ageFilter(String minAge, String maxAge) {
        int finalMaxAge;
        int finalMinAge;
        if (!minAge.isEmpty()) {
            finalMinAge = Integer.parseInt(minId);
        } else {
            finalMinAge = 0;
        }
        if (!maxAge.isEmpty()) {
            finalMaxAge = Integer.parseInt(maxId);
        } else {
            finalMaxAge = 90;
        }
        this.passengerList = passengerList.stream().filter(passenger -> (passenger.getPassengerId() <= finalMaxAge && passenger.getPassengerId() >= finalMinAge)).collect(Collectors.toList());


    }

    public void findName(String partOfName) throws IOException {
        System.out.println("NameFiltering: start");
        if (!name.isEmpty()) {
            try {
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getName().contains(partOfName)).collect(Collectors.toList());

            } catch (Exception e) {
                System.out.println(e);

            }
        }


    }

    public void filterSibSp(String numSibSp) throws IOException {
        System.out.println("NumberOfSibSpFiltering: start");
        if (passengerSibAndSp.isEnabled() && !numSibSp.isEmpty()) {
            this.passengerList = passengerList.stream().filter(passenger -> Objects.equals(passenger.getSibSp(), numSibSp)).collect(Collectors.toList());
        }


    }

    public void filterPrach(String numPrach) throws IOException {
        System.out.println("NumberOfPranchFiltering: start");
        if (passengerPraAndCh.isEnabled() && !numPrach.isEmpty()) {
            this.passengerList = passengerList.stream().filter(passenger -> passenger.getParch().equals(numPrach)).collect(Collectors.toList());

        }

    }

    public void filterTicket(String ticketNum) throws IOException {
        System.out.println("TicketFiltering: start");
        if (passengerTickets.isEnabled() && !ticketNum.isEmpty()) {
            this.passengerList = passengerList.stream().filter(passenger -> passenger.getTicket().contains(ticketNum)).collect(Collectors.toList());
        }

    }

    public void rangePriceFiltering(String minFare, String maxFare) throws IOException {
        System.out.println("TicketPricesFiltering: start");
        double finalMaxFare;
        double finalMinFare;
        System.out.println("start");
        if (!minFare.isEmpty()) {
            finalMinFare = Double.parseDouble(minFare);
        } else {
            finalMinFare = 0;
        }
        if (!maxFare.isEmpty()) {
            finalMaxFare = Double.parseDouble(maxFare);
        } else {
            finalMaxFare = 512.3292; // לעשות פינל של מחיר מקסימלי
        }
        this.passengerList = passengerList.stream().filter(passenger -> passenger.getFare() <= finalMaxFare && passenger.getFare() >= finalMinFare).collect(Collectors.toList());

    }

    public void filterCabin(String cabin) {
        System.out.println("filterCabin: start");
        try {
            if (passengerCabins.isEnabled() && cabin != null) {
                this.passengerList = passengerList.stream().filter(passenger -> passenger.getCabin().contains(cabin)).collect(Collectors.toList());
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void survivedFilter() {
        System.out.println("survivedFilter: srart");
        String rows = "Total Rows: ";
        List<Passenger> passengerListNew;
        int live = 0;
        int dead = 0;
        if (!this.passengerList.isEmpty()) {
            passengerListNew = this.passengerList.stream().filter(Passenger::isSurvived).collect(Collectors.toList());
            live = passengerListNew.size();
            passengerListNew = this.passengerList.stream().filter(passenger -> !passenger.isSurvived()).collect(Collectors.toList());
            dead = passengerListNew.size();

        }
        rows += live + dead + " (" + live + " survived," + dead + " did not)";
        System.out.println(rows);
    }

    public void percentageStatistics() {
        this.statistic = new JButton("statistic Button");
        this.statistic.setBounds(searchButton.getWidth() + searchButton.getX(), 480, 180, 50);
        this.add(this.statistic);
        this.statistic.addActionListener(e -> {
            Statistics statistics = new Statistics(this.passengerList);
            callInitialization();
            try {
                double percentage = statistics.survivorPercentageInClass(filterPassengerClass(typeClassOfClass));
                double percentage1 = statistics.statisticsInSex(genderFiltering(typeClassOfSex));
                List<Double> percentage2 = statistics.ageFilterStatistics();
                List<Double> percentage3 = statistics.isFamilyInDeck();
                List<Double> percentage4 = statistics.surviveByTicketPrice();
                double percentage5 = statistics.embarkedStatistics(typeClassOfEmbarked);
                new WriteToCsv(percentage,percentage1,percentage2,percentage3,percentage4,percentage5);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }

    public void callInitialization() {
        this.typeClassOfClass = (String) passengerPClass.getSelectedItem();
        this.typeClassOfSex = (String) passengerSexBox.getSelectedItem();
        this.typeClassOfEmbarked = (String) passengerEmbarkedBox.getSelectedItem();
        this.minId = passengerIDMinim.getText();
        this.maxId = passengerIDMaxim.getText();
        this.name = passengersNames.getText();
        this.sibSp = passengerSibAndSp.getText();
        this.prach = passengerPraAndCh.getText();
        this.ticket = passengerTickets.getText();
        this.maxFare = passengerFareMaxim.getText();
        this.minFare = passengerFareMinim.getText();
        this.cabins = passengerCabins.getText();
        this.minAge = passengerAgeMinim.getText();
        this.maxAge = passengerAgeMaxim.getText();
    }

    public void callFiltering() throws IOException {
        filterPassengerClass(typeClassOfClass);
        genderFiltering(typeClassOfSex);
        filterPassengerEmbark(typeClassOfEmbarked);
        IdRangeFiltering(minId, maxId);
        findName(name);
        filterSibSp(sibSp);
        filterPrach(prach);
        filterTicket(ticket);
        rangePriceFiltering(minFare, maxFare);
        filterCabin(cabins);
        ageFilter(minAge, maxAge);
    }
}


//    public List<String> getPasClass(List<Passenger> passengers){
//    import com.gembox.spreadsheet.SpreadsheetInfo;
// public static void writeToTextFile (String path, String text) {
//        try {
//            FileWriter fileWriter = new FileWriter(path);
//            fileWriter.write(text);
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


