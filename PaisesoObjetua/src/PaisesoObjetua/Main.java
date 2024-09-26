package PaisesoObjetua;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Dataren Formatua ezarri

		do {
			ondosartuta = false;
			System.out.println("Aukeratu hurrengo ataletako bat :");
			System.out.println("1.- Erregistro guztiak erakutsi");
			System.out.println("2.- Kode Bidez Erregistroa Bilatu");
			System.out.println("3.- Bizi Esperantzaren batazbestekoa ikusi");
			System.out.println("4.- Poblazioaren batazbestekoa ikusi");
			System.out.println("5.- Erregistroak bi data artean bilatu");
			System.out.println("6.- Erregistro berri bat gehitu (Alta)");
			System.out.println("7.- Erregistro bat ezabatu kode bidez (Baja)");
			System.out.println("8.- Erakutsi demokrazia duten herrialdeak");
			System.out.println("9.- Erregistroak Hiriaren arabera ordenatu Alfabetikoki");
			System.out.println("10.- Irten");

			while (!ondosartuta) {
				System.out.print("Zuk aukeratutakoa: ");
				if (sc.hasNextInt()) {
					aukera = sc.nextInt();
					if (aukera >= 1 && aukera <= 10) {
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
							
						case 5:
							System.out.print("Sartu hasiera data (yyyy-MM-dd): ");
							String hasieraData = sc.next();
							System.out.print("Sartu bukaera data (yyyy-MM-dd): ");
							String bukaeraData = sc.next();

							try {
								LocalDate startData = LocalDate.parse(hasieraData, dateFormat);
								LocalDate endData = LocalDate.parse(bukaeraData, dateFormat);

								for (Paises p : paises) {
									LocalDate paisData = p.lortudata(); 
									if ((paisData.isAfter(startData) || paisData.isEqual(startData)) &&
											(paisData.isBefore(endData) || paisData.isEqual(endData))) {
										System.out.println(p);
									}
								}
							} catch (DateTimeParseException e) {
								System.out.println("Errorea: Data formatua ez da zuzena.");
							}
							break;
							
						case 6: 
							System.out.print("Sartu kodea: ");
							String newKodea = sc.next();

							System.out.print("Sartu izena (país): ");
							String izena = sc.next();

							System.out.print("Sartu kapitala: ");
							String kapitala = sc.next();

							System.out.print("Sartu populazioa: ");
							Double populazioa = sc.nextDouble();

							System.out.print("Sartu bizi esperantza: ");
							int biziEsperantza = sc.nextInt();

							System.out.print("Sartu sortze data (yyyy-MM-dd): ");
							String sortuData = sc.next();

							System.out.print("Demokrazia? (true/false): ");
							boolean demokrazia = sc.nextBoolean();

							try {
								LocalDate fecha = LocalDate.parse(sortuData, dateFormat);

								// Pais berri bat sortzen dugu eta gure Arraylist-era pasatzen dugu
								Paises paisBerria = new Paises(newKodea, izena, kapitala, populazioa, biziEsperantza, fecha, demokrazia);
								paises.add(paisBerria);
								System.out.println("Erregistroa ondo gehitu da.");

								//Dataren formatua konprobatzen du egokia den jakiteko
							} catch (DateTimeParseException e) {
								System.out.println("Errorea: Data formatua ez da zuzena.");
							}
							break;
							
						case 7: 
							System.out.print("Sartu kodea ezabatzeko: ");
							String bajaKodea = sc.next();
							boolean erregistroEzabatua = false;
							int indexToRemove = -1;

							for (int i = 0; i < paises.size(); i++) {
								if (paises.get(i).getPaissString().equals(bajaKodea)) {
									indexToRemove = i; 
									System.out.println("Aurkitutako erregistroa:");
									System.out.println(paises.get(i)); 
									break;
								}
							}

							if (indexToRemove != -1) {

								System.out.print("Ziur al zaude ezabatu nahi duzula? (bai/ez): ");
								String konfirmazioa = sc.next();

								if (konfirmazioa.equalsIgnoreCase("bai")) {
									paises.remove(indexToRemove);
									
									System.out.println("Erregistroa ezabatu da.");
									erregistroEzabatua = true;
								} else {
									System.out.println("Ezabatzeko prozesua bertan behera utzi da.");
								}
							} else {
								System.out.println("Kodea ez da aurkitu.");
							}
							break;
							
						case 8: 
							System.out.println("Demokrazia duten herrialdeak:");
							for (Paises p : paises) {
								if (p.isDemokrazioabool()) { 
									System.out.println(p);
								}
							}
							break;
							
						case 9: 
							Collections.sort(paises, Comparator.comparing(Paises::getPaissStringa));
							System.out.println("Erregistroak Hiriaren arabera ordenatu dira:");
							for (Paises p : paises) {
								System.out.println(p);
							}
							break;
							
						case 10:
							System.out.println("Irteten...");
							break;
						default:
							System.out.println("Aukera desegokia.");
						}
					} else {
						System.out.println("Errorea: Sartu baliozko aukera bat (1-10).");
					}
				} else {
					System.out.println("Errorea: Zenbaki bat sartu behar duzu.");
					sc.next();
				}
			}
		} while (aukera != 10);

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