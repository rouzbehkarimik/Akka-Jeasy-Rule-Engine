package ir.techstorm.ruleengine.example.rules;

import akka.actor.ActorRef;
import ir.techstorm.ruleengine.framework.BaseFactsMessage;
import ir.techstorm.ruleengine.framework.BaseRule;
import ir.techstorm.ruleengine.example.factmessage.AccountOpeningAgeFactsMessage;
import ir.techstorm.ruleengine.framework.DoneMessage;
import org.jeasy.rules.annotation.Action;
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
@Rule(name = "account opening parent status rule", description = "if batman don't look for parents")
public class AccountOpeningParentRule extends BaseRule {
    final private Logger log = LoggerFactory.getLogger(this.getClass());

    public AccountOpeningParentRule(ActorRef actorToCall) {
        super(actorToCall);
    }


    @Condition
    public boolean areParentDead(@Fact("areParentDead") boolean areParentDead){
        return areParentDead;
    }


    @Override
    public BaseFactsMessage takeRuleAction() {
        log.error("{\"action\":\"but there goes your grumpy uncle rafael!\"");
        Facts facts = new Facts();
        facts.put("Action","{\"action\":\"my job is done here\"}");
        return new DoneMessage(facts);
    }
}
