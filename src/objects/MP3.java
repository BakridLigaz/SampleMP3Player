package objects;

import java.io.Serializable;
import utils.FileUtilites;

public class MP3 implements Serializable{

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
   private String name;
   private String path;

    public MP3(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return FileUtilites.getFileNameNotExtension(name);
    }

   
}
