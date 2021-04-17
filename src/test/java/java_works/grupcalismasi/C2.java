package java_works.grupcalismasi;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C2 {
    public static void main(String[] args) {
        String[][] arr={{"A","B","C"},{"D","E"}};
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
               // System.out.print(arr[i][j]);
                if(arr[i][j].equals("B")){
                    continue;
                }
            }
            continue;
            //icteki continue icteki foru basa alir distaki continie distaki foru basa alir
            // for un altinda herhangi bisey olsa hic alta inmez
        }
        String str="Sweat Sweat";
        String str2=str.trim().charAt(6) + " " + str.indexOf("Sw",1);
      //  System.out.println(str2);



        StringBuilder sb1=new StringBuilder("Duke");
        String str3=sb1.toString();
       // System.out.println(sb1==str3);

       


    }
}
