package ir.techstorm.ruleengine.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import ir.techstorm.ruleengine.example.factmessage.AccountOpeningAgeFactsMessage;
import ir.techstorm.ruleengine.framework.BaseAkkaRuleActor;
import org.jeasy.rules.api.Facts;

/**
 * Created by Rouzbeh Karimi
 * on 11/27/2017.
 *
 * ==============================================================
 * first create your rules by extending BaseRule class, don't forget to implement @Condition method.
 * then create your akka-jeasy message extending BaseFactsMessage and don't forget to implement Serializable.
 * Finally you should add Relation between Message Types and Rules in MessageRuleMapper Enum
 */
public class Main {
    public static void main(String[] args) {



        ActorSystem system = ActorSystem.create("worldSystem");
        ActorRef coolGuy = system.actorOf(Props.create(BaseAkkaRuleActor.class),"coolGuy");

        Facts facts= new Facts();
        facts.put("age",17);


        try {
            coolGuy.tell(new AccountOpeningAgeFactsMessage( facts),ActorRef.noSender());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
