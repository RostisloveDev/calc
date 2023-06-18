public enum NumberConverter {
    I("1",1), II("2", 2), III("3", 3), IV("4", 4),
    V("5", 5), VI("6", 6), VII("7", 7), VIII("8", 8),
    IX("9", 9), X("10", 10),XX("20", 20), XXX("30", 30),
    XL("40", 40), L("50", 50), LX("60", 60), LXX("70", 70),
    LXXX("80", 80), XC("90", 90), C("100", 100);

    final String arabicStr;
    final int num;

    NumberConverter(String arabicStr, int num) {
        this.arabicStr = arabicStr;
        this.num = num;
    }

}
