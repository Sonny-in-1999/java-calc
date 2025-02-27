package level3;

public enum Operator {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    // 입력받은 문자에 맞는 Operator 반환
    public static Operator fromSymbol(char symbol) throws IllegalArgumentException {
        for (Operator op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new IllegalArgumentException("올바른 기호를 입력해주세요.");
    }
}
