package ir.techstorm.ruleengine.example.rules;

import akka.actor.ActorRef;
import ir.techstorm.ruleengine.framework.BaseFactsMessage;
import ir.techstorm.ruleengine.framework.BaseRule;
import ir.techstorm.ruleengine.example.factmessage.AccountOpeningAgeFactsMessage;
import ir.techstorm.ruleengine.example.factmessage.AccountOpeningParentStatusFactsMessage;
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
@Rule(name = "account opening age rule", description = "if under 18 apply parent rules")
public class AccountOpeningAgeRule extends BaseRule {



    final private Logger log = LoggerFactory.getLogger(AccountOpeningAgeFactsMessage.class);

    public AccountOpeningAgeRule(ActorRef actorToCall) {
        super(actorToCall);
    }

    @Override
    public BaseFactsMessage takeRuleAction() {
        log.error("your parent are dead batman, they are dead!");
        Facts facts = new Facts();
        facts.put("areParentDead",true);

        return  new AccountOpeningParentStatusFactsMessage(facts);
    }


    @Condition
    public boolean isUnder18(@Fact("age") int age){
        return age < 18;
    }





}
