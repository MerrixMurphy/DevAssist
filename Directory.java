import java.io.File;

public class Directory {
    protected String name;
    //validation to not recreate file if it already exists

    protected Directory(String name) {
        this.name = name;
    }

    static void dirCreator(String path, String name){
        try {
          name = name.replaceAll(" ", "-");
          new File(path + name).mkdir();
        } catch (Exception e) {
          System.out.println("Error creating directory");
        }
      }
}
