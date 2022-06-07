import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPanel extends JPanel {

    private JComboBox<String> survivedComboBox;
    private JComboBox<String> passengerSexBox ;
    private JComboBox<String> passengerEmbarkedBox;
    private JTextField passengerIDMax ;
    private JTextField passengerIDMin ;
    private JTextField passengerName ;
    private JTextField passengerSibSp ;// אחים ובני זוג
    private JTextField passengerPrach ; // ילדים והורים
    private JTextField passengerTicket ;
    private JTextField passengerFareMax ; // עלות הכרטיס בפואנד
    private JTextField passengerFareMin;
    private JTextField passengerCabin ; // מספר תא
    private JButton searchButton ;

    public void allUserFilter (){
        JLabel passengerClassLabel = new JLabel("Passenger Class: ");
        passengerClassLabel.setBounds(5, 0, 150 , 30);//שינוי שם למחלקת נוסע
        this.add(passengerClassLabel);
        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(135,0, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);
        JLabel passengerSex = new JLabel("Passenger Sex: ");
        passengerSex.setBounds(5, -10, 100, 130);//שינוי שם למחלקת נוסע
        this.add(passengerSex);
        this.passengerSexBox = new JComboBox<>(Constants.SEX_PASSENGER);
        this.passengerSexBox.setBounds(135, 40, 80,30);
        this.add(this.passengerSexBox);

        JLabel passengerEmbarked = new JLabel("Passenger Embarked: ");
        passengerEmbarked.setBounds(5, 30, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerEmbarked);
        this.passengerEmbarkedBox = new JComboBox<>(Constants.Embarked);
        this.passengerEmbarkedBox.setBounds(135, 80, 80,30);
        this.add(this.passengerEmbarkedBox);

        JLabel passengerIDMin = new JLabel("Passenger ID MIN: ");
        passengerIDMin.setBounds(5, 70, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerIDMin);
        this.passengerIDMin = new JTextField("");
        this.passengerIDMin.setBounds(135,120,80,30);
        this.add(this.passengerIDMin);

        JLabel passengerIDMax = new JLabel("Passenger ID MAX: ");
        passengerIDMax.setBounds(5, 110, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerIDMax);
        this.passengerIDMax = new JTextField("");
        this.passengerIDMax.setBounds(135,160,80,30);
        this.add(this.passengerIDMax);

        JLabel passengerName = new JLabel("Passenger Name: ");
        passengerName.setBounds(5, 150, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerName);
        this.passengerName = new JTextField("");
        this.passengerName.setBounds(135,200,80,30);
        this.add(this.passengerName);

        JLabel passengerSibSp = new JLabel("Passenger Sib&Sp: ");
        passengerSibSp.setBounds(5, 190, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerSibSp);
        this.passengerSibSp = new JTextField("");
        this.passengerSibSp.setBounds(135,240,80,30);
        this.add(this.passengerSibSp);

        JLabel passengerPrach = new JLabel("Passenger Prach: ");
        passengerPrach.setBounds(5, 230, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerPrach);
        this.passengerPrach = new JTextField("");
        this.passengerPrach.setBounds(135,280,80,30);
        this.add(this.passengerPrach);


        JLabel passengerTicket = new JLabel("Passenger Ticket: ");
        passengerTicket.setBounds(5, 270, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerTicket);
        this.passengerTicket = new JTextField("");
        this.passengerTicket.setBounds(135,320,80,30);
        this.add(this.passengerTicket);

        JLabel passengerFareMax = new JLabel("Passenger Max Fare: ");
        passengerFareMax.setBounds(5, 310, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerFareMax);
        this.passengerFareMax = new JTextField("");
        this.passengerFareMax.setBounds(135,360,80,30);
        this.add(this.passengerFareMax);

        JLabel passengerFareMin = new JLabel("Passenger Min Fare: ");
        passengerFareMin.setBounds(5, 350, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerFareMin);
        this.passengerFareMin = new JTextField("");
        this.passengerFareMin.setBounds(135,400,80,30);
        this.add(this.passengerFareMin);

        JLabel passengerCabin = new JLabel("Passenger Cabin: ");
        passengerCabin.setBounds(5, 390, 140, 130);//שינוי שם למחלקת נוסע
        this.add(passengerCabin);
        this.passengerCabin = new JTextField("");
        this.passengerCabin.setBounds(135,440,80,30);
        this.add(this.passengerCabin);


        this.searchButton = new JButton("Search Button");
        this.searchButton.setBounds(80, 480, 180, 50);
        this.add(this.searchButton);

        this.searchButton.addActionListener(e  -> {



        });




    }


//    private List<Passenger> passengerList = new ArrayList<>();

    public MainPanel (int x, int y, int width, int height) {

        File file = new File(Constants.PATH_TO_DATA_FILE);
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);


        try {
            Scanner scanner = new Scanner(file);
            List<Passenger> passengerList = new ArrayList<>();
            int index = 0;
            while (scanner.hasNextLine()) {
                String passenger = scanner.nextLine();
                if (index != 0) {
                    Passenger passengerObject = new Passenger(passenger);
//                    passengerList.add(passengerObject);
                }
                index++;
            }
            allUserFilter();
        } catch (Exception e) { //כל חריגה זה קופץ (כי לא הצלחתי להתגבר על הגלישה)
            e.printStackTrace();
        }
    }

//    public List<String> getPasClass(List<Passenger> passengers){
//



}