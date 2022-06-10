import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {
    private Passenger passengerObject;
    private List<Passenger> passengerList;
    private JComboBox<String> passengerPClass;
    private JComboBox<String> passengerSexBox;
    private JComboBox<String> passengerEmbarkedBox;
    private JTextField passengerIDMax;
    private JTextField passengerIDMin;
    private JTextField passengerName;
    private JTextField passengerSibSp;// אחים ובני זוג
    private JTextField passengerPrach; // ילדים והורים
    private JTextField passengerTicket;
    private JTextField passengerFareMax; // עלות הכרטיס בפואנד
    private JTextField passengerFareMin;
    private JTextField passengerCabin; // מספר תא
    private JButton searchButton;

    public MainPanel(int x, int y, int width, int height) {

        File fileOfCsv = new File(Constants.PATH_TO_DATA_FILE);
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
        createPassengerList(fileOfCsv);
        allUserFilter();


    }


    public void allUserFilter() {
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
                genderFiltering("male", passengerList);
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
                });

        JLabel passengerEmbarked = new JLabel("Passenger Embarked: ");
        passengerEmbarked.setBounds(5, 30, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerEmbarked);
        this.passengerEmbarkedBox = new JComboBox<>(Constants.Embarked);
        this.passengerEmbarkedBox.setBounds(135, 80, 80, 30);
        this.add(this.passengerEmbarkedBox);

        JLabel passengerIDMin = new JLabel("Passenger ID MIN: ");
        passengerIDMin.setBounds(5, 70, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerIDMin);
        this.passengerIDMin = new JTextField("");
        this.passengerIDMin.setBounds(135, 120, 80, 30);
        this.add(this.passengerIDMin);

        JLabel passengerIDMax = new JLabel("Passenger ID MAX: ");
        passengerIDMax.setBounds(5, 110, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerIDMax);
        this.passengerIDMax = new JTextField("");
        this.passengerIDMax.setBounds(135, 160, 80, 30);
        this.add(this.passengerIDMax);

        JLabel passengerName = new JLabel("Passenger Name: ");
        passengerName.setBounds(5, 150, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerName);
        this.passengerName = new JTextField("");
        this.passengerName.setBounds(135, 200, 80, 30);
        this.add(this.passengerName);

        JLabel passengerSibSp = new JLabel("Passenger Sib&Sp: ");
        passengerSibSp.setBounds(5, 190, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerSibSp);
        this.passengerSibSp = new JTextField("");
        this.passengerSibSp.setBounds(135, 240, 80, 30);
        this.add(this.passengerSibSp);

        JLabel passengerPrach = new JLabel("Passenger Prach: ");
        passengerPrach.setBounds(5, 230, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerPrach);
        this.passengerPrach = new JTextField("");
        this.passengerPrach.setBounds(135, 280, 80, 30);
        this.add(this.passengerPrach);


        JLabel passengerTicket = new JLabel("Passenger Ticket: ");
        passengerTicket.setBounds(5, 270, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerTicket);
        this.passengerTicket = new JTextField("");
        this.passengerTicket.setBounds(135, 320, 80, 30);
        this.add(this.passengerTicket);

        JLabel passengerFareMax = new JLabel("Passenger Max Fare: ");
        passengerFareMax.setBounds(5, 310, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerFareMax);
        this.passengerFareMax = new JTextField("");
        this.passengerFareMax.setBounds(135, 360, 80, 30);
        this.add(this.passengerFareMax);

        JLabel passengerFareMin = new JLabel("Passenger Min Fare: ");
        passengerFareMin.setBounds(5, 350, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerFareMin);
        this.passengerFareMin = new JTextField("");
        this.passengerFareMin.setBounds(135, 400, 80, 30);
        this.add(this.passengerFareMin);

        JLabel passengerCabin = new JLabel("Passenger Cabin: ");
        passengerCabin.setBounds(5, 390, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerCabin);
        this.passengerCabin = new JTextField("");
        this.passengerCabin.setBounds(135, 440, 80, 30);
        this.add(this.passengerCabin);


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
        try {
            File output = new File("src/main/resources/pClass.csv");
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

    public List<Passenger> genderFiltering(String typeSex, List<Passenger> afterFirstFiltering) {
        System.out.println("genderFiltering: start");
        List<Passenger> newList = null;
        switch (typeSex) {
            case "male":
                newList = afterFirstFiltering.stream().filter(Passenger::isSex).sorted().collect(Collectors.toList());//לא עובד הליסט ריק
                System.out.println("start swich" + newList.size());
                for (int i = 0; i < newList.size() - 1; i++) {
                    System.out.println(newList.get(i));
                }
                break;
            case "female":
                newList = afterFirstFiltering.stream().filter(Passenger::isSex).sorted().collect(Collectors.toList());
                break;
        }
        return newList;

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


}