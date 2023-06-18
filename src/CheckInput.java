class CheckInput {
    String[] splitInput;

    CheckInput(String input) {
        this.splitInput = input.split(" ");
    }

    void checkMembers() throws Exception {
        if (splitInput.length == 2 || splitInput.length == 1) {
            throw new Exception("строка не является математической операцией.");
        } else if (splitInput.length > 3) {
            throw new Exception("формат математической операции не удовлетворяет " +
                    "заданию - два операнда и один оператор (+, -, /, *)");
        } else if (splitInput.length == 3) {
            switch (splitInput[1]) {
                case "+", "-", "*", "/":
                    break;
                default:
                    throw new Exception("Оператор не удовлетворяет требованию (+, -, /, *)");
            }
        }
    }

    void checkMembers2() throws Exception {
        int flag = 0;
        for (int i = 0; i < splitInput.length; i += 2) {
            for (int y = 0; y < NumberConverter.values().length - 9; y++) {
                if (splitInput[i].equals(NumberConverter.values()[y].arabicStr) ||
                    splitInput[i].equals(NumberConverter.values()[y].name())) {
                    flag++;
                }
            }
        }
        if (flag != 2) throw new Exception("Допускается ввод цифр от 1 до 10 включительно, не более.");
        for (NumberConverter y : NumberConverter.values()) {
            if (splitInput[0].equals(y.name()) && splitInput[2].equals(y.arabicStr) ||
                    splitInput[0].equals(y.arabicStr) && splitInput[2].equals(y.name())) {
                throw new Exception("Используются одновременно разные системы счисления");
            }
        }
    }

    String checkTwoMetrics() throws Exception {
        for (NumberConverter i : NumberConverter.values()) {
            if (i.name().equals(splitInput[0])) {
                for (NumberConverter y : NumberConverter.values()) {
                    if (splitInput[2].equals(y.name())) {
                        RomanMetric romanExpression = new RomanMetric(splitInput);
                        return romanExpression.calculateRoman();
                    }
                }
            }
        }
        return checkArabMetric();
    }

    String checkArabMetric() throws Exception {
        for (NumberConverter i : NumberConverter.values()) {
            if (splitInput[0].equals(i.arabicStr)) {
                for (NumberConverter y : NumberConverter.values()) {
                    if (splitInput[2].equals(y.arabicStr)) {
                        ArabicMetric arabicExpression = new ArabicMetric(splitInput);
                        return arabicExpression.calculateArabic();
                    }
                }
            }
        }
        throw new Exception("Неизсвестная система счисления");
    }
}


