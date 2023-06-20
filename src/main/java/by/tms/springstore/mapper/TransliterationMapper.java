package by.tms.springstore.mapper;

import com.ibm.icu.text.Transliterator;

import java.util.Enumeration;

public class TransliterationMapper {

    String LATIN_TO_CYRILLIC = "Latin-Russian/BGN";
    static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";

    public static void main(String[] args) {
        String st = "привет я учусь в тичмискилл";

        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String result = toLatinTrans.transliterate(st);
        System.out.println(result);

//        Enumeration<String> availableIDs = Transliterator.getAvailableIDs();
//        availableIDs.asIterator().forEachRemaining(System.out::println);

    }


}
