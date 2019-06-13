import java.util.Scanner;
import java.io.*;
public class reader{
    
    public void read(){
    System.out.print('\u000C');
    
    File f = new File("quiz responses.csv");
    try{
        Scanner input = new Scanner(f);
        int x=0;
        while(input.hasNext()){
            String str = input.nextLine();
            String[] ans = str.split(",");
            x=ans.length;
        }
        String[] anskey = new String[x];
        Scanner input2 = new Scanner(f);
        while(input2.hasNext()){           
            String str = input2.nextLine();
            String[] ans = str.split(",");
            int score=0;
            int total = ans.length-1;
            
            if(ans[0].equals("Answer Key")) anskey = ans.clone();
            for(int i=1; i<ans.length; i++){
                if(ans[i].equals(anskey[i])) score++;
            }
            System.out.println(ans[0] + " " + score + "/" + total);
            
        }
    }
    catch(FileNotFoundException e){
        e.printStackTrace();
    }
    
}

}