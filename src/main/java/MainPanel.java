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

    public MainPanel (int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE);
        try{
            Scanner scanner = new Scanner(file);
            List<Passenger> passengerList = new ArrayList<>();
            int index = 0;
            while (scanner.hasNextLine()){
                String passenger = scanner.nextLine();
                if(index != 0){
                    Passenger passengerObject = new Passenger(passenger);
                    passengerList.add(passengerObject);
                }
                index++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
        JLabel survivedLabel = new JLabel("Passenger Class: ");
        survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel);
        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);
        this.survivedComboBox.addActionListener((e) -> {

//            FileReader reader = new FileReader(path);
            //do whatever you want on change

        });
    }

}
