import java.io.*;
import java.util.*;
public class Main {
    static String s1 = "";
    public static  String disp2(){
        String str="";
        int a= (int) (65 + (Math.random() * 25));
        char c=(char)a;
        str=(c+"");
        int len=(int)(5+(Math.random()*10));
        for(int i=0;i<len;i++)
        {
            a= (int) (97 + (Math.random() * 25));
            c=(char)a;
            str+=(c+"");
        }
         len=(int)(5+(Math.random()*10));
        for(int i=0;i<len;i++)
        {
            a= (int) (0 + (Math.random() * 9));
            c=(char)('0'+a);
            str+=(c+"");
        }
        String[] str2={"@","#","$","%","&"};
        len=(int)(5+(Math.random()*10));
        for(int i=0;i<len;i++)
        {
            a= (int) (0 + (Math.random() * 4));
            str+=str2[a];
        }
        if(!disp1(str))
        {
            disp2();
        }
        return str;

    }
    public static boolean disp1(String pass){
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);


        String filePath = currentDir+"/src/sheik.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if(pass.equals(line)){
                    System.err.println("ur password is used by someone");
                    s1="ur password is used by someone";
                    return false;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        s1="";
        return true;
    }
    public static boolean disp() {

        Scanner sc = new Scanner(System.in);
        if (s1.length() > 0) {
            System.out.println("Reenter your Password");
        } else {
            System.out.println("enter your Password");
        }
        String pass = sc.next();
        if (pass.length() < 12) {
            System.err.println("password should contains atleast 12 characters");
            s1 = "password should contains atleast 12 characters";
            return false;
        } else if (!Character.isLetter(pass.charAt(0))) {
            System.err.println("password should start with characters only");
            s1 = "password should start with characters only";
            return false;
        } else {
            int spe = 0;
            int num = 0;
            int alp = 0;
            for (int i = 0; i < pass.length(); i++) {
                char ch = pass.charAt(i);
                if (Character.isDigit(ch)) {
                    num++;
                } else if (Character.isUpperCase(ch)) {
                    alp++;
                } else if(!Character.isLetterOrDigit(ch)) {
                    spe++;
                }
            }
            if(spe==0){
                System.err.println("password should contains atleast 1 special character");
                s1 = "password should contains atleast 1 special character";
                return false;
            }
            else if(num==0){
                System.err.println("password should contains atleast 1 digit");
                s1 = "password should contains atleast 1 digit";
                return false;
            }
            else if(alp==0){
                System.err.println("password should contains atleast 1 upper case");
                s1 = "password should contains atleast 1 upper case";
                return false;
            }
            else{
                System.out.println("Thank You");
                s1="";
               return disp1(pass);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Enter Your Chioce:\n1.Type Your Password\n2.random password");
        int chi=0;
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        if(ch==1) {
            while (true) {
                boolean fest = disp();
               // System.err.println(s1);1
                if (fest) {
                    break;
                }
            }
        }
        else{
            System.out.println(disp2());
        }
    }
}