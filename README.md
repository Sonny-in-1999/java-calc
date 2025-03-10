# 내일배움캠프 자바 세션 1차 과제

## 목표
> 각 레벨 별 필수 기능 및 요구사항을 준수하여 계산기 프로그램을 작성합니다.

### 레벨 1. 클래스가 없는 기본연산 수행 계산기
> 요구사항:
>
> 1. **양의 정수(0 포함)를 입력받기**
> - Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
> - 양의 정수는 각각 하나씩 전달 받습니다.
> - 양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.
> 
> 2. **사칙연산 기호(+,-,*,/)를 입력받기**
> - Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
> - 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
> 
> 3. **입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기**
> - 사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
> - 입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다.
> - 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
> 
> 4. **반복문을 사용하되, 반복의 종료를 알려주는 "exit" 문자열을 입력하기 전까지 계산기를 계속 이용할 수 있도록 합니다.**

### 레벨 2. 클래스가 있는 기본연산 수행 계산기
> 요구사항:
>
> 1. **사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성**
> - 사칙연산을 수행한 후, 결과값을 반환하는 메서드를 구현합니다.
> - 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
> - 1) 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(➕,➖,✖️,➗) 기능을 수행한 후 2) 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
>
> 2. **Lv 1에서 구현한 App클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정**
> - 연산 수행 역할은 Calculator 클래스가 담당합니다.
>   - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장
> - 소스 코드 수정 후에도 수정 전의 기능들이 반드시 똑같이 동작해야합니다.
>
> 3. **App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정 (캡슐화)**
> - 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
> - 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드)
> - 위 요구사항을 모두 구현 했다면 App 클래스의 main 메서드에서 위에서 구현한 메서드를 활용 해봅니다.
>
> 4. **Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정합니다.**
> - (컬렉션 활용 연습)

### 레벨 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기
> 요구사항:
>
> 1. **현재 사칙연산 계산기는 (➕,➖,✖️,➗) 이렇게 총 4가지 연산 타입으로 구성되어 있습니다.**
> - Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.
>
> 2. **실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기**
> - 지금까지는 Calculator, 즉 사칙연산 계산기는 양의 정수(0 포함)를 매개변수로 전달받아 연산을 수행
> - 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장
>   - Calculator 클래스의 연산 메서드(calculate)
> - 위 요구사항을 만족할 수 있도록 Calculator 클래스를 수정합니다.
>   - 추가적으로 수정이 필요한 다른 클래스나 메서드가 있다면 같이 수정 해주세요.
>
> 3. **저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력합니다.**
> - ArithmeticCalculator 클래스에 위 요구사항을 만족하는 조회 메서드를 구현합니다.
> - 단, 해당 메서드를 구현할 때 Lambda & Stream을 활용하여 구현합니다.
