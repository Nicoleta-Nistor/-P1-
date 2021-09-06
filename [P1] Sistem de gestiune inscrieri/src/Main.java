import java.util.Scanner;

public class Main {
	public static void displaySearchOption() {
		System.out.println("Alegeti optiunea dupa care se face cautarea"
		 			+ "\n\t1.nume si prenume"
		 			+ "\n\t2.email"
		 			+ "\n\t3.numar de telefon");
	}
	public static void displayHelp() {
		System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
		int maxNoOfGuests = sc.nextInt();
		GuestsList guestsList = new GuestsList(maxNoOfGuests);
		displayHelp();
		String command = sc.next();
		
		while(!command.equals("quit")) {
			switch(command) {
			 case "help": System.out.println( "\nadd 	     - Adauga o noua persoana (inscriere)"
					 					  + "\ncheck        - Verifica daca o persoana este inscrisa la eveniment"
					 					  + "\nremove       - Sterge o persoana existenta din lista"
					 					  + "\nupdate       - Actualizeaza detaliile unei persoane"
					 					  + "\nguests       - Lista de persoane care participa la eveniment"
					 					  + "\nwaitlist     - Persoanele din lista de asteptare"
					 					  + "\navailable    - Numarul de locuri libere"
					 					  + "\nguests_no    - Numarul de persoane care participa la eveniment"
					 					  + "\nwaitlist_no  - Numarul de persoane din lista de asteptare"
					 					  + "\nsubscribe_no - Numarul total de persoane inscrise"
					 					  + "\nsearch       - Cauta toti invitatii conform sirului de caractere introdus"
					 					  + "\nquit         - Inchide aplicatia");
			 			  displayHelp();
			 			  command = sc.next();
			              break;
			 			
			 case "add": System.out.println("Se adauga o noua persoana…");
			 		     System.out.println("Introduceti numele de familie:");
			 		     String lastName = sc.next();
			 		     System.out.println("Introduceti prenumele:");
			 		     String firstName = sc.next();
			 		     System.out.println("Introduceti email:");
			 		     String email = sc.next();
			 		     System.out.println("Introduceti numar de telefon (format „+40733386463“)");
			 		     String phoneNumber = sc.next();
			 		    
			 		     Guest guest = new Guest(lastName, firstName, email, phoneNumber);
			 		     if(guest.getFirstName() == null || guest.getLastName()    == null
			 		   	 || guest.getEmail()     == null || guest.getPhoneNumber() == null) {
			 		    	System.out.println("Datele introduse contin campuri invalide.");
			 		    	displayHelp();
			 		    	command = sc.next();
			 		    	break;
			 		     }
			 		     
			 		     displaySearchOption();
			 		 	 int searchOption = sc.nextInt();
			 		     guestsList.addGuest(searchOption, guest);
			 		     displayHelp();
			 		     command = sc.next();
			 		     break;
			 
			 case"check": displaySearchOption();
			 			searchOption = sc.nextInt();
			 			if(guestsList.searchGuest(searchOption) != null) {
			 				System.out.println("Persoana este inscrisa la eveniment (lista participanti sau lista asteptare)");
			 			}else {
			 				System.out.println("Persoana nu a fost inscrisa pe lista de participanti sau pe lista asteptare");
			 			}
			 			displayHelp();
			 			command = sc.next();
			 			break;
			 			
			 case "remove": displaySearchOption();
	 					searchOption = sc.nextInt();
	 					guestsList.removeGuest(searchOption);
	 					displayHelp();
	 					command = sc.next();
				 		break;
				 		
			 case"update": displaySearchOption();
			 			searchOption = sc.nextInt();
			 			guestsList.updateInfoGuest(searchOption);
			 			displayHelp();
			 			command = sc.next();
			 			break;
			 			
			 case "guests": guestsList.showList();
			 			displayHelp();
			 			command = sc.next();
			 			break;
			 			
			 case"waitlist": guestsList.showWaintingList();
			 			displayHelp();
			 			command = sc.next();
			 			break;
			 			
			 case"available":System.out.println("Numarul de locuri ramase: " + guestsList.showFreeSpots());
			 			displayHelp();
			 			command = sc.next();
			 			break;
			 			
			 case"guests_no":System.out.println("Numarul de participanti: " + guestsList.showNoOfGuests());
			 			displayHelp();
			 			command = sc.next();
			 			break;
			 			
			 case"waitlist_no":System.out.println("Dimensiunea listei de asteptare: " + guestsList.showNoOfPeopleWaiting());
			 			displayHelp();
			 			command = sc.next();
			 			break;
			 			
			 case"subscribe_no":System.out.println("Numarul total de persoane: " + guestsList.showNoOfPeopleTotal());
			 			displayHelp();
			 			command = sc.next();
			 			break;
			 			
			 case"search":System.out.println("Introduceti subsirul de caractere dupa care doriti sa realizati cautarea");
			 			String subsequenece = sc.next();
			 			guestsList.partialSearch(subsequenece);
			 			displayHelp();
			 			command = sc.next();
			 			break;
			 			
			 default: System.out.println("Comanda introdusa nu exista in lista de comenzi.");
			 		  displayHelp();
			 		  command = sc.next();
			}

		}
		sc.close();
	}

}
