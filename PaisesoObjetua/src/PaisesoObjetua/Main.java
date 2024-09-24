package PaisesoObjetua;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ArrayList<Paises> paises = new ArrayList<>();


		paises.add(new Paises("31", "Holanda","Amsterdam", 15460000.00,78, LocalDate.of(1581, 7, 26),false ));

		paises.add(new Paises("376", "Andorra", "Andorra La Vieja",64000.00, 0, LocalDate.of(1993, 3, 14),true ));

		paises.add(new Paises("90", "Turquia","Ankara",61058000.00,67, LocalDate.of(1923, 10, 29),true  ));

		paises.add(new Paises("261", "Madagascar","Antananarivo",13651000.00, 52, LocalDate.of(1960, 6, 26),true ));

		paises.add(new Paises("685", "Samoa Occidental","Apia",165000.00, 68, LocalDate.of(1962, 1, 1),true  ));

		paises.add(new Paises("213", "Argelia","Argel", 27959000.00, 70, LocalDate.of(1962, 7, 5),true ));

		paises.add(new Paises("291", "Eritrea","Asmara", 3400000.00, 0, LocalDate.of(1993, 5, 24),false ));

		paises.add(new Paises("595", "Paraguay","Asuncion", 4828000.00, 68, LocalDate.of(1825, 8, 25),true ));

		paises.add(new Paises("30", "Grecia","Atenas",10467000.00, 78, LocalDate.of(1830, 2, 3), true));

		paises.add(new Paises("964", "Irak","Bagdad",20097000.00, 66, LocalDate.of(1958, 7, 14),false  ));



		try {
			menua(paises);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Menua.
	 *
	 * @param paises , gure erregistroko hiriak
	 * @throws Exception the exception
	 */
	public static void menua(ArrayList<Paises> paises) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean ondosartuta = false;
		int aukera = 0;

		do {
			ondosartuta = false;
			System.out.println("Aukeratu hurrengo ataletako bat :");
			System.out.println("1.- Erregistro guztiak erakutsi");
			System.out.println("2.- Kode Bidez Erregistroa Bilatu");
			System.out.println("3.- Bizi Esperantzaren batazbestekoa ikusi");
			System.out.println("4.- Poblazioaren batazbestekoa ikusi");
			System.out.println("9.- Irten");

			while (!ondosartuta) {
				System.out.print("Zuk aukeratutakoa: ");
				if (sc.hasNextInt()) {
					aukera = sc.nextInt();
					if (aukera >= 1 && aukera <= 9) {
						ondosartuta = true;
						switch (aukera) {
						case 1: 
							for (Paises p : paises) {
								System.out.println(p);
							}
							break;
						case 2:
							System.out.print("Sartu kodea: ");
							String kodea = sc.next();
							boolean kodeaAurkituta = false;
							for (Paises p : paises) {
								if (p.getPaissString().equals(kodea)) {
									System.out.println(p);
									kodeaAurkituta = true;
									break;
								}
							}
							if (!kodeaAurkituta) {
								System.out.println("Kodea ez da aurkitu.");
							}
							break;
						case 3:
							double biziMedia = kalkulatuBiziEsperantzaMedia(paises);
							System.out.println("Bizi Esperantzaren bataz bestekoa: " + biziMedia + " urte.");
							break;
						case 4:
							double pobMedia = kalkulatuPoblazioMedia(paises);
							System.out.println("Poblazioaren bataz bestekoa: " + pobMedia + " pertsona.");
							break;
						case 9:
							System.out.println("Irteten...");
							break;
						default:
							System.out.println("Aukera desegokia.");
						}
					} else {
						System.out.println("Errorea: Sartu baliozko aukera bat (1-9).");
					}
				} else {
					System.out.println("Errorea: Zenbaki bat sartu behar duzu.");
					sc.next(); 
				}
			}
		} while (aukera != 9);

		sc.close();
	}

	/**
	 * Kalkulatu bizi esperantza media.
	 *
	 * @param paises , gure erregistroko hiriak
	 * @return the double, bizi esperantza media
	 */
	public static double kalkulatuBiziEsperantzaMedia(ArrayList<Paises> paises) {
		int batura = 0;
		int kontatu = 0;
		for (Paises p : paises) {
			if (p.getBiziEsperantzakop() != 0) {
				batura += p.getBiziEsperantzakop();
				kontatu++;
			}
		}
		return kontatu > 0 ? (double) batura / kontatu : 0;
	}

	/**
	 * Kalkulatu poblazio media.
	 *
	 * @param paises , erregistroko hiriak
	 * @return the double, poblazioaren media
	 */
	public static double kalkulatuPoblazioMedia(ArrayList<Paises> paises) {
		double batura = 0;
		for (Paises p : paises) {
			batura += p.getPoblazioaDouble();
		}
		return paises.size() > 0 ? batura / paises.size() : 0;
	}
}