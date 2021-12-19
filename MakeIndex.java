import java.io.PrintWriter;
import java.io.File;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Path;




public class MakeIndex {
    
    
    public static void index(File[] files,List<File> directories, List<File> images, List<File> html_files, Path path){
        String quote = '"'+"";
        
         File index = new File(files[0].getParentFile().getPath() + "/index.html");
 
         try {
             PrintWriter pr = new PrintWriter(index);
             pr.write("<html><h1>Start Page</h1> <hr><h2>Directories</h2> <a href=" + quote + index.getParentFile().getParentFile().getAbsolutePath() + "/index.html" + quote + ">" + quote + 
             "<<" + quote + "</a><br>");
             
             
         for(File file : directories){
                Path dir_path = file.getParentFile().toPath();
                
                pr.write( "<a href=" +quote + dir_path.relativize(file.toPath()) + "/index.html" + quote + ">" + file.getName() + "</a><br>");
                 
                 }
                 pr.write("<hr>"); 

         pr.write("<h2>Images</h2>");
                 int i = 0;

        for(File file : images){
                pr.write(" <a href=" + quote + html_files.get(i).getName()  + quote + ">" + file.getName() + "</a><br>");
                i++;
                }

        pr.write("<hr>");
        pr.close();

             }
         
             catch (Exception e) {
                 e.printStackTrace();
         }          
     
    }
}


