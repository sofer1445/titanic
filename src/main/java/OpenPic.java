import javax.swing.*;
import java.awt.*;

public class OpenPic extends JPanel {


    private ImageIcon imageIcon ;

    public OpenPic(int x , int y , int width , int height){
        this.setBounds(x , y , width , height);
        this.imageIcon = new ImageIcon("titamic.png");


    }

    protected void paintComponent (Graphics graphics){
        super.paintComponent(graphics);
        this.imageIcon.paintIcon(this,graphics,Final.WINDOW_WIDTH,Final.WINDOW_HEIGHT);
    }

}
