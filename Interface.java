import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.*;
import java.nio.file.Path;

public class Interface extends JFrame {

   private JTextField text;
   private JButton button;
   private JLabel label;
  private  String path;
   private static boolean runnable = true;
   private static int OFFSET = 10;

    public Interface(){

        label = new JLabel();

        button = new JButton("Generate");
        button.setText("Generate");
        text = new JTextField();
        button.setSize(80,40);
        button.addActionListener(new MyListener());
        this.setSize(500,500);
        this.setDefaultCloseOperation(3);
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
