package lotto.domain;

public class BonusNumber {
    // TODO : 1~45 사이의 숫자가 맞는지 확인 필요
    private int number;
    public BonusNumber(int number) {
        isLotto(number);
        this.number = number;
    }

    private void isLotto(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
