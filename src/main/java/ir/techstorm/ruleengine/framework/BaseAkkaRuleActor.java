package ir.techstorm.ruleengine.framework;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import ir.techstorm.ruleengine.framework.annotation.FactMessage;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rouzbeh Karimi
 * on 11/27/2017.
 */
public class BaseAkkaRuleActor extends UntypedActor{
    final private Logger log = LoggerFactory.getLogger(BaseAkkaRuleActor.class);
    @SuppressWarnings("unchecked")
    public void onReceive(Object message) throws Exception{
        if (!(message instanceof BaseFactsMessage))
            throw new Exception("Not a Fact Message, Send Me Your Facts!");
        try {

            if (message instanceof DoneMessage){
                getContext().system().shutdown();
            }

            if (!message.getClass().isAnnotationPresent(FactMessage.class))
                throw  new Exception("No FactMessage Annotation Present");
            FactMessage factMessageAnnotation = message.getClass().getAnnotation(FactMessage.class);
            Rules rules = new Rules(factMessageAnnotation.validateBy().getDeclaredConstructor(ActorRef.class).newInstance(getSelf()));
            // fire rules on known facts
            RulesEngine rulesEngine = new DefaultRulesEngine();
            rulesEngine.fire(rules, ((BaseFactsMessage) message).getFacts());
        } catch (NullPointerException e){
            log.error("There is no rule for this type of message, please define a rule in MessageRuleMapper for "+message.getClass());
        }

    }
}
