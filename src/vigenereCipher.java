import java.util.Scanner;

public class vigenereCipher 
{
	public static void main(String[] args) 
	{
		VigenereTable vt = new VigenereTable();
		System.out.println("Vignere Table: \n" + vt.toString());
		
		Scanner sc = new Scanner(System.in);
		
		boolean numTest = false;
		

		String message = "";
		String keyword = "";
		
		String encryptedMessage = "";
		
		while (!numTest)
		{
			numTest = true;
			
			System.out.println("Enter a message to be encrypted(no numerical values): ");
			message = sc.nextLine();
			
			System.out.println("Enter a KEYWORD to create an auto-key for the encryption: ");
			keyword = sc.nextLine();
			
			try 
			{
				encryptedMessage = vt.encryptWithAutoKey(message, keyword);
			} 
			catch (ArrayIndexOutOfBoundsException e)
			{
				numTest = false;
				System.out.println("Improper Input/no numbers");
			}
		}
		
		sc.close();
		
		
		System.out.println("Encrypted Text: " + encryptedMessage + " ( using autokey: " + vt.getAutoKey() + " )");
		
		System.out.println("Decrypted Text: " + vt.decrypt(encryptedMessage, vt.getAutoKey()));
	}

}
