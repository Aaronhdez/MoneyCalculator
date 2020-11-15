package MoneyCalculator.control;

import MoneyCalculator.model.Currency;
import MoneyCalculator.model.CurrencyList;
import MoneyCalculator.persistence.rest.RestExchangeRateLoader;
import moneycalculator.model.ExchangeRate;
import moneycalculator.view.MoneyCalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private MoneyCalculatorView frame;
    private RestExchangeRateLoader loader;

    public Controller(MoneyCalculatorView MoneyCalculatorView) {
        this.frame = MoneyCalculatorView;
    }


    public void initialize() {
        loader = new RestExchangeRateLoader();
        frame.setCurrencySet(new CurrencyList().getList());
        frame.initialize();
        JButton buttonCalculate = (JButton)frame.getMyComponents().get("CalculateButton");
        JButton buttonClear = (JButton)frame.getMyComponents().get("ClearButton");
        JComboBox toCurrency = (JComboBox)frame.getMyComponents().get("SelectorTo");
        JTextField amountField = (JTextField)frame.getMyComponents().get("Amount");
        JTextField resultArea = (JTextField)frame.getMyComponents().get("Result");

        buttonCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ExchangeRate er = loader.load((Currency)toCurrency.getSelectedItem());
                Double amount = Double.parseDouble(amountField.getText());
                Double result = amount * er.getRate();
                resultArea.setText(result.toString());
            }
        });
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                amountField.setText("");
                resultArea.setText("");
            }
        });
    }
}