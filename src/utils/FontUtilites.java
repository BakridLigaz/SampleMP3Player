/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class FontUtilites {
        public Font getFont(String path,float size){
        Font cur = null;
          try {
                         cur= Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream(path)).deriveFont(size);
                        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    catch(FontFormatException e)
                    {
                        e.printStackTrace();
                    }
          return cur;
    }
}
