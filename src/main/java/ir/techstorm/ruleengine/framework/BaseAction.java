package ir.techstorm.ruleengine.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseAction {

    final private Logger log = LoggerFactory.getLogger(this.getClass());
    public void perform(String jsonAsString){
        log.error(jsonAsString);
    }

}
