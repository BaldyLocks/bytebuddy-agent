package io.baldylocks.agent;

import static net.bytebuddy.matcher.ElementMatchers.named;

import java.lang.instrument.Instrumentation;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;

public class XInstrumentedByAgent {
    public static void premain(String arguments, Instrumentation instrumentation) {
        new AgentBuilder.Default()
            .type(named("org.apache.jasper.servlet.JspServlet"))
            .transform((builder, typeDescription, classLoader, module) -> builder
                .method(named("service"))
                .intercept(Advice.to(XInstrumentedByHeaderAdvice.class))
            ).installOn(instrumentation);
    }
}
