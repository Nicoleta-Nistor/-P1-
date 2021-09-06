import java.util.ArrayList;
import java.util.Scanner;

public class GuestsList{
	private final ArrayList<Guest> list;
	private final ArrayList<Guest> waitingList;
	private final int maxNoOfGuests;
	private ArrayList<Guest> partialSearchResult;
	
	public GuestsList(int maxNoOfGuests) {
		this.list = new ArrayList<>();
		this.waitingList = new ArrayList<>();
		this.maxNoOfGuests = maxNoOfGuests;
		this.partialSearchResult = new ArrayList<>();
	}

	public int addGuest(int searchOption, Guest newGuest) {
		if(searchGuest(searchOption) != null) {
			System.out.println("Persoana nu a putut fi inscrisa la eveniment deoarece exista"
					         + " deja o persoana inscrisa cu datele aferente criteriului de cautare");
			return -1;
		}
		
		if(list.size() < this.maxNoOfGuests) {
			list.add(newGuest);
			System.out.println("[" +newGuest.getLastName() +" " + newGuest.getFirstName()
							+ "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 0;
		}
		
		this.waitingList.add(newGuest);
		System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " 
						+ this.waitingList.size() + ". Te vom notifica daca un loc devine disponibil.");
		return waitingList.size();
	}

	public Guest searchGuest(int searchOption) {
		if(searchOption < 1 || searchOption > 3) {
			System.out.println("Numarul introdus nu corespunde unei optiuni de cautare."
					+ "Introduceti unul din numerele corespunzatoare criteriilor de cautare:"
					+ "\n\t1.nume si prenume"
					+ "\n\t2.email"
					+ "\n\t3.numar de telefon");
		return null;
		}

		Scanner sc = new Scanner(System.in);
		switch(searchOption) {
			case 1: System.out.println("Introduceti numele dupa care doriti sa faceti cautarea");
					String lastName = sc.next();
					System.out.println("Introduceti prenumele dupa care doriti sa faceti cautarea");
					String firstName = sc.next();
					return searchByName(firstName, lastName); 
				
			case 2: System.out.println("Introduceti adresa de email dupa care doriti sa faceti cautarea");
					String email = sc.next();
					return (searchByEmail(email));
				
			case 3: System.out.println("Introduceti numarul de telefon dupa care doriti sa faceti cautarea");
					String phoneNumber = sc.next();
					return (searchByPhoneNumber(phoneNumber));
			}
		return null;
	}
	//metode auxiliare pentru cautare
	private Guest searchByName(String firstName, String lastName) {
		for(Guest guest : this.list)
			if(guest.getFirstName().equalsIgnoreCase(firstName) 
			&& guest.getLastName().equalsIgnoreCase(lastName)) {
				return this.list.get(list.indexOf(guest));
		}
		for(Guest guest : this.waitingList)
			if(guest.getFirstName().equalsIgnoreCase(firstName) 
			&& guest.getLastName().equalsIgnoreCase(lastName)) {
				return this.waitingList.get(waitingList.indexOf(guest));
			}
			return null;
		}
	
	private Guest searchByEmail(String email) {
		for(Guest guest : this.list)
			if(guest.getEmail().equalsIgnoreCase(email)) {
				return this.list.get(list.indexOf(guest));
			}
		for(Guest guest : this.waitingList)
			if(guest.getEmail().equalsIgnoreCase(email)) {
				return this.waitingList.get(waitingList.indexOf(guest));
			}
		return null;
	}
	
	private Guest searchByPhoneNumber(String phoneNumber) {
		for(Guest guest : this.list)
			if(guest.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
				return this.list.get(list.indexOf(guest));
			}
		for(Guest guest : this.waitingList)
			if(guest.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
				return this.waitingList.get(waitingList.indexOf(guest));
			}
		return null;
	}

	public boolean removeGuest(int searchOption) {
		Guest guestToRemove = searchGuest(searchOption);
		if(guestToRemove != null) {
			if(this.waitingList.remove(guestToRemove)) {
				System.out.println("Persoana a fost stearsa din lista de asteptare fara a fi inscrisa la eveniment.");
				return true;
			}
			if(this.list.remove(guestToRemove)) {
				System.out.println("Persoana a fost stearsa cu succes");
				if(this.waitingList.size() != 0) {
					this.list.add(this.waitingList.get(0));
					this.waitingList.remove(0);
					System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");	
				}
				return true;
			}
		}
		System.out.println("eroare: persoana nu era inscrisa");
		return false;
	} 
	
	public void updateInfoGuest(int searchOption) {
		Guest guestToUpdate = searchGuest(searchOption);
		if(guestToUpdate != null) {
			System.out.println("Alegeti campul care trebuie actualizat:"
					+ "\n\t1.lastName"
					+ "\n\t2.firstName"
					+ "\n\t3.email"
					+ "\n\t4.phoneNumber");
			Scanner sc = new Scanner(System.in);
			int updateOption = sc.nextInt();
			System.out.println("Introduceti noua valoare pentru campul ales");
			String newInfo = sc.next();
			
			switch(updateOption) {
				case 1: guestToUpdate.setLastName(newInfo);
					break;
				case 2: guestToUpdate.setFirstName(newInfo);
					break;
				case 3: guestToUpdate.setEmail(newInfo);
					break;
				case 4: guestToUpdate.setPhoneNumber(newInfo);
					break;
			}
		}
	}
	
	public void showList() {
		if(this.list.isEmpty()) {
			System.out.println("Niciun participant inscris…");
		}
		for(int i = 0; i < this.list.size(); i++) {
			System.out.println((i + 1) + ".Nume: " + this.list.get(i).getFirstName()+ " "+  this.list.get(i).getLastName()
					+ ", Email: " + this.list.get(i).getEmail() + ", Telefon: " + this.list.get(i).getPhoneNumber());
		}
	}
	
	public void showWaintingList() {
		if(this.waitingList.isEmpty()) {
			System.out.println("Lista de asteptare este goala…");
		}
		for(int i = 0; i < this.waitingList.size(); i++) {
			System.out.println((i + 1) + ".Nume: " + this.waitingList.get(i).getFirstName() + " " + waitingList.get(i).getLastName()
					+", Email: " + this.waitingList.get(i).getEmail() + ", Telefon: " + this.waitingList.get(i).getPhoneNumber());
		}
	}
	
	public int showFreeSpots() {
		return this.maxNoOfGuests - this.list.size();
	}
	
	public int showNoOfGuests() {
		return this.list.size();
	}
	
	public int showNoOfPeopleWaiting() {
		return this.waitingList.size();
	}
	
	public int showNoOfPeopleTotal() {
		return this.waitingList.size() + this.list.size();
	}
	
	public ArrayList<Guest> partialSearch(String subsequence){
		this.partialSearchResult.clear();
		
		for(Guest guest: this.list) {
			if(guest.getFirstName().toLowerCase().contains(subsequence.toLowerCase())
				|| guest.getLastName().toLowerCase().contains(subsequence.toLowerCase())
				|| guest.getEmail().toLowerCase().contains(subsequence.toLowerCase())
				|| guest.getPhoneNumber().toLowerCase().contains(subsequence.toLowerCase())) {
				this.partialSearchResult.add(guest);
				System.out.println(guest.getFirstName() + " " +  guest.getLastName());
			}
		}
		return this.partialSearchResult;
	}

}
