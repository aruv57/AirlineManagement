package management;
import java.util.Arrays;
import java.util.Random;	  
	public class Genarate {
			   public static void main(String[] args) {

			    String a= generateOTP(5);  
			   }

			   public static String generateOTP(int length) {
			      String numbers = "1234567890";
			      Random random = new Random();
			      char[] otp = new char[length];

			      for(int i = 0; i< length ; i++) {
			         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
			      }
			         String string = new String(otp);
			       //  System.out.println(string);    
			      
			         return string;
			   }

				
			}