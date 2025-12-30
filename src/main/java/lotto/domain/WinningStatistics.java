package lotto.domain;

import lotto.domain.enums.WinningInformation;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<WinningInformation, Integer> totalStats;

    public WinningStatistics() {
        this.totalStats = new HashMap<>();
    }

    public void add(WinningInformation information) {
        totalStats.put(information, totalStats.getOrDefault(information, 0) + 1);
    }

    public int getCount(WinningInformation information) {
        return totalStats.getOrDefault(information, 0);
    }

    private long calculateTotalPrice() {
        return totalStats.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningPrice() * entry.getValue())
                .sum();
    }

    public double calculateRate(int purchasePrice) {
        double rate = ((double) calculateTotalPrice() / (double) purchasePrice) * 100;
        return Math.round(rate * 10) / 10.0;
    }
}
