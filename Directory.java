import java.io.File;

public class Directory {
    protected String name;

    protected Directory(String name) {
        this.name = name;
    }

    static void dirCreator(String path, String name){
        try {
          new File(path + name).mkdir();
        } catch (Exception e) {
          System.out.println("Error creating directory");
        }
      }
}
