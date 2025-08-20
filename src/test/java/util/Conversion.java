package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Conversion {



    public static String convertCountry2(String shortCounty)
    {
        HashMap<String, String> countryMap = new HashMap<>();

        countryMap.put("IN", "India");
        countryMap.put("US", "United States");
        countryMap.put("UK", "United Kingdom");
        countryMap.put("CA", "Canada");
        countryMap.put("AU", "Australia");
        countryMap.put("NZ", "New Zealand");
        countryMap.put("DE", "Germany");
        countryMap.put("FR", "France");
        countryMap.put("IT", "Italy");
        countryMap.put("ES", "Spain");
        countryMap.put("BR", "Brazil");
        countryMap.put("MX", "Mexico");
        countryMap.put("JP", "Japan");
        countryMap.put("CN", "China");
        countryMap.put("ZA", "South Africa");
        countryMap.put("AE", "United Arab Emirates");
        countryMap.put("RU", "Russia");
        countryMap.put("SG", "Singapore");
        countryMap.put("MY", "Malaysia");
        countryMap.put("SA", "Saudi Arabia");
        countryMap.put("KR", "South Korea");
        countryMap.put("TH", "Thailand");
        countryMap.put("PK", "Pakistan");
        countryMap.put("BD", "Bangladesh");
        // ✅ You can keep adding more countries here (all ISO codes if you want)

        return countryMap.get(shortCounty);

    }




    public static String convertCountry(String shortCounty)
    {
        String fullCountry = "";

        switch (shortCounty)
        {
            case "IN": fullCountry = "India"; break;
            case "US": fullCountry = "United States"; break;
            case "UK": fullCountry = "United Kingdom"; break;
            case "CA": fullCountry = "Canada"; break;
            case "AU": fullCountry = "Australia"; break;
            case "NZ": fullCountry = "New Zealand"; break;
            case "DE": fullCountry = "Germany"; break;
            case "FR": fullCountry = "France"; break;
            case "IT": fullCountry = "Italy"; break;
            case "ES": fullCountry = "Spain"; break;
            case "BR": fullCountry = "Brazil"; break;
            case "MX": fullCountry = "Mexico"; break;
            case "JP": fullCountry = "Japan"; break;
            case "CN": fullCountry = "China"; break;
            case "ZA": fullCountry = "South Africa"; break;
            case "AE": fullCountry = "United Arab Emirates"; break;
            case "RU": fullCountry = "Russia"; break;
        }

        return fullCountry;
    }

    public static String getGender(String genderId)
    {
        String gender = "";
        switch (genderId)
        {
            case "0" : gender ="Male";break;
            case "1" : gender ="Female";break;
            case "2" : gender ="Other";break;
        }
        return gender;
    }

   // Expected :05-Sep-1985 - Excel
   // Actual   :1985-09-05 - DB

    public static String convertDate(String dbDate) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);

        return new SimpleDateFormat("dd-MMM-yyyy").format(date);
    }
}
