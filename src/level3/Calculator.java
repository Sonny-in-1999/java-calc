package level3;

import level2.Result;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private int number1;
    private int number2;
    private Operator operator;
    private final List<Result> resultList = new ArrayList<>();

    // this()
    public Calculator() {
    }

    // this: 객체가 자기 자신을 가리키는 레퍼런스 변수
    // 필드값과 동일한 이름의 매개변수를 받을 경우, 필드값에 this를 붙여 객체의 필드값임을 구별해주어야 합니다.
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public List<Result> getResultMap() {
        return resultList;
    }

    public void calculate() throws IllegalArgumentException {
        LocalDateTime now = LocalDateTime.now();
        switch (operator) {
            case ADDITION: {
                int result = number1 + number2;
                Result resultListItem = new Result(number1 + " " + operator + " " + number2, result, now);
                resultList.add(resultListItem);
                System.out.println("결과: " + result);
                break;
            }
            case SUBTRACTION: {
                int result = number1 - number2;
                Result resultListItem = new Result(number1 + " " + operator + " " + number2, result, now);
                resultList.add(resultListItem);
                System.out.println("결과: " + result);
                break;
            }
            case MULTIPLICATION: {
                int result = number1 * number2;
                Result resultListItem = new Result(number1 + " " + operator + " " + number2, result, now);
                resultList.add(resultListItem);
                System.out.println("결과: " + result);
                break;
            }
            case DIVISION: {
                int result = number1 / number2;
                Result resultListItem = new Result(number1 + " " + operator + " " + number2, result, now);
                resultList.add(resultListItem);
                System.out.println("결과: " + result);
                break;
            }
            default: {
                throw new IllegalArgumentException("올바른 기호를 입력해주세요.");
            }
        }
    }
}
