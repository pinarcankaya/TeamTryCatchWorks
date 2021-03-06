package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadTxt {

    //    public static List<Customer> returnCustomer(String filePath){
//        List<Customer>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(ConfigurationReader.getProperty(filePath)))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            while (line != null) {
//                Customer customer = new Customer();
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                String [] each = line.split(",");
//                customer.setFirstName(each[0]);
//                customer.setLastName(each[1]);
//                customer.setSsn(each[2]);
//                all.add(customer);
//            }
//            String everything = sb.toString();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<Customer> returnCustomerSNN(String filePath){
//        List<Customer>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                Customer customer = new Customer();
//                customer.setSsn(line.split(",")[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(customer);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<Customer> readTxtData(String filePath)throws  Exception{
//        List<Customer> list = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new FileReader(filePath));
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            Customer customer = new Customer();
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
////                customer.setSsn(line);
//            }
//            String everything = sb.toString();
//            customer.setSsn(everything);
//            list.add(customer);
//        } finally {
//            br.close();
//        }
//        return list;
//    }
//    public static List<States> returnAllStates(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
////            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
////            System.out.println(line);
////            int i = 0;
//            while (line != null) {
//                States state = new States();
//                String [] allLine = line.split(",");
//                int id = Integer.parseInt(allLine[1].trim());
////                state.setId(id);
//                state.setName(allLine[0]);
////                sb.append(System.lineSeparator());
//                line = br.readLine();
////                System.out.println(i++);
//                all.add(state);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<String> returnCustomerSNNList(String filePath){
//        List<String>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                Customer customer = new Customer();
//                customer.setSsn(line.split(",")[0]);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//                System.out.println(i++);
//                all.add(customer.getSsn());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
//    public static List<States> returnAllStates2(String filePath){
//        List<States>all = new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            System.out.println(line);
//            int i = 0;
//            while (line != null) {
//                States states = new States();
//                states.setName(line.split(",")[0].trim());
////                states.setId(Integer.parseInt(line.split(",")[1].trim()));
////                sb.append(System.lineSeparator());
//                line = br.readLine();
////                System.out.println(i++);
//                all.add(states);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return all;
//    }
    public static List<String> returnAllStates3(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line); // read first line
            int i = 0;
            while (line != null) {
                String temp = "";
                temp =line.split(",")[2].trim();
//                sb.append(System.lineSeparator());
                line = br.readLine(); // while i dondurmek icin okutuyor
//                System.out.println(i++); // satir sayisi icin numara yazdirma
                all.add(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> returnListWithIndexNumber(String filePath,int index){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            System.out.println(line); // read first line
//            int i = 0;
            while (line != null) {
                String temp = "";
                temp =line.split(",")[index].trim();
//                sb.append(System.lineSeparator());
                line = br.readLine(); // while i dondurmek icin okutuyor
//                System.out.println(i++); // satir sayisi icin numara yazdirma
                all.add(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<Map<String,String>> returnListMapForDB(String filePath){
        List<Map<String,String>>  all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                Map<String,String> row = new HashMap<>();
                String value1,value2,value3 = ""; // Tek bir String [] ile de yapilabilir

                value1 =line.split(",")[0].trim();
                value2 =line.split(",")[1].trim();
                value3 =line.split(",")[2].trim();

                row.put("first_name",value1);
                row.put("last_name",value2);
                row.put("login",value3);

                line = br.readLine(); // while i dondurmek icin line okutuluyor.
                all.add(row);
                i++;
            }

            System.out.println("Total row count: " + i );
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<String> readTxt(String filePath){
        List<String>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {
                String temp = "";
                temp =line;
                line = br.readLine(); // while i dondurmek icin okutuyor
                all.add(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }
}