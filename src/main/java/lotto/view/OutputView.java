package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.enums.WinningInformation;

public class OutputView {
    public void printLottos(Lottos lottos, int count) {
        System.out.println(count + "개를 구매했습니다.");

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printStats(Lottos lottos, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (WinningInformation winningInformation : WinningInformation.values()) {  // TODO : ENUM으로 낮은 것부터 순회하기 (정의 순서 주의)
            if(winningInformation.getRank() == -1){
                continue;
            }
            printInformation(winningInformation, lottos);
        }

        System.out.println("총 수익률은 " + lottos.getRate(money) + "%입니다.");
    }

    private void printInformation(WinningInformation winningInformation, Lottos lottos) {
        boolean isBonus = winningInformation.getIsMatchedBonus();
        int matchCount = winningInformation.getMatchCount();
        // TODO : ENUM에서 _를 ,로 formatting 하는 것 기억하기
        String money = String.format("%,d", winningInformation.getWinningPrice());
        int count = lottos.getTotalStats().getOrDefault(winningInformation,0);
        // TODO : 없으면 NULL 이므로 항상 .getOrDefault를 기억하자.

        if(isBonus){
            System.out.println(matchCount + "개 일치, 보너스 볼 일치 " + "(" + money + "원) - " + count + "개");
            return;
        }
        System.out.println(matchCount + "개 일치 " + "(" + money + "원) - " + count + "개");
    }
}
