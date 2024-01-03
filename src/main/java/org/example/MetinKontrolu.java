package org.example;


import java.util.*;

public class MetinKontrolu {

    public static void main(String[] args) {
        String[] metinDizisi = {"xxxyyyzzz", "aabb", "1234", "qwert"};

        //HashSet<Character> benzersizKarakterler = kontrol(metinDizisi);

        //System.out.println("Benzersiz Karakterler: " + benzersizKarakterler);

        System.out.println(" Tekrar eden harfler : " + control(metinDizisi));
    }

    public static HashSet<Character> control(String[] metinDizisi){

        List<String> foundedList =  new ArrayList<String>();

        for (String metin : metinDizisi) {

            HashMap<Character,Integer> hashMap = new HashMap<>();
            for (Character karakter : metin.toCharArray()) {
                if(hashMap.get(karakter) == null){
                    hashMap.put(karakter, 1);
                } else{
                    hashMap.put(karakter,hashMap.get(karakter) + 1);
                }
            }

            int hashMapSizeCheck = 0;
            for (int a : hashMap.values()){
                if(a < 2){
                    break;
                }
                hashMapSizeCheck++;
            }

            if(hashMapSizeCheck == hashMap.size()){
                foundedList.add(metin);
            }

            if(foundedList.size() == 2){
                break;
            }
        }

        HashSet<Character> benzersizKarakterler = new HashSet<>();
        for (String metin : foundedList){
            for (char karakter : metin.toCharArray()){
                benzersizKarakterler.add(karakter);
            }
        }

        return  benzersizKarakterler;
    }

    public static HashSet<Character> kontrol(String[] metinDizisi) {
        HashSet<Character> karakterSeti = new HashSet<>();
        HashSet<Character> tekraredenKarakterler = new HashSet<>();
        boolean ikiKelimeBulundu = false;

        for (String metin : metinDizisi) {
            for (char karakter : metin.toCharArray()) {
                if (karakterSeti.contains(karakter)) {
                    ikiKelimeBulundu = true;
                    break;
                }
                karakterSeti.add(karakter);
            }

            if (ikiKelimeBulundu) {
                tekraredenKarakterler.addAll(karakterSeti); // Düzeltme burada
                break;
            }

            karakterSeti.clear();
        }

        return tekraredenKarakterler;
    }
}