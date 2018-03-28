package ir.techstorm.ruleengine.framework;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import ir.techstorm.ruleengine.framework.annotation.FactMessage;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by Rouzbeh Karimi
 * on 11/27/2017.
 */
public class BaseAkkaRuleActor extends UntypedActor {
    final private Logger log = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("unchecked")
    public void onReceive(Object message) throws Exception {
        if (!(message instanceof BaseFactsMessage))
            throw new Exception("Not a Fact Message, Send Me Your Facts!");


        if (!message.getClass().isAnnotationPresent(FactMessage.class))
            throw new Exception("No FactMessage Annotation Present");


       FactMessage factMessageAnnotation = message.getClass().getAnnotation(FactMessage.class);
        Object object = factMessageAnnotation.validateBy().getDeclaredConstructor(ActorRef.class).newInstance(getSelf());
         for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Condition.class)) {
               log.error("{\"action\":\""+convertCamelCaseToPassage(method.getName())+"\"}");
            }
        }


        Rules rules = new Rules(object);

        if (message instanceof DoneMessage) {
            String action = (String) ((BaseFactsMessage) message).getFacts().get("Action");

            if (action == null) throw new Exception("Should have a Fact Named Action");

            BaseAction actionInstance = (BaseAction) factMessageAnnotation.finalAction().getDeclaredConstructor().newInstance();
            actionInstance.perform(action);

            getContext().system().terminate();
        }
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, ((BaseFactsMessage) message).getFacts());


    }


    private String convertCamelCaseToPassage(String name) {
        return name.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }

}
