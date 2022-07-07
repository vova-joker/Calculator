package utilities;

public class Parser {
    public static boolean isRome = false;
    static String number_1 = "";
    static String number_2 = "";
    static int indexOfSign = 0;
    static char sign;


    public String parse(String string) {
        int counter_signs = 0;

        string = string.replaceAll(" ","");


            if (string.indexOf('+') > -1 || string.indexOf('-') > -1 || string.indexOf('*') > -1 || string.indexOf('/') > -1) {
                for (int i = 0; i < string.length() && string.length() >= 3; i++) {

                    if (string.charAt(i) == '+') {
                        indexOfSign = string.indexOf('+');
                        sign = string.charAt(i);
                        counter_signs++;
                    }

                    if (string.charAt(i) == '-') {
                        indexOfSign = string.indexOf('-');
                        sign = string.charAt(i);
                        counter_signs++;
                    }

                    if (string.charAt(i) == '*') {
                        indexOfSign = string.indexOf('*');
                        sign = string.charAt(i);
                        counter_signs++;
                    }

                    if (string.charAt(i) == '/') {
                        indexOfSign = string.indexOf('/');
                        sign = string.charAt(i);
                        counter_signs++;
                    }
                }
                if (indexOfSign == 0 || indexOfSign == string.length()-1)
                    System.out.println("Знак должен быть между цифрами, а не с краю!");
                else if (counter_signs > 1)
                    System.out.println("Слишком много знаков! Почему их " + counter_signs + "?");
                else
                    string = parseCounts(string);



            }
            else System.out.println(string = "Тут нет знаков для вычисления! Или нет числа!");






        return string;
    }
    private static String parseCounts(String string) {
         number_1 = string.substring(0,indexOfSign);
         number_2 = string.substring(indexOfSign + 1, string.length());
        try {
            number_1 = String.valueOf(Integer.parseInt(number_1));
            number_2 = String.valueOf(Integer.parseInt(number_2));
        } catch (NumberFormatException e) {
            parseRomeNumbers(string);
        }
        if (Integer.parseInt(number_1) > 10 || Integer.parseInt(number_2) > 10)
            string = "Нет ни арабских, ни римских чисел или они больше 10!";



        return string;
    }
    private static String parseRomeNumbers (String string) {
         number_1 = string.substring(0,indexOfSign);
         number_2 = string.substring(indexOfSign + 1, string.length());
        try {
            Converter converter = new Converter();
            number_1 = converter.convertToArabic(number_1);
            number_2 = converter.convertToArabic(number_2);
            isRome = true;
        } catch (NumberFormatException e) {
            System.out.println("Нет ни арабских, ни римских чисел или они больше 10!");
            string = "Нет ни арабских, ни римских чисел или они больше 10!";
        }
        return string;
    }

}
