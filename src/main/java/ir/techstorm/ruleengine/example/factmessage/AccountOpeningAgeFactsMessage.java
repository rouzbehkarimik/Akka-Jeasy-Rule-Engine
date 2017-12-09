package ir.techstorm.ruleengine.example.factmessage;

import ir.techstorm.ruleengine.example.rules.AccountOpeningAgeRule;
import ir.techstorm.ruleengine.framework.BaseFactsMessage;
import ir.techstorm.ruleengine.framework.annotation.FactMessage;
import org.jeasy.rules.api.Facts;

import java.io.Serializable;

/**
 * Created by Rouzbeh Karimi
 * on 11/25/2017.
 */
@FactMessage(validateBy = AccountOpeningAgeRule.class)
public class AccountOpeningAgeFactsMessage extends BaseFactsMessage implements Serializable {

    public AccountOpeningAgeFactsMessage(Facts fact) throws Exception {
        super(fact);
    }
}
