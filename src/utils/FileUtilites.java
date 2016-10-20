package utils;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public interface FileUtilites {
    
    public static void addFileFilter(JFileChooser chooser,FileFilter filter){
        chooser.removeChoosableFileFilter(chooser.getFileFilter());
        chooser.setFileFilter(filter);
        chooser.setSelectedFile(new File(""));
    }
    
    public static String getFileNameNotExtension(String name){
        String shortName = name.substring(0, name.lastIndexOf("."));
        return shortName;
    }
    
    public static String getExtension(String name){
        String extension = name.substring(name.lastIndexOf("."),name.length()+1);
        return extension;
    }
    
    public static void serilalize(Object object, String filename){
        ObjectOutputStream outputStream=null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            outputStream.writeObject(object);
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtilites.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileUtilites.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static Object desirialize(String filename){
        ObjectInputStream inputStream=null;
        try {       
            inputStream = new ObjectInputStream(new FileInputStream(filename));
            Object playlist = inputStream.readObject();
            return playlist;  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtilites.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FileUtilites.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileUtilites.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    
}
