package objects;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;


public class MP3Player {
    private String currentFile;
    private double currentVolume;
    private BasicPlayer player = new BasicPlayer();
    private BasicPlayerListener listener;


    
    public synchronized void play (String pathFile) throws IOException,BasicPlayerException{
               
        if(currentFile==pathFile&&player.getStatus()==BasicPlayer.PAUSED){   
                player.resume();
        }else if(currentFile==pathFile&&player.getStatus()==BasicPlayer.PLAYING){
                return;
        }else {   
            currentFile=pathFile;
            player.open(new File(currentFile));
            player.play();
        }
    }
    
    public void stop(){
        try {
            player.stop();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pause(){
        try {
            player.pause();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getPathCurrentSong(){
        return currentFile;
    }
    
    public void setVolume(int cur,int max){
        try {
            player.setGain(calcVol(cur, max));
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getStatus(){
        return player.getStatus();
    }

    private double calcVol(int cur, int max) {
      return currentVolume=(double)cur/max;
    }
    
    public void addListener(BasicPlayerListener listener){
        player.addBasicPlayerListener(listener);
    }

    public void jump(long l) {
        try {
            player.seek(l);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
    

    
}
