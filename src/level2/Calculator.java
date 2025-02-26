package level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private int number1;
    private int number2;
    private char operator;
    private List<Result> resultList = new ArrayList<>();

    public int getNumber1() {
        return number1;
    }

    // this: 객체가 자기 자신을 가리키는 레퍼런스 변수
    // 필드값과 동일한 이름의 매개변수를 받을 경우, 필드값에 this를 붙여 객체의 필드값임을 구별해주어야 합니다.
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void calculate() {
        switch (operator) {
            case '+': {
                Result result = new Result(number1 + " " + operator + " " + number2, number1 + number2);
                resultList.add(result);
            }
            case '-': {
                Result result = new Result(number1 + " " + operator + " " + number2, number1 - number2);
                resultList.add(result);
            }
            case '*': {
                Result result = new Result(number1 + " " + operator + " " + number2, number1 * number2);
                resultList.add(result);
            }
            case '/': {
                Result result = new Result(number1 + " " + operator + " " + number2, number1 / number2);
                resultList.add(result);
            }
        }
    }

    // this()
    public Calculator() {
    }
}
