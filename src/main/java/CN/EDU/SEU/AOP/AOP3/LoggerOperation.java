package CN.EDU.SEU.AOP.AOP3;

import CN.EDU.SEU.AOP.AOP1.Level;
import CN.EDU.SEU.AOP.AOP1.Logger;

import java.lang.reflect.Method;

/**
 * Created by LCN on 2016-10-22.
 */
public class LoggerOperation implements IOperation {
    public void end(Method method) {
        Logger.logging(Level.INFO, method.getName() + " Method end.");
    }

    public void start(Method method) {
        Logger.logging(Level.INFO, method.getName() + " Method Start!");
    }
}
