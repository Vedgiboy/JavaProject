


public class PrimMST {

		private static int[][] Adjmatrix; // Naboskapsmatrise
	   boolean []Reached; // Markerer om noden er nådd/besøkt
	   private int Node; // AntallNoder
	   private  static int INF=Integer.MAX_VALUE; // Infinite verdi ingen kant mellom Noder.
	  
	   // For TotalKostnad av noder
	
	   
	   public PrimMST() {
		   
		   Adjmatrix=new int[][] { { INF, 8, 10, 13, INF, INF, INF},// Matrise 2darray
				    			   { 8, INF, INF, 16, INF, INF, INF },
				    				{ 10, INF,INF ,14, INF, 12, INF },
				    				{ 16, INF, 14, INF, 15, INF, 11},
				    				{ INF, INF, INF, 15, INF, 5, 6 },
				    				{ INF, INF, 12, INF, 5, INF, 7 },
				    				{ INF, INF, INF, 11, 6, 7, INF } 
				    				};
		   
		   
	
	}

	   
	   public static void DisplayMatrix() {
		   
		   for(int i=0; i<7;i++) { // Løkke for Nodene  Row og 
			 for(int j=0;j<7;j++)  //COL
				 if(Adjmatrix[i][j]<INF) // For at den skal vite hvor Den skal skrive ut I
					 
					 System.out.print(" "+Adjmatrix[i][j]+" "+"\t");
				 else 
						System.out.print(" I "+"\t"); // Skriver ut I der det er INF
						
			 System.out.println(" ");
					 }
				 }
			 
	 
    // For startNoden
	public void start(int key) { 
		// For første valg
		int Total = 0; // For total cost
	    Node = Adjmatrix.length;
		
	    Reached = new boolean[Node]; // Nodene som false holder oversikt
		
	    
	    // Inisialiserer den første noden valgt, siden det kun er en node på dette tidspunktet, er weight til de andre nodene min
	    //path er også initialisert
		int[] weight = new int[Node];
		int[] path = new int[Node]; // Brukes for å holde oversikt over Rettning nådd

		for (int i = 0; i < Node; i++) {

			weight[i] = Adjmatrix[key][i]; // Hvilken rad som velges Weight er de tallene som ikke er Inf dvs 0 som ikke
											// har noen kobling til  Noder i de andre radene, Dette sorteres lenger nede i koden Min>MaxInt
			
			path[i] = key; // Bruker velger rad fra hvor

	
		
		}

		Reached[key] = true; // Setter inntastet som besøkt
  
		

		for(int ii=0;ii <Node;ii++) { //Ytterste løkke utfører for alle de andre som ikke er funnet og utskrift

		
		int index = -1;
		int min=Integer.MAX_VALUE;// Min Er max verdi
		
		
		for (int j = 0; j < Node; j++) {

			//Finner minste  verdi av weight for at noden skal legges til arr
			if (!Reached[j] && weight[j] < min) {// Oppdaterer min

				min = weight[j]; // HOoder verdiene som er min, Noen har flere rettninger grafen kan spenne ut 
				index = j; // Holdr posisjonsalternativene , kan være flere, for eks velger du 0 , kan det være  kolonne 3,eller 5 den går til neste
		
	
			
			}
		}
			// Hver gang en node legges til må veight oppdateres, for å se om vekten er den minste til
			// hver node.
            // Sikkring for å finne den noden som har minst vekt av de lagret ovenfor
			for (int j = 0; j < Node; j++) {
			
				// 
				if (!Reached[j] && Adjmatrix[index][j] < weight[j]) {// Sjekker om weight har noen Noder som er større en, 
																				//de som allerede er lagret i weight// Resterende som er igjen
																

					
					weight[j] = Adjmatrix[index][j]; // Oppdaterer
					
					path[j] = index;  // For path
			
		

			
			}
		}
				if (index >= 0) {// Hvis index er større eller lik 0

					Reached[index] = true;//setter som besøkt
					
					System.out.println(     // Noden den kom fra  //Noden den skal til       //Weight
							"HUS " + path[index] + " ------>  " + "HUS " + index + " PRIS " + weight[index] + " 000 "+ "\n"+"Kostnad sammenlagt= "
					+(Total+=weight[index])+"000"+"\n");

	
					
					ii=0;// Resetter Ytterløkken, for at swithc menyen skal kunne gå igjen
				
					Total+=weight[index]=0; //Resetter totalCost
			
				}	
		
		} 
	}
}