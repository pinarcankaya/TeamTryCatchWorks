package java_works.grupcalismasi;

public class C2 {
    public static void main(String[] args) {
        String[][] arr={{"A","B","C"},{"D","E"}};
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]);
                if(arr[i][j].equals("B")){
                    continue;
                }
            }
            continue;
            //icteki continue icteki foru basa alir distaki continie distaki foru basa alir
            // for un altinda herhangi bisey olsa hic alta inmez
        }
    }
}
