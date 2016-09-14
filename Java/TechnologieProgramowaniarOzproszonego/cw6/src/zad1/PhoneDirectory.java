package zad1;


import java.rmi.RemoteException;
import java.util.*;
import java.io.*;

import javax.rmi.PortableRemoteObject;

public class PhoneDirectory extends PortableRemoteObject
							implements PhoneDirectoryInterface{

  @SuppressWarnings("rawtypes")
private Map pbMap = new HashMap();

  @SuppressWarnings("unchecked")
public PhoneDirectory(String fileName) throws RemoteException{
    // Inicjalna zawartość książki telefonicznej
    // jest wczytywana z pliku o formacie
    //  imię  numer_telefonu
    try {
      BufferedReader br = new BufferedReader(
                             new FileReader(fileName));
      String line;
      while ((line = br.readLine()) != null) {
        String[] info = line.split(" +", 2);
        pbMap.put(info[0], info[1]);
      }
      br.close();
    } catch (Exception exc) {
        exc.printStackTrace();
        System.exit(1);
    }
  }

  // Zwraca numer telefonu dla podanej osoby
  public String getPhoneNumber(String name) {
    return (String) pbMap.get(name);
  }

  // Dodaje nową osobę do książki
  // Wynik:
  // - true - dodana
  // - false - nie (przy próbie dodania osoby zapisanej już w książce)
  @SuppressWarnings("unchecked")
public boolean addPhoneNumber(String name, String num) {
    if (pbMap.containsKey(name)) return false;
    pbMap.put(name, num);
    return true;
  }

  // Zastępuje numer podanej osoby nowym
  // Wynik:
  // - true (numer zastąpiony)
  // - false (nie - próba podania nowegu numeru nieistniejącej osoby)
  @SuppressWarnings("unchecked")
public boolean replacePhoneNumber(String name, String num) {
    if (!pbMap.containsKey(name)) return false;
    pbMap.put(name, num);
    return true;
  }


}  