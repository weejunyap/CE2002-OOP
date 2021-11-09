
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class staff {
    private int staffid;
    private String name;
    private String position;
    private String username;
    private String password;
    private static Scanner x;
    
    public staff(){}
   
   

    public void hire(int staff_ID, String Name, String Position, String Username, String Password){
        staffid = staff_ID;
        name = Name;
        position = Position;
        username = Username;
        password = Password;
        
       
        try{
            FileWriter fw = new FileWriter ("loginPassword.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println (name+","+username+","+password);
            pw.flush();
            pw.close();
            System.out.println("done!");
        }
        catch(Exception e){
            System.out.println("Try again!");
        }
        try{
            FileWriter fw = new FileWriter ("staffroster.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println (staffid+","+name+","+position);
            pw.flush();
            pw.close();
            System.out.println("done!");
        }
        catch(Exception e){
            System.out.println("Try again!");
        }
    }
    public static void fire(String  Name){
        String name_fire = Name;
        
        String tempFile = "temp.csv";
        File oldFile = new File("loginPassword.csv");
        File newFile = new File(tempFile);
        String Usern = ""; String pass = ""; String tempname="";
        try{
            FileWriter fw = new FileWriter(tempFile, true );
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File("loginPassword.csv"));
            x.useDelimiter("[,\n]");

            while(x.hasNext()){
                tempname = x.next();
                Usern = x.next();
                pass= x.next();
                if (tempname != name_fire ){
                    pw.println(tempname+","+Usern+","+pass);
                }
            }
           x.close();
           pw.flush();
           pw.close();
           oldFile.delete();
           File dump = new File("loginPassword.csv");
           newFile.renameTo(dump);
        }
        catch(Exception e){
            System.out.println("please try again");
        }
        String tempFile2 = "temp.csv";
        File oldFile2 = new File("staffroster.csv");
        File newFile2 = new File(tempFile);
        int ID = 0; String name = ""; String position = "";
        try{
            FileWriter fw = new FileWriter(tempFile2, true );
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File("staffroster.csv"));
            x.useDelimiter("[,\n]");

            while(x.hasNext()){
                ID = x.nextInt();
                name = x.next();
                position = x.next();
                if (name != name_fire ){
                    pw.println(ID+","+name+","+position);
                }
            }
           x.close();
           pw.flush();
           pw.close();
           oldFile2.delete();
           File dump = new File("staffroster.csv");
           newFile2.renameTo(dump);
        }
        catch(Exception e){
            System.out.println("please try again");
        }
    }

 }
 