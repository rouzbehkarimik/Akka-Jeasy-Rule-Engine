# Akka-Jeasy-Rule-Engine
An akka-jeasy integrated rule engine library which its goal is to implement rule engine in a non blocking manner.

## How to get Started with AJRE:
1. Create A message to carry your facts to BaseAkkaRuleActor in that message. this class extends BaseFactsMessage.class and implements Serializable. apply an @FactMessage(validateBy = YourRuleClass.class) to it at class level. 
2. Create YourRuleClass and apply @Rule at class level and specify an @Condition method. also implement the takeRuleAction() method.
3. Finally in your main class main method add following lines:
```
        ActorSystem system = ActorSystem.create("worldSystem");
        ActorRef baseAkkaRuleActor = system.actorOf(Props.create(BaseAkkaRuleActor.class),"baseAkkaRuleActor");
      
        // create your facts
        Facts facts= new Facts();
        facts.put("age",17);

        try {
            // pass the apropriate Fact Message to baseAkkaRuleActor
            baseAkkaRuleActor.tell(new AccountOpeningAgeFactsMessage( facts),ActorRef.noSender());
        } catch (Exception e) {
            e.printStackTrace();
            }
```
now run the code, Tada! you have a non blocking rule engine.
