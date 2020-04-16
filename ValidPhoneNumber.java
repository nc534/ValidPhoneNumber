import java.util.Scanner;

public class ValidPhoneNumber {
	
	//int range: -2,147,483,648 to +2,147,483,647 (this made me mad)
	private static long longPhone;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a valid phone number in one of these formats: \n(###) ###-####\n(###)###-####\n###-###-####\n##########\n");
		
		String phone = sc.nextLine();
		
		check911(phone);
		
		sc.close();

	}
	
	public static boolean isValidNumber(String phone) {	
		
		StringBuilder newPhone = new StringBuilder(phone);
		
		if(phone.charAt(0) == '(' && phone.charAt(4) == ')' && phone.charAt(8) == '-' & phone.length() == 13) {
			newPhone.deleteCharAt(0);
			newPhone.deleteCharAt(4-1);
			newPhone.deleteCharAt(8-2);
			
			try {
				longPhone = Long.parseLong(newPhone.toString());
			}catch (NumberFormatException n){
					System.out.println("Only numbers and valid characters please.");
					return false;
			}
			
			return true;
		}
		
		if(phone.charAt(0) == '(' && phone.charAt(4) == ')' && phone.charAt(5) == ' ' &&phone.charAt(9) == '-' & phone.length() == 14) {
			newPhone.deleteCharAt(0);
			newPhone.deleteCharAt(4-1);
			newPhone.deleteCharAt(5-2);
			newPhone.deleteCharAt(9-3);
			
			try {
				longPhone = Long.parseLong(newPhone.toString());
			}catch (NumberFormatException n){
				System.out.println("Only numbers and valid characters please.");
				return false;
			}
			
			return true;
		}
		
		if(phone.charAt(3) == '-' && phone.charAt(7) == '-' && phone.length() == 12) {
			newPhone.deleteCharAt(3);
			newPhone.deleteCharAt(7-1);
			
			try {
				longPhone = Long.parseLong(newPhone.toString());
			}catch (NumberFormatException n){
					System.out.println("Only numbers and valid characters please.");
					return false;
			}
			
			return true;
		}
		
		if(phone.length() == 10) {
			
			try {
				longPhone = Long.parseLong(newPhone.toString());
			}catch (NumberFormatException n){
					System.out.println("Only numbers and valid characters please.");
					return false;
			}
			
			return true;
		}
		
		System.out.println("Not a valid phone number format");
		
		return false;
		
	}
	
	public static void check911(String phone) {
	
		boolean valid = isValidNumber(phone);
		
		boolean has911 = false;
		
		if(valid == true) {
		
			String stringPhone = Long.toString(longPhone);
			
			has911 = stringPhone.contains("911");
			
			if(has911 == true) {
				System.out.println("Phone number cannot have 911 in it.");
			}else {
				System.out.println("[ " + phone + " ] is valid phone number.");
			}
			
			
		}
		
	}

}
