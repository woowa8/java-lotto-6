package lotto.domain;

import lotto.domain.enums.WinningInformation;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    // 등수를 정한다.
    public WinningInformation calculateScore(Lotto lotto) {
        int cnt = winningLotto.countMatchingNumbers(lotto);
        boolean haveBonus = lotto.contains(bonusNumber.getNumber());

        return WinningInformation.getWinningInformation(cnt, haveBonus);
    }
}
