package dev.snowdrop.example;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import io.dekorate.testing.annotation.Inject;
import io.dekorate.testing.annotation.KubernetesIntegrationTest;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.LocalPortForward;

@DisabledIfSystemProperty(named = "unmanaged-test", matches = "true")
@KubernetesIntegrationTest
public class ManagedKubernetesIT extends AbstractExampleApplicationTest {
    @Inject
    KubernetesClient client;

    LocalPortForward appPort;

    @BeforeEach
    public void setup() {
        appPort = client.services().inNamespace(System.getProperty("kubernetes.namespace"))
                .withName("spring-boot-rest").portForward(8080);
    }

    @AfterEach
    public void tearDown() throws IOException {
        if (appPort != null) {
            appPort.close();
        }
    }

    @Override
    public String baseURI() {
        return "http://localhost:" + appPort.getLocalPort() + "/";
    }
}
