package CN.EDU.SEU.AOP.AOP3;

import java.lang.reflect.Method;

/**
 * Created by LCN on 2016-10-22.
 */
public interface IOperation {
    /**
     * 方法执行之前的操作
     *
     * @param method
     */
    void start(Method method);

    /**
     * 方法执行之后的操作
     *
     * @param method
     */
    void end(Method method);
}
