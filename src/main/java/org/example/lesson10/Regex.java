package org.example.lesson10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        List<String> phones = new ArrayList();
        phones.add("+385298497211");        //valid
        phones.add("+385(29)5845-0125");    //invalid
        phones.add("636 85 67 89");         //valid
        phones.add("++2055550125");         //invalid

        List<String> emails = new ArrayList();
        emails.add("sdfsd@gmail.com");      //valid
        emails.add("sdfsd@gmailcom");       //invalid
        emails.add("sdf3sd44@gmail.com");   //valid
        emails.add("sdf3sd44@.com");        //invalid

        List<String> isbns = new ArrayList();
        isbns.add("ISBN 978-0-596-52068-7");        //valid
        isbns.add("ISBN 11978-0-596-52068-7");      //invalid
        isbns.add("isbn-13: 978-0-596-52068-7");    //valid
        isbns.add("ISBN-12: 978-0-596-52068-7");    //invalid

        List<String> dates = new ArrayList();
        dates.add("2022-Oct-17");            //valid
        dates.add("37-May-05");              //invalid
        dates.add("2022-Nov-25");            //valid
        dates.add("2022-November-25");       //invalid

        String patternForPhone = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        String patternForEmail = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
        String patternForISBN = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$" +
                "|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
        String patternForDate = "^\\d{4}-\\w{3}?-\\d{2}";

        verification(patternForPhone,phones);
        verification(patternForEmail,emails);
        verification(patternForISBN,isbns);
        verification(patternForDate,dates);

    }
    public static void verification (String pattern, List<String> list) {
        Pattern valid = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        for (String l : list)
        {
            Matcher matcher = valid.matcher(l);
            System.out.println(l + " "+ matcher.matches());
        }
        System.out.println();
    }
}
