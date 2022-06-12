import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileBasics {
    protected String name;
    protected String content;
    //validation to not recreate file if it already exists

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

    static void fileEditor(String path, String key, String amendment){
        try{
            File file = new File(path);
            String content = "";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null){
                if (line.trim().equals(key)){
                    content += amendment;
                }
                content += line + System.lineSeparator();
                line = reader.readLine();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            reader.close();
        }
        catch(Exception e){
            System.out.println("Error reading file");
        }
    }
    
}
