#include <iostream>

using namespace std;

void welcome(){		//funkcja drukujaca "powitanie" programu
	cout
		<< "                                            "	<< endl
		<< "  .----..-.-.-..-..-..-..---..---. .-..-..-."	<< endl
		<< "  | || || | | || .` || |`| |'| |-< | | >  < "	<< endl
		<< "  `----'`-'-'-'`-'`-'`-' `-' `-'`-'`-''-'`-`"	<< endl
		<< "                                            "	<< endl
		<< "          +-+-+-+-+ +-+-+-+-+-+-+"				<< endl
		<< "          |B|a|z|a| |D|a|n|y|c|h|"				<< endl
		<< "          +-+-+-+-+ +-+-+-+-+-+-+"				<< endl
		<< "								 "				<< endl;

}
void mainMenu(int &opcja){		// funkcja wyswietlajaca menu glowne programu oraz pobierajaca wybrana opcje z klawiatury
	cout << "Menu glowne:" << endl
		<< "1. Zaladuj wzorce do programu." << endl
		<< "2. Wprowadz nowa postac." << endl
		<< "3. Wyswietl liste dostepnych obcych." << endl
		<< "4. Przygotuj nowego obcego z polaczenia juz istniejacych." << endl
		<< "5. Zachowaj dotychczasowe wyniki eksperymentow." << endl
		<< "6. Zakoncz." << endl << endl
		<< "Wybierz opcje (1-6): ";
	do {
		cin >> opcja;
		if ((opcja < 1) || (opcja > 6))
			cout << "Error: nieznana opcja. Sprobuj ponownie." << endl;
	} while ((opcja < 1) || (opcja > 6));
}
void wczytajWzorce(){
	;
}

void wprowadzNowa(){
	;
}

void wyswietlListe(){
	;
}

void kombinujObcych(){
	;
}

void zapiszWzorce(){
	;
}

int main () {
	welcome();
	int opcja;
	mainMenu(opcja);
	switch (opcja){		// przejscie do wybranej opcji z menu glownego
		case 1: wczytajWzorce(); break;
		case 2: wprowadzNowa(); break;
		case 3: wyswietlListe(); break;
		case 4: kombinujObcych(); break;
		case 5: zapiszWzorce(); break;
		case 6: system("cls"); exit; break;
	}


}