package java_works.grupcalismasi;

public class Argument_Parametre {


        public static void main(String[] args) {
            int x = 10;
            int y = 20;
            int sum = add(x, y); //x, y are arguments here
            System.out.println("SUM IS: " +sum);
            System.out.println(" " + (x+y)/2);
        }



    public static int add(int x, int y) { //x, y are parameters here
        return x + y;
    }


}

