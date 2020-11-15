/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoneyCalculator.persistence;

import MoneyCalculator.model.Currency;
import java.util.List;

public interface CurrencyListLoader {
    public List<Currency> currencies();
}
