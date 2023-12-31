package lotto.controller;

import java.util.List;
import lotto.model.LottoNumbers;
import lotto.model.LottoService;
import lotto.model.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView outputView = new OutputView();
        Parser parser = new Parser();

        int totalMoney = Integer.parseInt(input.money());
        int countByPurchaseManually = Integer.parseInt(input.countByPurchaseManually());

        List<LottoNumbers> manuallyLottoNumbers = parser.parseTextToLottoNumbersList(
            input.purchaseManually(countByPurchaseManually)
        );

        LottoService lottoService = new LottoService(
            totalMoney, new RandomGenerator(), manuallyLottoNumbers
        );
        outputView.printLotto(lottoService.getLottoNumberList(), countByPurchaseManually);

        List<Integer> winningNumbers = parser.parseTextToIntegetList(input.winningNumbers());
        int bonusNumber = Integer.parseInt(input.bonusNumber());
        lottoService.drawLotto(winningNumbers, bonusNumber);

        outputView.printStatistics(lottoService.totalWinningStatistics(),
            lottoService.returnRate());
    }
}
