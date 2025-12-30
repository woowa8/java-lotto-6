package lotto.domain;

import lotto.domain.enums.WinningInformation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private WinningInformation winningInformation;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicates(numbers);
        for (Integer number : numbers) {
            validateScope(number);
        }
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    private void validateScope(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }

    private boolean contains(Integer number) {    // TODO : stream 사용을 위해 contains 구현하는거 알아두기..
        return numbers.contains(number);
    }

    public void calculateWinningPrice(Lotto winningLotto, BonusNumber bonusNumber) {
        int cnt = (int) this.numbers.stream()
                .filter(winningLotto::contains)
                .count();
        boolean haveBonus = this.numbers.contains(bonusNumber.getNumber());

        winningInformation = WinningInformation.getWinningInformation(cnt, haveBonus);
    }

    public WinningInformation getWinningInformation() {
        return winningInformation;
    }

    public String toString() {
        return numbers.toString();
    }
}
