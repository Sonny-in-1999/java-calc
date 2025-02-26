package level1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("계산기를 실행합니다.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int number1;
            int number2;

            while (true) {
                System.out.print("첫 번째 수를 입력해주세요(0 이상의 정수): ");
                String input = scanner.nextLine().trim();
                try {
                    number1 = Integer.parseInt(input);
                    if (number1 < 0) {
                        System.out.println("0 이상의 정수를 입력해주세요.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못 입력하셨습니다. 정수를 입력해주세요.");
                }

            }

            while (true) {
                System.out.print("두 번째 수를 입력해주세요(0 이상의 정수): ");
                String input = scanner.nextLine().trim();
                try {
                    number2 = Integer.parseInt(input);
                    if (number2 < 0) {
                        System.out.println("0 이상의 정수를 입력해주세요.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("잘못 입력하셨습니다. 정수를 입력해주세요.");
                }
            }


            while (true) {
                System.out.print("사칙연산 기호를 입력해주세요(+,-,*,/): ");
                char operator = scanner.next().charAt(0);
                switch (operator) {
                    case '+': {
                        System.out.println("결과: " + (number1 + number2));
                        break;
                    }
                    case '-': {
                        System.out.println("결과: " + (number1 - number2));
                        break;
                    }
                    case '*': {
                        System.out.println("결과: " + (number1 * number2));
                        break;
                    }
                    case '/': {
                        if (number2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다.");
                        } else {
                            System.out.println("결과: " + (number1 / number2));
                        }
                        break;
                    }
                    default: {
                        System.out.println("올바른 기호를 입력해주세요.");
                        scanner.nextLine();
                        continue; // 루프의 처음으로 돌아감
                    }
                }
                break;
            }

            while (true) {
                System.out.print("계산기를 다시 실행하시겠습니까?(y/n): ");
                char endYn = scanner.next().charAt(0);

                if (endYn == 'y') {
                    System.out.println("계산기를 다시 실행합니다.\n");
                    scanner.nextLine(); // 개행문자 처리(첫 번째 정수값 검증에서 예외처리 발생 예방)
                    break; // 내부 while문 탈출 -> 외부 while문 다시 진행
                } else if (endYn == 'n') {
                    System.out.println("계산기를 종료합니다.");
                    scanner.close();
                    return; // 프로그램 종료
                } else {
                    System.out.println("잘못된 입력입니다. 'y' 또는 'n' 중 하나를 입력해주세요.");
                }
            }
        }
    }
}
