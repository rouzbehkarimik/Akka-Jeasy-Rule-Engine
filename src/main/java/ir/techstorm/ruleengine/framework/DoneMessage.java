package ir.techstorm.ruleengine.framework;

import ir.techstorm.ruleengine.example.rules.AccountOpeningParentRule;
import ir.techstorm.ruleengine.framework.annotation.FactMessage;
import org.jeasy.rules.api.Facts;

import java.io.Serializable;

/**
 * Created by Rouzbeh Karimi
 * on 11/25/2017.
 */
@FactMessage(validateBy = NoRule.class,finalAction = BaseAction.class)
public class DoneMessage extends BaseFactsMessage{

    public DoneMessage(Facts facts) {
        super(facts);
    }

}
