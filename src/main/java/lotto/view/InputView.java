package lotto.view;

import lotto.domain.Amount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String enterPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String enterAmountOfManualTickets() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<String> enterManualTickets(Amount amount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualTickets = new ArrayList<>();
        for (int i = 0; i < amount.getAmount(); i++) {
            manualTickets.add(scanner.nextLine());
        }
        return manualTickets;
    }

    public static String enterWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String enterBonusBoll() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
