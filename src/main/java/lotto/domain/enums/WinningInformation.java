package lotto.domain.enums;

public enum WinningInformation {
    // 몇 등, 일치 번호 갯수, 보너스 일치 여부, 금액
    NONE(-1, 0, false, 0),
    FIFTH(5, 3, false, 5_000),
    FOURTH(4, 4, false, 50_000),
    THIRD(3, 5, false, 1_500_000),
    SECOND(2, 5, true, 30_000_000),
    FIRST(1, 6, false, 2_000_000_000);

    private int rank;
    private int matchCount;
    private boolean isMatchedBonus;
    private int winningPrice;

    // TODO : ENUM은 기본이 private
    WinningInformation(int rank, int matchCount, boolean isMatchedBonus, int winningPrice) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.isMatchedBonus = isMatchedBonus;
        this.winningPrice = winningPrice;
    }

    public int getRank() {
        return this.rank;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean getIsMatchedBonus() {
        return this.isMatchedBonus;
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }

    // TODO : 등수 계산을 위한 match 로직 필요, 차후 리팩토링 예정
    public static WinningInformation getWinningInformation(int cnt, boolean haveBonus) {
        if (cnt == 6 && !haveBonus) {
            return FIRST;
        }
        if (cnt == 5 && haveBonus) {
            return SECOND;
        }
        if (cnt == 5 && !haveBonus) {
            return THIRD;
        }
        if (cnt == 4 && !haveBonus) {
            return FOURTH;
        }
        if (cnt == 3 && !haveBonus) {
            return FIFTH;
        }
        return NONE;
    }
}
