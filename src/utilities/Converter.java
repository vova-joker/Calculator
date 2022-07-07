package utilities;

public class Converter {
    //Работает с римскими и арабскими цифрами, возвращает значения иной системы счисления
    static String _rome_number;

    RomeNumbers ROME_10 = new RomeNumbers('X', 10);
    RomeNumbers ROME_1 = new RomeNumbers('I', 1);
    RomeNumbers ROME_50 = new RomeNumbers('L', 50);
    RomeNumbers ROME_5 = new RomeNumbers('V', 5);
    RomeNumbers ROME_100 = new RomeNumbers('C', 100);

    int _arabic_number = 0;

    public String convertToArabic(String rome_number) {
        _rome_number = rome_number;
        _arabic_number = 0;
        for (int i = 0; i < _rome_number.length(); i++) {

            if (_rome_number.charAt(i) == ROME_10.Rome_name || _rome_number.charAt(i) == ROME_1.Rome_name || _rome_number.charAt(i) == ROME_5.Rome_name) {
                if (_rome_number.charAt(i) == ROME_10.Rome_name && _arabic_number < 10) {
                    if (i >= 1 && _arabic_number == 1)
                        _arabic_number -= 2;
                    else
                        _arabic_number += ROME_10.Rome_value;
                } else if (_rome_number.charAt(i) == ROME_5.Rome_name && _arabic_number < 10) {
                    if (i >= 1 && _arabic_number == 1)
                        _arabic_number -= 2;
                    else
                        _arabic_number += ROME_5.Rome_value;
                } else if (_rome_number.charAt(i) == ROME_1.Rome_name && _arabic_number < 10) {
                    _arabic_number += ROME_1.Rome_value;
                }
            } else
                System.out.println("Нет ни арабских, ни римских чисел или они больше 10!");
        }
        return Integer.toString(_arabic_number);
    }
    public String countDigital(int digital) {
        switch (digital) {
            case 1:
                _rome_number = String.valueOf(ROME_1.Rome_name);
                break;
            case 2:
                _rome_number = String.valueOf(ROME_1.Rome_name) + String.valueOf(ROME_1.Rome_name);
                break;
            case 3:
                _rome_number = String.valueOf(ROME_1.Rome_name) + String.valueOf(ROME_1.Rome_name) + String.valueOf(ROME_1.Rome_name);
                break;
            case 4:
                _rome_number = String.valueOf(ROME_1.Rome_name) + String.valueOf(ROME_5.Rome_name);
                break;
            case 5:
                _rome_number = String.valueOf(ROME_5.Rome_name);
                break;
            case 6:
                _rome_number = String.valueOf(ROME_5.Rome_name) + String.valueOf(ROME_1.Rome_name);
                break;
            case 7:
                _rome_number = String.valueOf(ROME_5.Rome_name) + String.valueOf(ROME_1.Rome_name) + String.valueOf(ROME_1.Rome_name);
                break;
            case 8:
                _rome_number = String.valueOf(ROME_5.Rome_name) + String.valueOf(ROME_1.Rome_name) + String.valueOf(ROME_1.Rome_name) + String.valueOf(ROME_1.Rome_name);
                break;
            case 9:
                _rome_number = String.valueOf(ROME_1.Rome_name) + String.valueOf(ROME_10.Rome_name);
                break;
        }
        return _rome_number;
    }
    public String convertToRome(int arabic_number) {
        if (arabic_number < 0)
            return "Нет значения для отображения отрицательных римских чисел!";
        if (arabic_number == 0)
            return "Нет значения для отображения 0!";
        if (arabic_number == 100)
            _rome_number = String.valueOf(ROME_100.Rome_name);
        if (arabic_number <= 9 && arabic_number >= 1)
           _rome_number = countDigital(arabic_number);
        if (arabic_number <= 99 && arabic_number >= 90) {
            arabic_number = arabic_number % 90;
            if (arabic_number == 0)
                _rome_number = String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_100.Rome_name);
            else {
                _rome_number = countDigital(arabic_number);
                _rome_number = String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_100.Rome_name) + _rome_number;
            }
            return _rome_number;
        }
        if (arabic_number <= 89 && arabic_number >= 80) {
            arabic_number = arabic_number % 80;
            if (arabic_number == 0)
                _rome_number = String.valueOf(ROME_50.Rome_name) + String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name);
            else {
                _rome_number = countDigital(arabic_number);
                _rome_number = String.valueOf(ROME_50.Rome_name) + String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name) + _rome_number;
            }
            return _rome_number;
        }
        if (arabic_number <= 79 && arabic_number >= 70) {
            arabic_number = arabic_number % 70;
            if (arabic_number == 0)
                _rome_number = String.valueOf(ROME_50.Rome_name) + String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name);
            else {
                _rome_number = countDigital(arabic_number);
                _rome_number = String.valueOf(ROME_50.Rome_name) + String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name) + _rome_number;
            }
            return _rome_number;
        }
        if (arabic_number <= 69 && arabic_number >= 60) {
            arabic_number = arabic_number % 60;
            if (arabic_number == 0)
                _rome_number = String.valueOf(ROME_50.Rome_name) + String.valueOf(ROME_10.Rome_name);
            else {
                _rome_number = countDigital(arabic_number);
                _rome_number = String.valueOf(ROME_50.Rome_name) + String.valueOf(ROME_10.Rome_name) + _rome_number;
            }
            return _rome_number;
        }
        if (arabic_number <= 59 && arabic_number >= 50) {
            arabic_number = arabic_number % 50;
            if (arabic_number == 0)
                _rome_number = String.valueOf(ROME_50.Rome_name);
            else {
                _rome_number = countDigital(arabic_number);
                _rome_number = String.valueOf(ROME_50.Rome_name) + _rome_number;
            }
            return _rome_number;
        }
        if (arabic_number <= 49 && arabic_number >= 40) {
            arabic_number = arabic_number % 40;
            if (arabic_number == 0)
                _rome_number = String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_50.Rome_name);
            else {
                _rome_number = countDigital(arabic_number);
                _rome_number = String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_50.Rome_name) + _rome_number;
            }
            return _rome_number;
        }
        if (arabic_number <= 39 && arabic_number >= 30) {
            arabic_number = arabic_number % 30;
            if (arabic_number == 0)
                _rome_number = String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name);
            else {
                _rome_number = countDigital(arabic_number);
                _rome_number = String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name) + _rome_number;
            }
            return _rome_number;
        }
        if (arabic_number <= 29 && arabic_number >= 20) {
            arabic_number = arabic_number % 20;
            if (arabic_number == 0)
                _rome_number = String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name);
            else {
                _rome_number = countDigital(arabic_number);
                _rome_number = String.valueOf(ROME_10.Rome_name) + String.valueOf(ROME_10.Rome_name) + _rome_number;
            }
            return _rome_number;
        }
        if (arabic_number <= 19 && arabic_number >= 10) {
            arabic_number = arabic_number % 10;
            if (arabic_number == 0)
                _rome_number = String.valueOf(ROME_10.Rome_name);
            else {
                _rome_number = countDigital(arabic_number);
                _rome_number = String.valueOf(ROME_10.Rome_name) + _rome_number;
            }
            return _rome_number;
        }
        return "";
    }
}
