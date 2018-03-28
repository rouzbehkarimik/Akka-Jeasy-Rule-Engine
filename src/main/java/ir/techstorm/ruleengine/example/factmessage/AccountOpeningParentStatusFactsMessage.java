package ir.techstorm.ruleengine.example.factmessage;

import ir.techstorm.ruleengine.example.rules.AccountOpeningParentRule;
import ir.techstorm.ruleengine.framework.BaseAction;
import ir.techstorm.ruleengine.framework.BaseFactsMessage;
import ir.techstorm.ruleengine.framework.annotation.FactMessage;
import org.jeasy.rules.api.Facts;

import java.io.Serializable;

/**
 * Created by Rouzbeh Karimi
 * on 11/25/2017.
 */
@FactMessage(validateBy = AccountOpeningParentRule.class, finalAction = BaseAction.class)
public class AccountOpeningParentStatusFactsMessage extends BaseFactsMessage implements Serializable {

    public AccountOpeningParentStatusFactsMessage(Facts fact)  {
        super(fact);
    }
}
