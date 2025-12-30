# 미션 - 로또

## 구현 완료 한 기능 목록

### 1. View
#### InputView
- [X] 입력을 받기 위한 Console.readLine(); 구현
- [X] 사용자가 잘못된 값을 입력할 경우 
  1. IllegalArgumentException를 발생
  2. "[ERROR]"로 시작하는 에러 메시지를 출력
  3. 그 부분부터 입력을 다시 받기

#### OutputView
- [X] 출력을 위한 템플릿 구성
- [X] ENUM의 값을 조합해서 출력 순서를 맞추기

### 2. Domain
#### Lotto
- [X] 로또 번호가 1과 45 사이인지 체크하는 로직 구현
- [X] 각 로또의 등수를 저장해야 한다.
- [X] 모든 로또 번호는 중복되어선 안된다는 로직이 필요하다.

#### WinningStatistics
- [X] map으로 totalStats을 저장한다.
- [X] 전체 수익률을 계산한다.
- [X] 전체 로또의 번호를 가져오는 method가 존재해야 한다.
- [X] total 갯수 통계를 제공하는 method가 존재해야 한다.
- [X] 전체 통계를 저장하는 변수가 필요하다.

#### WinningNumbers
- [X] lotto 클래스를 단일하게 유지하기 위해 필요하다.
- [X] lotto와 bonusNumber를 이용해서 WinningInformation를 return해서 등수를 구한다.

#### WinningInformation
- [X] 당첨 정보를 담기 위한 class
- [X] 몇 등, 일치 번호 갯수, 보너스 일치 여부, 금액을 한 군데서 관리

#### BonusNumber
- [X] 보너스 번호를 저장하는 로직
- [X] 1~45 사이의 숫자가 맞는지 확인 필요

### 3. Service
#### LottoService
- [X] 각 도메인을 조립해서 input - output을 연결

### 4. Util
#### InputParser
- [X] 입력받은 당첨 번호가 , 로 잘 나눠져 있는지 체크하기 위한 로직 구현