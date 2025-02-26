package level2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        outerLoop:
        while (true) {
            while (true) {
                System.out.println("날짜 " + now.toLocalDate());
                System.out.println("원하는 기능을 선택해주세요.");
                System.out.println("1. 계산기 실행");
                System.out.println("2. 계산 기록 조회");
                System.out.println("3. 프로그램 종료");
                System.out.print("입력(1-3): ");
                char input = scanner.next().charAt(0);
                switch (input) {
                    case '1': {
                        System.out.println("계산기를 실행합니다.");
                        scanner.nextLine();
                        break;
                    }
                    case '2': {
                        while (true) {
                            System.out.println("계산 기록을 조회합니다.");
                            System.out.println("----------------------------------------");
                            calculator.getResultMap().stream()
                                    .sorted((r1, r2) -> r2.createdAt().compareTo(r1.createdAt())) // 최신순 정렬
                                    .forEach(result
                                            -> {
                                        System.out.println("연산식: " + result.operate());
                                        System.out.println("결과값: " + result.result());
                                        System.out.println("계산일자: " + result.createdAt());
                                        System.out.println("----------------------------------------");
                                    });
                            System.out.print("엔터를 입력하여 메뉴로 돌아갑니다...");
                            scanner.nextLine();
                            String next = scanner.nextLine().trim();
                            if (next.isEmpty()) {
                                continue outerLoop; // 외부 while문 처음으로 돌아감
                            }
                        }
                    }
                    case '3': {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default: {
                        System.out.println("올바른 번호를 입력해주세요.");
                    }
                }
                scanner.nextLine();
                break;
            }

            // 첫 번째 정수 입력 및 검증
            while (true) {
                while (true) {
                    System.out.print("첫 번째 수를 입력해주세요(0 이상의 정수): ");
                    String input = scanner.nextLine().trim();
                    try {
                        int number1 = Integer.parseInt(input);
                        if (number1 < 0) {
                            System.out.println("0 이상의 정수를 입력해주세요.");
                            continue;
                        }
                        calculator.setNumber1(number1);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("잘못 입력하셨습니다. 정수를 입력해주세요.");
                    }
                }

                // 두 번째 정수 입력 및 검증
                while (true) {
                    System.out.print("두 번째 수를 입력해주세요(0 이상의 정수): ");
                    String input = scanner.nextLine().trim();
                    try {
                        int number2 = Integer.parseInt(input);
                        if (number2 < 0) {
                            System.out.println("0 이상의 정수를 입력해주세요.");
                            continue;
                        }
                        calculator.setNumber2(number2);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("잘못 입력하셨습니다. 정수를 입력해주세요.");
                    }
                }

                // 연산 기호 입력 및 검증
                while (true) {
                    System.out.print("사칙연산 기호를 입력해주세요(+,-,*,/): ");
                    char operator = scanner.next().charAt(0);
                    try {
                        calculator.setOperator(operator);
                        calculator.calculate();
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                }

                // 계산기 종료 여부
                while (true) {
                    System.out.print("계산기를 종료하시겠습니까?(y/n): ");
                    char endYn = scanner.next().charAt(0);

                    if (endYn == 'n') {
                        scanner.nextLine(); // 개행문자 처리(첫 번째 정수값 검증에서 예외처리 발생 예방)
                        break; // 내부 while문 탈출 -> 외부 while문 다시 진행
                    } else if (endYn == 'y') {
                        System.out.println("계산기를 종료합니다.");
                        scanner.close();
                        return; // 프로그램 종료
                    } else {
                        System.out.println("잘못된 입력입니다. 'y' 또는 'n' 중 하나를 입력해주세요.");
                    }
                }
                break;
            }
        }
    }
}
