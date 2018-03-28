package ir.techstorm.ruleengine.framework;

import akka.actor.ActorRef;
import ir.techstorm.ruleengine.example.factmessage.AccountOpeningParentStatusFactsMessage;
import ir.techstorm.ruleengine.framework.BaseFactsMessage;
import ir.techstorm.ruleengine.framework.BaseRule;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rouzbeh Karimi
 * on 11/27/2017.
 */
@Rule(name = "account opening age rule", description = "if under 18 apply parent rules")
public class NoRule extends BaseRule {


    final private Logger log = LoggerFactory.getLogger(this.getClass());

    public NoRule(ActorRef actorToCall) {
        super(actorToCall);
    }

    @Override
    public BaseFactsMessage takeRuleAction() {
        return null;
    }


    @Condition
    public boolean isLastStep() {
        return true;
    }


}
