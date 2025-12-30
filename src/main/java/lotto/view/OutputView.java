package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;
import lotto.domain.enums.WinningInformation;

import java.util.List;

public class OutputView {
    public void printLottos(List<Lotto> lottos, int count) {
        System.out.println(count + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printStats(int money, WinningStatistics winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (WinningInformation winningInformation : WinningInformation.values()) {
            if (winningInformation.getRank() == -1) {
                continue;
            }
            printInformation(winningInformation, winningStatistics);
        }

        System.out.println("총 수익률은 " + winningStatistics.calculateRate(money) + "%입니다.");
    }

    private void printInformation(WinningInformation winningInformation, WinningStatistics winningStatistics) {
        String money = String.format("%,d", winningInformation.getWinningPrice());
        int count = winningStatistics.getCount(winningInformation);

        if (winningInformation.getIsMatchedBonus()) {
            System.out.println(winningInformation.getMatchCount() + "개 일치, 보너스 볼 일치 " + "(" + money + "원) - " + count + "개");
            return;
        }
        System.out.println(winningInformation.getMatchCount() + "개 일치 " + "(" + money + "원) - " + count + "개");
    }
}
