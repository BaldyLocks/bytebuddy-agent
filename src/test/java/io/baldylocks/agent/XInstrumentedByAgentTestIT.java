package io.baldylocks.agent;

import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class XInstrumentedByAgentTestIT {
    @Test
    @Ignore
    public void testInstrumentation() throws IOException {
        final HttpGet httpGetRequest = new HttpGet("http://localhost:8080");

        try (CloseableHttpResponse response = HttpClientBuilder.create().build().execute(httpGetRequest)) {

            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Assert.assertNotNull(response.getHeaders("X-Instrumented-By"));
            Assert.assertEquals(1, response.getHeaders("X-Instrumented-By").length);
            Assert.assertNotNull(response.getHeaders("X-Instrumented-By")[0]);
            Assert.assertNotNull(response.getHeaders("X-Instrumented-By")[0].getValue());
            Assert.assertEquals("Sqreen", response.getHeaders("X-Instrumented-By")[0].getValue());

        }
    }
}
