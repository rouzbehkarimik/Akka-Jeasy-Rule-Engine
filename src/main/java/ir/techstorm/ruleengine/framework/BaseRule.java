package ir.techstorm.ruleengine.framework;

import akka.actor.ActorRef;
import ir.techstorm.ruleengine.example.factmessage.AccountOpeningParentStatusFactsMessage;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * Created by Rouzbeh Karimi
 * on 11/27/2017.
 */
@Rule
public abstract class BaseRule {

    private ActorRef actorToCall;

    public BaseRule(ActorRef actorToCall) {
        this.actorToCall = actorToCall;
    }

    public ActorRef getActorToCall() {
        return actorToCall;
    }

    private boolean isBaseRule() {
        return true;
    }

    public String toString() {
        return this.toString() + ":" + isBaseRule();
    }

    @Action
    public final void takeAction() {
        BaseFactsMessage factsMessage = takeRuleAction();

        if(factsMessage==null){
            getActorToCall().tell(new DoneMessage(null), getActorToCall());
        } else {
            getActorToCall().tell(factsMessage, getActorToCall());
        }
    }

    public abstract BaseFactsMessage takeRuleAction();


}
