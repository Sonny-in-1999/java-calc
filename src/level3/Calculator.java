package level3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Calculator<T extends Number> {

    private T number1;
    private T number2;
    private Operator operator;
    private final List<Result> resultList = new ArrayList<>();

    // this()
    public Calculator() {
    }

    // this: 객체가 자기 자신을 가리키는 레퍼런스 변수
    // 필드값과 동일한 이름의 매개변수를 받을 경우, 필드값에 this를 붙여 객체의 필드값임을 구별해주어야 합니다.
    public void setNumber1(T number1) {
        this.number1 = number1;
    }

    public void setNumber2(T number2) {
        this.number2 = number2;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void calculate() throws IllegalArgumentException, ArithmeticException {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        final double result;

        // 입력된 연산기호에 맞는 연산 수행
        switch (operator) {
            case ADDITION -> result = number1.doubleValue() + number2.doubleValue();
            case SUBTRACTION -> result = number1.doubleValue() - number2.doubleValue();
            case MULTIPLICATION -> result = number1.doubleValue() * number2.doubleValue();
            case DIVISION -> {
                if (number2.doubleValue() == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = number1.doubleValue() / number2.doubleValue();
            }
            default -> throw new IllegalArgumentException("올바른 기호를 입력해주세요.");
        }

        // 결과 저장 (결과 값은 실수형으로 통일)
        Result resultListItem = new Result(number1 + " " + operator.getSymbol() + " " + number2, result, now);
        resultList.add(resultListItem);
        System.out.println("결과: " + result);

        // 계산 기록 중 해당 결과값 보다 큰 결과값들이 존재할 경우 표출
        System.out.println("해당 결과값보다 큰 이전 결과값들은 아래와 같습니다.");
        System.out.println("----------------------------------------");
        resultList.stream().filter(resultItem -> resultItem.result().doubleValue() > result)
                .forEach(resultItem -> {
                    System.out.println("연산식: " + resultItem.operate());
                    System.out.println("결과값: " + resultItem.result());
                    System.out.println("계산일자: " + resultItem.createdAt());
                    System.out.println("----------------------------------------");
                });
    }
}
