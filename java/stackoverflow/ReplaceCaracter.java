package stackoverflow;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ReplaceCaracter {

    public static void main(String[] args){
        String number = "10,000.32";
        System.out.println(number);
        number = number.replaceAll(",","");
        System.out.println(number);

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(new Locale("en", "UK"));
        decimalFormat.applyPattern("###,###.##");

        try{
            Number d = decimalFormat.parse(number);
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
