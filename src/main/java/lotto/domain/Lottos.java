package lotto.domain;

import lotto.domain.enums.WinningInformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;
    private Map<WinningInformation, Integer> totalStats;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.totalStats = new HashMap<>();
    }

    public void calculateRank(Lotto winningLottos, BonusNumber bonus) {
        for (Lotto lotto : lottos) {
            lotto.calculateWinningPrice(winningLottos, bonus);
        }
    }

    // TODO : 전체 수익률을 계산한다.
    public double getRate(int purchasePrice) {
        double sum = 0.0;
        for (Lotto lotto : this.lottos) {
            sum += lotto.getWinningInformation().getWinningPrice();
        }

        double rate = (sum / purchasePrice) * 100;
        rate = Math.round(rate * 10) / 10.0;

        return rate;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<WinningInformation, Integer> getTotalStats() {
        calculateTotalStats();
        return totalStats;
    }

    private void calculateTotalStats() {
        for (Lotto lotto : this.lottos) {
            WinningInformation rank = lotto.getWinningInformation();
            totalStats.put(rank, totalStats.getOrDefault(rank, 0) + 1);
        }
    }
}
