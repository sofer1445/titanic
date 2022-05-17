import javax.swing.*;

class Main extends JFrame {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        this.setTitle("Titanic Passengers Data");
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.add(new MainPanel(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setVisible(true);

    }



}