package ir.techstorm.ruleengine.framework;

import org.jeasy.rules.api.Facts;

import java.io.Serializable;

/**
 * Created by Rouzbeh Karimi
 * on 11/25/2017.
 */
public class DoneMessage extends BaseFactsMessage{

    public DoneMessage(Facts facts) {
        super(facts);
    }

}
