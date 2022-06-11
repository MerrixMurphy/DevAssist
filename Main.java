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
                BasicReact reactapp = new BasicReact();
                path = new File("../", repo);
                new File(path.toString()).mkdir();
                reactapp.treeBuilder(path.toString()+"/");
                menu(path);            
            } else {
                menu(path);
            }
        }
        else if(home == 2){
            // add folder for main page and main page file edit routes
            JOptionPane.showMessageDialog(frame,"New Main Page");
            menu(path);
        }
        else if(home == 3){
            // add sub page file to main page folder edit routes
            JOptionPane.showMessageDialog(frame,"New Sub Page");
            menu(path);
        }
        else if(home == 4){
            String repo = (String)JOptionPane.showInputDialog(frame,"New Component","DebAssist",JOptionPane.PLAIN_MESSAGE,null, null, null);
            if ((repo != null) && (repo.length() > 0)) {
                BasicReact reactapp = new BasicReact();
                reactapp.addComponent(path.toString()+"/");
                menu(path);            
            } else {
                menu(path);
            }
        }
        else if(home == 5){
            //edit nav file link to "/" choose between internal and external link
            JOptionPane.showMessageDialog(frame,"New Nav Option");
            menu(path);
        }
        else if(home == 6){
            //edit footer file and link to "/". choose between internal and external link
            JOptionPane.showMessageDialog(frame,"New Footer Option");
            menu(path);
        }
        else if(home == 7){
            JOptionPane.showMessageDialog(frame,"New Table");
            menu(path);
        }

        //maybe api later
    }
}