
import java.io.*;
import java.nio.*;
import java.nio.file.Path;
import java.awt.*;
import java.awt.event.*;

public class Interface extends Frame {

   private TextField text;
   private Button button;
   private Label label;
  private  String path;
   private static boolean runnable = true;
   private static int OFFSET = 10;

  

    public Interface(){
        this.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();
                System.exit(1);    }
            });
        this.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent e){
                resize();
            }
        });

        label = new Label();

        button = new Button("Generate");
        
        text = new TextField();
        button.setSize(80,40);
        button.addActionListener(new MyListener());
        this.setSize(500,500);
        this.setLayout(null);
        this.add(text);
        this.add(label);
        this.add(button);
        this.label.setLocation(this.getWidth()/2-this.text.getWidth()/2,(this.getHeight()/2-this.text.getHeight()/2)+this.text.getHeight()+OFFSET);

        this.text.setSize(200,40);
        this.text.setLocation(this.getWidth()/2-this.text.getWidth()/2,this.getHeight()/2-this.text.getHeight()/2);
        this.button.setLocation(this.getWidth()/2-this.button.getWidth()/2,this.getHeight()/2-(this.button.getHeight()/2)+this.text.getHeight()+OFFSET);
        this.setTitle("HTML generator");
        this.setVisible(true);
       
    

    }
    
    public void resize(){
         this.label.setLocation(this.getWidth()/2-this.text.getWidth()/2,(this.getHeight()/2-this.text.getHeight()/2)+this.text.getHeight()+OFFSET);
        this.text.setLocation(this.getWidth()/2-this.text.getWidth()/2,this.getHeight()/2-this.text.getHeight()/2);
        this.button.setLocation(this.getWidth()/2-this.button.getWidth()/2,this.getHeight()/2-(this.button.getHeight()/2)+this.text.getHeight()+OFFSET);
    }

    public String getPath(){
        return this.path;
    }
    public static void main(String[] args) {

        Interface inter = new Interface();
    }
    private class MyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("a program lefutott");
            path = text.getText();
            System.out.println(path);
            File[] files = new File(path).listFiles();
            Main.Makehtmlfiles(files,path);
            System.out.println("A program lefutott");
        }
    }
}
