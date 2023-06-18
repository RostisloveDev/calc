public class RomanMetric {
    String[] expression;

    RomanMetric(String[] expression) {
        this.expression = expression;
    }

    String calculateRoman() throws Exception {
        for (NumberConverter i : NumberConverter.values()) {
            if (expression[0].equals(i.name())) {
                for (NumberConverter y : NumberConverter.values()) {
                    if (expression[2].equals(y.name())) return calculate(i.num, y.num);
                }
            }
        }
        return "";
    }

    String calculate(int operator1, int operator2) throws Exception {
        int result = 0;
        switch (expression[1]) {
            case "+":
                result = operator1 + operator2;
                break;
            case "-":
                result = operator1 - operator2;
                break;
            case "*":
                result = operator1 * operator2;
                break;
            case "/":
                result = operator1 / operator2;
                break;
        }
        if (result < 1) {
            throw new Exception("Результат операции < 1 не поддерживается римской системой счисления");
        } else {
                for (NumberConverter i : NumberConverter.values()) {
                    if (i.num == result) return i.name();
                }
                String firstDigit = "" + result / 10 + "0";
                String secondDigit = "" + result % 10;
                for (NumberConverter y : NumberConverter.values()) {
                    if (firstDigit.equals(y.arabicStr)) firstDigit = y.name();
                }
                for (NumberConverter y : NumberConverter.values()) {
                    if (secondDigit.equals(y.arabicStr)) secondDigit = y.name();
                }
                return firstDigit + secondDigit;
        }
    }
}

