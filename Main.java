import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    

      public static void makeIndex(File[] files,List<File> directories, List<File> images, List<File> html_files, Path path){
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

    public static void Makehtmlfiles(File[] files,String path){

        List<File> html_files = new ArrayList<File>();
        List<File> images = new ArrayList<File>();
        List<File> directories = new ArrayList<File>();



        for(File file : files){

            if(file.isDirectory()){

                directories.add(file);

                Makehtmlfiles(file.listFiles(),path);
            }

            else if(file.getName().endsWith(".jpg") || file.getName().endsWith(".png")){

                images.add(file);
                String filename = file.getName();
                String new_name =filename.substring(0,file.getName().length()-3) + "html";
                File html_file = new File(file.getParentFile().getPath() + "/" + new_name);
                html_files.add(html_file);


            }
        }


        for(int i = 0;i<html_files.size();i++){
            try{
                String quote = '"' + "";
                PrintWriter pr = new PrintWriter(html_files.get(i).getAbsolutePath());
                if(i>0 && i<html_files.size()-1){
                    pr.write("<html><h1>Start Page</h1> <hr> <a href=" + "index.html" + ">" + quote + "<<" + quote + "</a>" + "<br> <a href="+quote + html_files.get(i-1).getName()
                            + quote + ">" + quote + "<<" + quote + "</a>" + html_files.get(i).getName() +
                            "<a href=" + quote + html_files.get(i+1).getName() + quote + ">" + quote + ">>" + quote + "</a> <br>");
                    pr.write(" <a href=" + quote + html_files.get(i+1).getName() + quote  + ">  <img src=" + quote +
                            images.get(i).getName() + quote + "width = 400 size = 500 alt=></a>");
                    pr.close();
                }
                else if(i==0){
                    // System.out.println(html_files.get(i).getName());
                    pr.write("<html><h1>Start Page</h1> <hr> <a href=" + "index.html" + ">" + quote + "<<" + quote + "</a> <br>" +
                            html_files.get(i).getName() +
                            "<a href=" + quote + html_files.get(i+1).getName() + quote + ">" + quote + ">>" + quote + "</a> <br>");
                    pr.write(" <a href=" + quote + html_files.get(i+1).getName() + quote  + ">  <img src=" + quote +
                            images.get(i).getName() + quote + "width = 400 size = 500 alt=></a>");
                    pr.close();
                }
                else if(i==html_files.size()-1){
                    pr.write("<html><h1>Start Page</h1> <hr><a href=" + "index.html" + ">" + quote + "<<" +quote + "</a> <br> <a href="+quote + html_files.get(i-1).getName()
                            + quote + ">" + quote + "<<" + quote + "</a>" + html_files.get(i).getName());
                    pr.write("<br> <a href="  + ">  <img src=" + quote +
                            images.get(i).getName() + quote + "width = 400 size = 500 alt=></a>");
                    pr.close();
                }

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        makeIndex(files, directories, images, html_files,Paths.get(path));
    }

}