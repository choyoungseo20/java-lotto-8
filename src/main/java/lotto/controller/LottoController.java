package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        List<Lotto> purchasedLottos = lottoService.createLottos(purchaseAmount);
        outputView.printPurchasedLottos(purchasedLottos);

        WinningLotto winningLotto = readWinningLotto();
        WinningResult winningResult = lottoService.checkWinning(purchasedLottos, winningLotto);
        double rateOfReturn = lottoService.calculateRateOfReturn(purchaseAmount, winningResult);
        outputView.printResult(winningResult, rateOfReturn);
    }

    private PurchaseAmount readPurchaseAmount() {
        Integer purchaseAmount = inputView.readPurchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }

    private WinningLotto readWinningLotto() {
        Lotto mainNumbers = readMainWinningLottoNumbers();
        Integer bonusNumber = readBonusWinningLottoNumber();
        return new WinningLotto(mainNumbers, bonusNumber);
    }

    private Lotto readMainWinningLottoNumbers() {
        List<Integer> mainWinningLottoNumbers = inputView.readMainWinningLottoNumbers();
        return new Lotto(mainWinningLottoNumbers);
    }

    private Integer readBonusWinningLottoNumber() {
        return inputView.readBonusWinningLottoNumber();
    }
}
