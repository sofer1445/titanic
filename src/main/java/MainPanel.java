import com.gembox.spreadsheet.SpreadsheetInfo;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPanel extends JPanel {
    private JComboBox<String> survivedComboBox;
//    private List<Passenger> passengerList = new ArrayList<>();

    public MainPanel (int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        List<Passenger> passengerList = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextLine()){
                String passenger = scanner.nextLine();
                if(index != 0){
                    Passenger passengerObject = new Passenger(passenger);
//                    passengerList.add(passengerObject);
                }
                index++;
            }

        } catch (Exception e) { //כל חריגה זה קופץ (כי לא הצלחתי להתגבר על הגלישה)
            e.printStackTrace();
        }
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
        JLabel passengerClassLabel = new JLabel("Passenger Class: ");
        passengerClassLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);//שינוי שם למחלקת נוסע
        this.add(passengerClassLabel);
        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(passengerClassLabel.getX() + passengerClassLabel.getWidth() + 1, passengerClassLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);
        this.survivedComboBox.addActionListener((e) -> {
//            if(Constants.PASSENGER_CLASS_OPTIONS[1] == e.getActionCommand()){
//
//            }
            //do whatever you want on change

        });
    }

//    public List<String> getPasClass(List<Passenger> passengers){
//
//
//    }

}
