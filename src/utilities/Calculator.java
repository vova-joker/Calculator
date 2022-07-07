package utilities;


import javax.naming.NameNotFoundException;

public class Calculator {
    int result;
    public String calculate(String string) {
        if (Parser.sign == '+')
           result = Integer.parseInt(Parser.number_1) + Integer.parseInt(Parser.number_2);
        if (Parser.sign == '-')
            result = Integer.parseInt(Parser.number_1) - Integer.parseInt(Parser.number_2);
        if (Parser.sign == '/') {
             if (Parser.number_2 == "0")
            result = 0;
            else result = Integer.parseInt(Parser.number_1) / Integer.parseInt(Parser.number_2);

        }
        if (Parser.sign == '*')
            result = Integer.parseInt(Parser.number_1) * Integer.parseInt(Parser.number_2);
        if (Parser.isRome == true) {
            Converter converter = new Converter();
            converter.convertToRome(result);
        }
        return Integer.toString(result);
    }
}
