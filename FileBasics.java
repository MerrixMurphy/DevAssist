import java.io.File;
import java.io.FileWriter;

public class FileBasics {
    protected String name;
    protected String content;

    protected FileBasics(String name, String content) {
        this.name = name;
        this.content = content;
    }

    static void fileCreator(String path, String name, String content){
        try{
            File file = new File(path + name);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        }
        catch(Exception e){
            System.out.println("Error creating file");
        }
    }
    
}
