import java.io.File;


public class Main{

        public static void main(String[] args){

        
        if(args.length!=1){
            System.out.println("nincs megadva elérési útvonal");

        }

        File[] files = new File(args[0]).listFiles();

       

      MakeHTML2.Makehtmlfiles(files,args[0]);
      System.out.println("A program lefutott");
       
    }
}

