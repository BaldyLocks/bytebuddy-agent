package io.baldylocks.agent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.asm.Advice;

public class XInstrumentedByHeaderAdvice {

    @Advice.OnMethodExit
    public static void addHeaderToResponse(@Advice.Origin String method, @Advice.AllArguments Object[] params)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (Object param : params) {
            if (param.getClass().getName().equals("org.apache.catalina.connector.ResponseFacade")) {
                Method setHeaderMethod = param.getClass().getMethod("setHeader", String.class, String.class);
                setHeaderMethod.invoke(param, "X-Instrumented-By", "Sqreen");
            }
        }
    }

}
