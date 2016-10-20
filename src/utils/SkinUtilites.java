/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Admin
 */
public interface SkinUtilites {
    
    public static void changeSkin(Component component,Component chooser,String laf){
        try {
            UIManager.setLookAndFeel(laf);
            JFrame.setDefaultLookAndFeelDecorated(true);
            SwingUtilities.updateComponentTreeUI(component);
            if(null!=chooser){
               SwingUtilities.updateComponentTreeUI(chooser);
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(SkinUtilites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void changeSkin(JFrame component,Component chooser,Component popupMenu, LookAndFeel laf){
        try {
            UIManager.setLookAndFeel(laf);
            JFrame.setDefaultLookAndFeelDecorated(true);
            SwingUtilities.updateComponentTreeUI(component);
             if(null!=chooser){
               SwingUtilities.updateComponentTreeUI(chooser); 
            }
             if(null!=popupMenu){
               SwingUtilities.updateComponentTreeUI(popupMenu); 
            }
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SkinUtilites.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
