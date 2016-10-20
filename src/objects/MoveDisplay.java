package objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import utils.FontUtilites;

public class MoveDisplay extends JPanel{
    private int xStart;
    private int yStart;
    private int xCur;
    private String text;
    private Thread disp = new DisplayThread();
    private boolean isRun=false;
    private Font fontDisplay;
    private Font fontTime;
    private int sizeGraphics;
    private JLabel labelDuration = new JLabel();
    private JLabel labelCurrentTime = new JLabel();
    private JLabel labelStatus = new JLabel();
    private final JLabel delimetr = new JLabel("/");
    private final String NULL_DURATION = "00:00:00";
    private String currentTime = NULL_DURATION;
    private String duration = NULL_DURATION;
    private String status ="";
    

    public MoveDisplay(int xStart) {
        this.xStart = xStart;
        this.yStart = 18;
        initPos();
        fontDisplay = new FontUtilites().getFont("/fonts/DisplayOTF.otf",yStart);
        fontTime = new FontUtilites().getFont("/fonts/digital-7.ttf",15);
    }

    private void initPos(){
        xCur = xStart;

    }
    
    public void setText(String text){
        this.text = text;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.getHSBColor(162,231,181));
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.setFont(fontDisplay);
        g.drawString(text, xCur, yStart);
        this.setLayout(new MigLayout("","[]8[]","[]8[]"));
        sizeGraphics = g.getFontMetrics(g.getFont()).stringWidth(text);
        Dimension timeLabel = new Dimension(50, 15);
        Dimension statusLabel = new Dimension(25,15);
        labelStatus.setPreferredSize(statusLabel);
        labelStatus.setMaximumSize(statusLabel);
        labelStatus.setMinimumSize(statusLabel);
        labelDuration.setPreferredSize(timeLabel);
        labelDuration.setMaximumSize(timeLabel);
        labelDuration.setMinimumSize(timeLabel);
        labelCurrentTime.setPreferredSize(timeLabel);
        labelCurrentTime.setMaximumSize(timeLabel);
        labelCurrentTime.setMinimumSize(timeLabel);
        labelCurrentTime.setForeground(Color.BLACK);
        labelDuration.setForeground(Color.BLACK);
        delimetr.setForeground(Color.BLACK);
        delimetr.setFont(fontTime);
        labelCurrentTime.setFont(fontTime);
        labelDuration.setFont(fontTime);
        labelCurrentTime.setText(currentTime);
        labelDuration.setText(duration);
        labelStatus.setText(status);

        add(labelStatus,"cell 0 5");
        add(labelCurrentTime,"cell 1 5");
        add(delimetr,"cell 2 5");
        add(labelDuration,"cell 3 5");
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setStatus(Icon icon) {
        labelStatus.setIcon(icon);
    }
    
    public void startDraw(){
        if(isRun){
            initPos();
        }else{
            initPos();
            disp.start();
            isRun=true;
        }
    }
    
    private class DisplayThread extends Thread {
        @Override
        public void run() {
            while (true) {
                if (xCur == -(sizeGraphics)) {
                xCur = xStart;
                } else {
                xCur--;
                }
                repaint();
                try {
                Thread.sleep(30);
                } catch (Exception ex) {
                }
            }    
        }
    }
    

}
