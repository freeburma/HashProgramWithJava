/*
	This program will calculate the check sums.

	Some of the codes are directly copied from the StackOverflow websites with 
	researches. 
	
	To export to *.jar file. 
		$ jar cfe <FileName>.jar Main <FileName>.java
		
	Exporting Manifest 
		$ jar xf <FileName>.jar
*/

import java.math.BigInteger; 

import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Paths; 

import java.security.MessageDigest; 

import java.util.Scanner; 

// Exception classes 
import java.security.NoSuchAlgorithmException; 
import java.io.IOException; 
import java.io.UnsupportedEncodingException; 


public class CheckSums 
{
	private String DigestHashString (String text, String alogrithm) throws NoSuchAlgorithmException, UnsupportedEncodingException, RuntimeException, IOException
	{
		MessageDigest dg = MessageDigest.getInstance(alogrithm); 
		dg.update(StandardCharsets.UTF_8.encode(text)); 
		
		return bytesToHex(dg.digest()); 
	}// end DigestHashString ()
	
	private String DigestHashFile (String filePath, String alogrithm) throws NoSuchAlgorithmException, UnsupportedEncodingException, RuntimeException, IOException
	{
		MessageDigest dg = MessageDigest.getInstance(alogrithm); 
		dg.update(Files.readAllBytes(Paths.get(filePath))); 
		
		return bytesToHex(dg.digest()); 
	}// end DigestHashString ()
	
	
	/*
		This method is directly retrieved from StackOverflow website. 
		
	*/
	private String bytesToHex (byte[] digest)
	{
		StringBuffer result = new StringBuffer (); 
		
		for (byte b: digest)
		{
			result.append(Integer.toString((b & 0xFF) + 0x100, 16).substring(1)); 
		}
		
		return result.toString(); 
		
	}// end bytesToHex()
	
	  
	
	public static void main (String [] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, RuntimeException, IOException
	{
		CheckSums app = new CheckSums (); 
		
		System.out.println ("This program will calculate the checksum using command line." + 
		"You can calculate both text and file"); 
		System.out.println ("Ctrl + C for exit "); 
		System.out.println ("Type -h or help for help"); 
		
		// Getting the user input
		Scanner reader = new Scanner(System.in); 
		
		
		 
		System.out.println("1. Text String Hash");  
		System.out.println("2. File Path Hash");  
			
		while (true)
		{
			
			
			System.out.print("\nChoose the menu : "); 
			String menu = reader.nextLine(); 
			
			switch (menu)
			{
				case "1": 
					System.out.println ("Ctrl + C for exit ");
					System.out.println("1. Text String Hash");  
					
					// Getting the input
					System.out.print("\nEnter the text to hash: "); 
					String text = reader.nextLine();
					
					// Executing to hash
					// System.out.println ("Test    >> " + app.DigestHashString("Hello", "MD5"));
					System.out.println ("MD5     >> " + app.DigestHashString(text, "MD5"));
					System.out.println ("SHA-1   >> " + app.DigestHashString(text, "SHA-1"));
					System.out.println ("SHA-256 >> " + app.DigestHashString(text, "SHA-256"));
					System.out.println ("SHA-384 >> " + app.DigestHashString(text, "SHA-384"));
					System.out.println ("SHA-512 >> " + app.DigestHashString(text, "SHA-512"));
					
					break; 	
				
				case "2": 
					System.out.println ("Ctrl + C for exit ");
					System.out.println("2. File Path Hash");  
					
					// Getting the input
					System.out.println("\nExample Full file path: \n" + 
					"C:\\Users\\User\\Desktop\\tmp\\Example.txt"); 
					
					System.out.print("\nEnter the full file path to hash: "); 
					String filePath = reader.nextLine();
					
					// System.out.println (">>         " + app.DigestHashFile("CheckSums.java", "MD5"));
					System.out.println ("MD5     >> " + app.DigestHashFile(filePath, "MD5"));
					System.out.println ("SHA-1   >> " + app.DigestHashFile(filePath, "SHA-1"));
					System.out.println ("SHA-256 >> " + app.DigestHashFile(filePath, "SHA-256"));
					System.out.println ("SHA-384 >> " + app.DigestHashFile(filePath, "SHA-384"));
					System.out.println ("SHA-512 >> " + app.DigestHashFile(filePath, "SHA-512"));
					
					break; 
					
				case "-h" : 
					System.out.println ("Ctrl + C for exit ");
					System.out.println ("How to use the software");  
					System.out.println ("Menu 1: is hashing the text string.");
					System.out.println ("$ <Text> ");
					System.out.println ("\nTest with the following comment."); 
					System.out.println ("Hello"); 
					System.out.println ("You will get the following outputs: ");
					
					
					System.out.println ("How to use the software");  
					System.out.println ("Menu 2: is hashing the file.");
					System.out.println("\nExample Full file path: \n" + 
					"C:\\Users\\User\\Desktop\\tmp\\Example.txt"); 
					
					break;	
					
				default: 
					System.out.println("No menu found. \nPlease enter 1 or 2 ....");  
					break; 
			}
			
					
		}// end while 
		
		
		
		
	}// end main()

}// End Class