import java.util.Scanner;

public class PrimMainProg {

	public static void main(String[] args) {

		
		int choice;
		PrimMST prim = new PrimMST();
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.print("Dette er et program som finner billigste vei  for å legge kabler mellom 7 hus");

		String menu = " MENY"

				+ "\n (1) Få en kostnad og vei for kabelegging"  // Menyvalg
				+ "\n (2) Se Nabotabell "
		        + "\n (3) Avslutt program";
		
		do { // Start på do while løkken.

			try {// start på try catch

				System.out.println(menu);

				choice = scan.nextInt(); // Input fra bruker

				switch (choice) { // Switch for å velge mellom de fem alternativene i menyen

				case 1:
					
					System.out.println("Velg et hus du vil starte fra ,Husnummer starter fra 0-6"); // Skriver ut for hus
					
					int Valg = scan.nextInt(); // Noden som velges
					
					prim.start(Valg);// Posisjon i array som det skal startes fra
					
					break;
				
				
				case 2:
					System.out.println(" I Tilsvarer uendelig dvs ingen vei Mellom husene");
					PrimMST.DisplayMatrix();// For display av node
					break;
				
				
				default:

					if (choice == 3) { // For og avslutte tallet og fange opp om bruker taster inn et annet tall enn alternativene i menyen
						System.out.println("Du har avsluttet programmet"); 
					} else {
						System.out.println("Velg 1, 2,eller 3 \n");
					}
				}

			} catch (Exception e) {
				System.out.println("Du kan kun taste inn tall" + "\n");
				choice = scan.next().charAt(0); // Bruker en try catch funksjon for å fange hvis noe annet en tall
												// tastes inn

			}
		} while (choice != 3); // Do While løkke som går så lenge bruker ikke taster inn 0.

	}
}