/**
 * 
 * @author 22ddowlin @version 10/16/2021
 *	Purpose: Creates a VignereTable that can be used to encrypt with auto-generated key and 
 */
public class VigenereTable 
{
	private final char[][] arr;
	private String autoKey;

	//creates table and key
	public VigenereTable()
	{
		arr = new char[26][26];
		autoKey = null;
		fillArray();
	}
	
	/**
	 * fills VignereTable
	 */
	private void fillArray()
	{
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String first = "";
		
		for(int x = 0; x < 26; x++)
		{
			for(int y = 0; y < 26; y++)
			{
				arr[x][y] = letters.charAt(y);  //use y because it will go through the string
			}
			first = letters.charAt(0) + "";  // get the first character in the string
			letters = letters.substring(1) + first;	
		}
	}
	
	/**
	 * Encrypts a message with a keyword that generates an autokey and stores the key in the class
	 * @param Message to be encrypted
	 * @param New keyword which will be used to generate an autokey
	 * @return Encrypted Text
	 */
	public String encryptWithAutoKey(String message, String newKeyword)
	{
		String encryptedText = "";
		
		String plainText = message;
		plainText = plainText.toUpperCase().replaceAll(" ", "").replaceAll("\\p{Punct}", "");
		
		autoKey = (newKeyword.toUpperCase().replaceAll(" ", "").replaceAll("\\p{Punct}", "") + plainText).substring(0, plainText.length());
		
		for (int i = 0; i < plainText.length(); i++)
		{
			encryptedText+= arr[plainText.charAt(i)-65][autoKey.charAt(i)-65];
		}
		return encryptedText;
	}
	
	/**
	 * Decrypts ciphered text with given key (not keyword which is used to make the key)
	 * @param Ciphered Text
	 * @param Key
	 * @return Decrypted Text
	 */
	public String decrypt(String cipherText, String key)
	{
		String decryptedText = "";

		for (int i = 0; i < cipherText.length(); i++)
		{
			for (int j = 0; j < 26; j++)
			{
				if (arr[j][key.charAt(i)-65] == cipherText.charAt(i))
				{
					decryptedText += arr[j][0];
					break;
				}
			}
		}
		
		return decryptedText;
	}
	
	/**
	 * 
	 * @return key
	 */
	public String getAutoKey()
	{
		return autoKey;
	}
	
	public String toString()
	{
		String str = "";
		
		for( int x = 0; x < 26; x++)
		{
			for(int y = 0; y < 26; y++)
			{
				str+=(arr[x][y] + " "); 
			}
			str+="\n";
		}	
		
		return str;
	}
}
