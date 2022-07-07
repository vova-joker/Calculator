import utilities.Calculator;
import utilities.Converter;
import utilities.Parser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            System.out.print("Введите выражение, содержащее два арабских или римских числа от 1 до 10: ");
            Scanner scanner = new Scanner(System.in);
            String virashenue = scanner.nextLine();
            Parser parser = new Parser();
            String virashenueAfterParcing = parser.parse(virashenue);
            Calculator calculator = new Calculator();
            String result = virashenueAfterParcing.equals("Нет ни арабских, ни римских чисел или они больше 10!") == false ? calculator.calculate(virashenueAfterParcing) : virashenueAfterParcing;
            Converter converter = new Converter();
            if (Parser.isRome == true)
                result = converter.convertToRome(Integer.parseInt(result));

            System.out.println("Значение выражения (" + virashenue + ") :" + result);

    }
}