import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File path = new File("../");
        menu(path);
    }

    public static void menu(File path){
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
        int home = JOptionPane.showOptionDialog(frame,"Selected Repo: " + path.toString().substring(0),"DebAssist", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[options.length - 1]);
        
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
                path = new File("../", repo.replaceAll(" ", "-"));
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
            if (!path.toString().equals("..")){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Main Page","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                reactapp.addMain(path.toString()+"/", repo);
                menu(path);
            } else {
                menu(path);
            }
        } else {
            JOptionPane.showMessageDialog(frame,"No Repo Selected","DebAssist",JOptionPane.PLAIN_MESSAGE,null);
            menu(path);
        }
    }
        else if(home == 3){
            if (!path.toString().equals("..")){
            File newPath = new File(path+"/front-end/src/");
            String[] excludeStrings = {"home", "layout", "utils", "App.js", "index.js"};
            Object[] availablePages = newPath.list();
            Object[] copy = new Object[availablePages.length - 5];

            for(int j = 0; j < excludeStrings.length; j++){
                for(int i = 0; i < availablePages.length-1; i++){
                    if(availablePages[i] != null){
                    if(excludeStrings[j].equals(availablePages[i].toString())){
                        availablePages[i] = null;
                    }
                }
                }
            }
            for(int i = 0, j = 0; i < availablePages.length-1; i++){
                if(availablePages[i] != null){
                    copy[j++] = availablePages[i];
                }
            }
            if (copy.length > 0) {
            String main = (String)JOptionPane.showInputDialog(frame,"Select Main Page","DebAssist",JOptionPane.PLAIN_MESSAGE,null,copy,copy[0]);
            if ((main != null) && (main.length() > 0)) {
                String sub = (String)JOptionPane.showInputDialog(frame,"New Sub Page","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
                if ((sub != null) && (sub.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                reactapp.addSub(newPath.toString()+"/", main, sub);
                menu(path);
            } else {
                menu(path);
            }
            } else {
                menu(path);
            }
        } else {
            JOptionPane.showMessageDialog(frame,"No Main Pages Available","DebAssist",JOptionPane.PLAIN_MESSAGE,null);
            menu(path);
        }
        } else {
            JOptionPane.showMessageDialog(frame,"No Repo Selected","DebAssist",JOptionPane.PLAIN_MESSAGE,null);
            menu(path);
        }
        }
        else if(home == 4){
            if (!path.toString().equals("..")){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Component","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                reactapp.addComponent(path.toString()+"/", repo);
                menu(path);            
            } else {
                menu(path);
            }
        } else {
            JOptionPane.showMessageDialog(frame,"No Repo Selected","DebAssist",JOptionPane.PLAIN_MESSAGE,null);
            menu(path);
        }
        }
        else if(home == 5){
            if (!path.toString().equals("..")){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Nav Option","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                reactapp.addNav(path.toString()+"/", repo);
                menu(path);            
            } else {
                menu(path);
            }
        } else {
            JOptionPane.showMessageDialog(frame,"No Repo Selected","DebAssist",JOptionPane.PLAIN_MESSAGE,null);
            menu(path);
        }
        }
        else if(home == 6){
            if (!path.toString().equals("..")){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Footer Option","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                int linkType = JOptionPane.showOptionDialog(frame,"Selected Repo: " + path.toString().substring(0),"DebAssist", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,in_ex,in_ex[1]);
                BasicReact reactapp = new BasicReact();
                reactapp.addFooter(path.toString()+"/", repo, linkType);
                menu(path);            
            } else {
                menu(path);
            }
        } else {
            JOptionPane.showMessageDialog(frame,"No Repo Selected","DebAssist",JOptionPane.PLAIN_MESSAGE,null);
            menu(path);
        }
        }
        else if(home == 7){
            if (!path.toString().equals("..")){
            //add table folder with router controller and service, edit app, create seed, run seed and edit migration file, edit jsonCreator
            JOptionPane.showMessageDialog(frame,"New Table");
            menu(path);
        } else {
            JOptionPane.showMessageDialog(frame,"No Repo Selected","DebAssist",JOptionPane.PLAIN_MESSAGE,null);
            menu(path);
        }
        }

        //maybe api later
    }
}