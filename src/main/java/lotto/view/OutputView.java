package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printBuyingTickets(LotteryTickets tickets) {
        System.out.printf("%d개를 구매했습니다.%n", tickets.getCount());
        for (LotteryTicket ticket : tickets.getLotteryTickets()) {
            printTicket(ticket);
        }
    }

    private void printTicket(LotteryTicket ticket) {
        List<String> numbers = ticket.getLotteryNumbers()
                .stream()
                .map(LotteryNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.printf("[%s]%n", String.join(", ", numbers));
    }

    public void printResult(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRanks(result.getRanks());
        System.out.println();
        printRateOfReturn(result.getRateOfReturn());
    }

    private void printRateOfReturn(Double prize) {
        System.out.printf("총 수익률은 %.2f입니다.", prize);
        if (prize < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private void printRanks(Ranks ranks) {
        for (var rank : ranks.getRanks().entrySet()) {
            printRank(rank.getKey(), rank.getValue());
        }
    }

    private void printRank(Rank rank, Integer count) {
        if (rank != Rank.NON_MATCH) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", rank.getCount(), rank.getPrize(), count);
        }
    }
}
