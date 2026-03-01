import java.util.*;
import java.net.*;
import java.io.*;

public class Converter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Currency Converter");

        System.out.print("Enter base currency (like USD): ");
        String from = sc.next().toUpperCase();

        System.out.print("Enter target currency (like INR): ");
        String to = sc.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        try {

           
            String link = "https://api.frankfurter.app/latest?from=" 
                          + from + "&to=" + to;

            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String line;
            String result = "";

            while ((line = br.readLine()) != null) {
                result = result + line;
            }

            br.close();

            
            int start = result.indexOf(to);
            
            if (start != -1) {
                String temp = result.substring(start + 5);
                String rateStr = temp.split("}")[0];
                double rate = Double.parseDouble(rateStr);

                double finalAmount = amount * rate;

                System.out.println("Converted Amount: " + finalAmount + " " + to);
            } 
            else {
                System.out.println("Currency not found.");
            }

        } 
        catch (Exception e) {
            System.out.println("Error connecting to server.");
        }

        sc.close();
    }
}