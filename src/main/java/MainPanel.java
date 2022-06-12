import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    private Passenger passengerObject;
    private List<Passenger> passengerList;
    private JComboBox<String> passengerPClass;
    private JComboBox<String> passengerSexBox;
    private JComboBox<String> passengerEmbarkedBox;
    private JTextField passengerIDMaxim;
    private JTextField passengerIDMinim;
    private JTextField passengerName;
    private JTextField passengerSibAndSp;// אחים ובני זוג
    private JTextField passengerPraAndCh; // ילדים והורים
    private JTextField passengerTickets;
    private JTextField passengerFareMaxim; // עלות הכרטיס בפואנד
    private JTextField passengerFareMinim;
    private JTextField passengerCabins; // מספר תא
    private JButton searchButton;
    private String minId;
    private String maxId;
    private String minFare;
    private String maxFare;

    public MainPanel(int x, int y, int width, int height) throws IOException {

        File fileOfCsv = new File(Constants.PATH_TO_DATA_FILE);
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
        createPassengerList(fileOfCsv);
        allUserFilter();


    }


    public void allUserFilter() throws IOException {
        JLabel passengerClassLabel = new JLabel("Passenger Class: ");
        passengerClassLabel.setBounds(5, 0, 150, 30);//שינוי שם למחלקת נוסע
        this.add(passengerClassLabel);
        this.passengerPClass = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.passengerPClass.setBounds(135, 0, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.passengerPClass);
        this.passengerPClass.addActionListener(e -> {
            String typeClass = (String) passengerPClass.getSelectedItem();
            try {
                filterPassengerClass(typeClass);
//                genderFiltering("male", passengerList);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

//            this.classType = this.passengerPClass.getSelectedIndex();

        });

        JLabel passengerSex = new JLabel("Passenger Sex: ");
        passengerSex.setBounds(5, -10, 100, 130);//שינוי שם למחלקת נוסע
        this.add(passengerSex);
        this.passengerSexBox = new JComboBox<>(Constants.SEX_PASSENGER);
        this.passengerSexBox.setBounds(135, 40, 80, 30);
        this.add(this.passengerSexBox);
        this.passengerSexBox.addActionListener(e -> {
            String typeClass = (String) passengerSexBox.getSelectedItem();
            try {
                genderFiltering(typeClass);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        JLabel passengerEmbarked = new JLabel("Passenger Embarked: ");
        passengerEmbarked.setBounds(5, 30, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerEmbarked);
        this.passengerEmbarkedBox = new JComboBox<>(Constants.Embarked);
        this.passengerEmbarkedBox.setBounds(135, 80, 80, 30);
        this.add(this.passengerEmbarkedBox);
        this.passengerEmbarkedBox.addActionListener(e -> {
            String typeClass = (String) passengerEmbarkedBox.getSelectedItem();
//            try {
//                filterPassengerEmbark(typeClass);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
        });


        JLabel passengerIDMin = new JLabel("Passenger ID MIN: ");
        passengerIDMin.setBounds(5, 70, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerIDMin);
        this.passengerIDMinim = new JTextField("");
        this.passengerIDMinim.setBounds(135, 120, 80, 30);
        this.add(this.passengerIDMinim);
        this.passengerIDMinim.addActionListener(e -> {
            this.minId = passengerIDMinim.getText();
        });

        JLabel passengerIDMax = new JLabel("Passenger ID MAX: ");
        passengerIDMax.setBounds(5, 110, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerIDMax);
        this.passengerIDMaxim = new JTextField("");
        this.passengerIDMaxim.setBounds(135, 160, 80, 30);
        this.add(this.passengerIDMaxim);
        this.passengerIDMaxim.addActionListener(e -> {
            this.maxId = passengerIDMaxim.getText();
        });
        IdRangeFiltering(minId, maxId);

        JLabel passengerName = new JLabel("Passenger Name: ");
        passengerName.setBounds(5, 150, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerName);
        this.passengerName = new JTextField("");
        this.passengerName.setBounds(135, 200, 80, 30);
        this.add(this.passengerName);
        this.passengerName.addActionListener(e -> {
            String name = this.passengerName.getText();
            try {
                findName(name);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        JLabel passengerSibSp = new JLabel("Passenger Sib&Sp: ");
        passengerSibSp.setBounds(5, 190, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerSibSp);
        this.passengerSibAndSp = new JTextField("");
        this.passengerSibAndSp.setBounds(135, 240, 80, 30);
        this.add(this.passengerSibAndSp);
        this.passengerSibAndSp.addActionListener(e -> {
            try {
                String sibSp = passengerSibAndSp.getText();
                filterSibSp(sibSp);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        JLabel passengerPrach = new JLabel("Passenger Prach: ");
        passengerPrach.setBounds(5, 230, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerPrach);
        this.passengerPraAndCh = new JTextField("");
        this.passengerPraAndCh.setBounds(135, 280, 80, 30);
        this.add(this.passengerPraAndCh);
        this.passengerPraAndCh.addActionListener(e -> {
            try {
                String prach = passengerPraAndCh.getText();
                filterPrach(prach);
            } catch (Exception e1) {
                System.out.println(e1);
            }
        });


        JLabel passengerTicket = new JLabel("Passenger Ticket: ");
        passengerTicket.setBounds(5, 270, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerTicket);
        this.passengerTickets = new JTextField("");
        this.passengerTickets.setBounds(135, 320, 80, 30);
        this.add(this.passengerTickets);
        this.passengerTickets.addActionListener(e -> {
            try {
                String ticket = passengerTickets.getText();
                filterTicket(ticket);

            } catch (Exception e2) {
                System.out.println(e2);
            }
        });

        JLabel passengerFareMax = new JLabel("Passenger Max Fare: ");
        passengerFareMax.setBounds(5, 310, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerFareMax);
        this.passengerFareMaxim = new JTextField("");
        this.passengerFareMaxim.setBounds(135, 360, 80, 30);
        this.add(this.passengerFareMaxim);
        this.passengerFareMaxim.addActionListener(e -> {
            this.maxFare = passengerFareMaxim.getText();
        });

        JLabel passengerFareMin = new JLabel("Passenger Min Fare: ");
        passengerFareMin.setBounds(5, 350, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerFareMin);
        this.passengerFareMinim = new JTextField("");
        this.passengerFareMinim.setBounds(135, 400, 80, 30);
        this.add(this.passengerFareMinim);
        this.passengerFareMinim.addActionListener(e -> {
            this.minFare = passengerFareMinim.getText();
        });
        rangePriceFiltering(minFare, maxFare);

        JLabel passengerCabin = new JLabel("Passenger Cabin: ");
        passengerCabin.setBounds(5, 390, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerCabin);
        this.passengerCabins = new JTextField("");
        this.passengerCabins.setBounds(135, 440, 80, 30);
        this.add(this.passengerCabins);


        this.searchButton = new JButton("Search Button");
        this.searchButton.setBounds(80, 480, 180, 50);
        this.add(this.searchButton);

        this.searchButton.addActionListener(e -> {


        });


    }


//    private List<Passenger> passengerList = new ArrayList<>();


    public void filterPassengerClass(String str) throws IOException {
        System.out.println("filterPassengerClass: start");
        //סינון לפי מחלקה מתודה :
        switch (str) {
            case "1st":
                this.passengerList = passengerList.stream().filter(passenger1 -> passenger1.getPclass() == 1).collect(Collectors.toList());
                break;
            case "2nd":
                this.passengerList = passengerList.stream().filter(passenger1 -> passenger1.getPclass() == 2).collect(Collectors.toList());
                break;
            case "3rd":
                this.passengerList = passengerList.stream().filter(passenger1 -> passenger1.getPclass() == 3).collect(Collectors.toList());
                break;
            case "All":
                break;
        }
//        try {
//            File output = new File("src/main/resources/pClass.csv");
//            FileWriter fileWriter = new FileWriter(output);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println("PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked");
//            for (int i = 1; i < this.passengerList.size(); i++) {
//                printWriter.println(this.passengerList.get(i));
//            }
//            printWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private void createPassengerList(File file) {
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

    private void writeToFile(String text, String path) {//לא שמיש עדין
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void genderFiltering(String gender) throws IOException {
        System.out.println("genderFiltering: start");
        if (gender.equals("male")) {
            this.passengerList = passengerList.stream().filter(passenger -> passenger.getSex().equals("male")).collect(Collectors.toList());
        } else if (gender.equals("female")) {
            this.passengerList = passengerList.stream().filter(passenger -> passenger.getSex().equals("female")).collect(Collectors.toList());
        }
//        try {
//            File output = new File("src/main/resources/pClass.csv");
//            FileWriter fileWriter = new FileWriter(output);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println("PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked");
//            for (int i = 1; i < this.passengerList.size(); i++) {
//                printWriter.println(this.passengerList.get(i));
//            }
//            printWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public void filterPassengerEmbark(String str) throws IOException {//"All", "C", "Q", "S"
        System.out.println("filterPassengerEmbarked: start"); //צריך להבין למה כל העמודה הזאת NULL תמיד
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

//        try {
//            File output = new File("src/main/resources/pClass.csv");
//            FileWriter fileWriter = new FileWriter(output);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println("PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked");
//            for (int i = 1; i < this.passengerList.size(); i++) {
//                printWriter.println(this.passengerList.get(i));
//            }
//            printWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public void IdRangeFiltering(String minId, String maxId) {
        System.out.println("idFiltering: start");
        int finalMinId;
        int finalMaxId;
        if (minId != null && maxId != null) {
            finalMinId = Integer.parseInt(minId);
            finalMaxId = Integer.parseInt(maxId);
        } else {
            finalMinId = 0;
            finalMaxId = this.passengerList.size();
        }

        this.passengerList = passengerList.stream().filter(passenger -> (passenger.getPassengerId() <= finalMaxId && passenger.getPassengerId() >= finalMinId)).collect(Collectors.toList());
    }

    public void findName(String partOfName) throws IOException {
        System.out.println("NameFiltering: start");
        try {
            String finalPartOfName = partOfName;
            this.passengerList = passengerList.stream().filter(passenger -> passenger.getName().contains(finalPartOfName)).collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println(e);

        }
        System.out.println(this.passengerList);

    }

    public void filterSibSp(String numSibSp) throws IOException {
        System.out.println("NumberOfSibSpFiltering: start"); //לא מקבל את תוכן התיבה
//        if (passengerSibSp.isEnabled())
        this.passengerList = passengerList.stream().filter(passenger -> Objects.equals(passenger.getSibSp(), numSibSp)).collect(Collectors.toList());

        System.out.println(this.passengerList);


    }

    public void filterPrach(String numPrach) throws IOException {
        System.out.println("NumberOfPranchFiltering: start");
        if (passengerPraAndCh.isEnabled()) {
            this.passengerList = passengerList.stream().filter(passenger -> passenger.getParch().equals(numPrach)).collect(Collectors.toList());

        }

    }

    public void filterTicket(String ticketNum) throws IOException {
        System.out.println("TicketFiltering: start");
        if (passengerTickets.isEnabled()) {
            this.passengerList = passengerList.stream().filter(passenger -> passenger.getTicket().contains(ticketNum)).collect(Collectors.toList());
        }

    }

    public void rangePriceFiltering(String minFare, String maxFare) throws IOException {
        System.out.println("TicketPricesFiltering: start");
        double finalMaxFare ;
        double finalMinFare ;
        if (minFare != null && maxFare != null) {
                System.out.println("start");
                 finalMaxFare = Double.parseDouble(maxFare);
                 finalMinFare = Double.parseDouble(minFare);
                System.out.println(this.passengerList);

        }else {
            finalMaxFare = 93.5; // לעשות פינל של מחיר מקסימלי
            finalMinFare = 0;
        }
        this.passengerList = passengerList.stream().filter(passenger -> passenger.getFare() <= finalMaxFare && passenger.getFare() >= finalMinFare).collect(Collectors.toList());
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


