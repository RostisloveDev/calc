 class ArabicMetric {
    String[] expression;

    ArabicMetric(String[] expression) {
        this.expression = expression;
    }

    String calculateArabic() {
        for (NumberConverter i: NumberConverter.values()) {
            if (expression[0].equals(i.arabicStr)) {
                for (NumberConverter y: NumberConverter.values()) {
                    if (expression[2].equals(y.arabicStr)) {
                        return calculate(i.num, y.num);
                    }
                }
            }
        }
        return "";
    }

    String calculate(int operator1, int operator2) {
        String str = "";
        int value;
        switch (expression[1]) {
            case "+":
                value = operator1 + operator2;
                str += value;
                break;
            case "-":
                value = operator1 - operator2;
                str += value;
                break;
            case "*":
                value = operator1 * operator2;
                str += value;
                break;
            case "/":
                value = operator1 / operator2;
                str += value;
                break;
        }
        return str;
    }
}
