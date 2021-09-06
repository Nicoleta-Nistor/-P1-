
public class Guest {
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	public Guest(String lastName,String firstName, String email,String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		
		if( email.contains("@") && email.contains(".com" ) || email.contains(".ro" )) {
			this.email = email;
		}else {
			System.out.println("Adresa de email introdusa este invalida.");
		}
		
		if(phoneNumber.length() == 12 && phoneNumber.startsWith("+407")) {
			this.phoneNumber = phoneNumber;
		}else {
			System.out.println("Numarul de telefon introdus este invalid.");
		}
	
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if( email.contains("@") && email.contains(".com" ) || email.contains(".ro" )) {
			this.email = email;
		}else {
			System.out.println("Adresa de email introdusa este invalida.");
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.length() == 12 && phoneNumber.startsWith("+407")) {
			this.phoneNumber = phoneNumber;
		}else {
			System.out.println("Numarul de telefon introdus este invalid.");
		}
	}
	
	
}
