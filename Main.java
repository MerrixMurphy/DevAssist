import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File path = new File("../");
        menu(path);
    }

    public static void menu(File path){
        //Make buttons into more of (4,2 grid)
        JFrame frame = new JFrame("DebAssist");
        Object[] options = {
        "Select Repo", 
        "New Repo", 
        "New Main Page", 
        "New Sub Page", 
        "New Component", 
        "New Nav Option", 
        "New Footer Option", 
        "New Table",
    };
    Object[] in_ex = {
        "internal",
        "external",
    };
    //start local web server and maybe git pull buttons?
        int home = JOptionPane.showOptionDialog(frame,"Selected Repo: " + path.toString().substring(0),"DebAssist", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[7]);
        
        if(home == 0){
            path = new File("../");
            Object[] availableRepos = path.list();
            String repo = (String)JOptionPane.showInputDialog(frame,"Select Repo","DebAssist",JOptionPane.PLAIN_MESSAGE,null,availableRepos,availableRepos[0]);
            if ((repo != null) && (repo.length() > 0)) {
                path = new File("../", repo);
                menu(path);
            } else {
                menu(path);
            }
        }
        else if(home == 1){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Repo","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                String description = (String)JOptionPane.showInputDialog(frame,"New Description","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
                if ((description != null) && (description.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                path = new File("../", repo);
                new File(path.toString()).mkdir();
                reactapp.treeBuilder(path.toString()+"/", repo, description);
                menu(path);
                } else {
                    menu(path);
                };            
            } else {
                menu(path);
            }
        }
        else if(home == 2){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Main Page","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                reactapp.addMain(path.toString()+"/", repo);
                menu(path);
            } else {
                menu(path);
            }
        }
        else if(home == 3){
            path = new File(path+"frontend/src/");
            String[] excludeStrings = {"home", "layout", "utils", "App.js", "'index.js", ".env", ".gitignore", "README.md", "package.json"};
            Object[] availablePages = path.list();
            for(int i = 0; i < availablePages.length; i++){
                for(int j = 0; j < excludeStrings.length; j++){
                    if(availablePages[i].toString().equals(excludeStrings[j])){
                        availablePages[i] = null;
                    }
                }
            }
            String main = (String)JOptionPane.showInputDialog(frame,"Select Main Page","DebAssist",JOptionPane.PLAIN_MESSAGE,null,availablePages,availablePages[0]);
            if ((main != null) && (main.length() > 0)) {
                String sub = (String)JOptionPane.showInputDialog(frame,"New Sub Page","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
                if ((sub != null) && (sub.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                reactapp.addSub(path.toString()+"/", main, sub);
                menu(path);
            } else {
                menu(path);
            }
            } else {
                menu(path);
            }
        }
        else if(home == 4){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Component","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                reactapp.addComponent(path.toString()+"/", repo);
                menu(path);            
            } else {
                menu(path);
            }
        }
        else if(home == 5){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Nav Option","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                reactapp.addNav(path.toString()+"/", repo);
                menu(path);            
            } else {
                menu(path);
            }
        }
        else if(home == 6){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Footer Option","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                int linkType = JOptionPane.showOptionDialog(frame,"Selected Repo: " + path.toString().substring(0),"DebAssist", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,in_ex,in_ex[1]);
                BasicReact reactapp = new BasicReact();
                reactapp.addFooter(path.toString()+"/", repo, linkType);
                menu(path);            
            } else {
                menu(path);
            }
        }
        else if(home == 7){
            //add table folder with router controller and service, edit app, create seed, run seed and edit migration file, edit jsonCreator
            JOptionPane.showMessageDialog(frame,"New Table");
            menu(path);
        }

        //maybe api later
    }
}