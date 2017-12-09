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
