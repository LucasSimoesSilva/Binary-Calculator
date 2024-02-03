package Calculator;

public class BinaryCalculator {
    public static void main(String[] args) {
        System.out.println(decimalToBinary(10));
    }

    public static StringBuilder decimalToBinary(int num) {
        StringBuilder binary = new StringBuilder();

        while (num > 0) {
            if (num % 2 == 0) {
                binary.append("0");
            } else {
                binary.append("1");
            }
            num = num / 2;
        }

        return binary.reverse();
    }

    public static int numberToDecimal(String num, int base) {
        int digit = 0;
        String zeroOrOne = "";
        int result = 0;
        char[] bit = num.toCharArray();
        int j = 0;

        for (int i = bit.length - 1; i >= 0; i--) {
            zeroOrOne = String.valueOf(bit[i]);
            digit = Integer.parseInt(zeroOrOne);
            result += digit * Math.pow(base, j);
            j++;
        }

        return result;
    }

    /**
     * Method to convert a number to hexadecimal or octadecimal
     *
     * @param num number to be converted
     * @param base base of the num to be converted
     * @param type type to convert. Type = 'octa' or 'hexa'
     * @return the number converted
     */
    public static int numberToOctaOrHexa(String num, int base, String type) {
        int bitNumbers = 0;
        if (type.equalsIgnoreCase("octa")) {
            bitNumbers = 3;
        }else if(type.equalsIgnoreCase("hexa")){
            bitNumbers = 4;
        }else{
            System.out.println("Type invalid");
            return 0;
        }
        return Integer.parseInt(convertType(bitNumbers,num,base).reverse().toString());
    }

    public static StringBuilder numberToBinary(String num, int base){
        int decimal = numberToDecimal(num, base);
        return decimalToBinary(decimal);
    }

    private static StringBuilder convertType(int bitsNumber, String num, int base){
        int decimalNumber = numberToDecimal(num, base);
        StringBuilder binaryNumber = decimalToBinary(decimalNumber);
        int groups = 0;
        StringBuilder result = new StringBuilder();

        while (binaryNumber.length() % bitsNumber != 0) {
            binaryNumber.insert(0, "0");
        }
        groups = binaryNumber.length() / bitsNumber;
        int j = binaryNumber.length()-bitsNumber;
        for (int i = 0; i < groups; i++) {
            String group = binaryNumber.substring(j,j+bitsNumber);

            for (TableConversor value : TableConversor.values()) {
                if(value.getGroup().equals(group)){
                    result.append(String.valueOf(value.getValue()));
                }
            }
            j -= bitsNumber;
        }

        return result;
    }
}
