package ir.techstorm.ruleengine.framework;

import org.jeasy.rules.api.Facts;

import java.io.Serializable;

/**
 * Created by Rouzbeh Karimi
 * on 11/25/2017.
 */
public class BaseFactsMessage implements Serializable{
    private Facts facts;

    protected BaseFactsMessage(Facts facts)  {
        this.facts = facts;

    }

    public Facts getFacts() {
        return this.facts;
    }
}
