package dev.snowdrop.example;

import java.net.URL;

import io.dekorate.testing.annotation.Inject;
import io.dekorate.testing.openshift.annotation.OpenshiftIntegrationTest;

@OpenshiftIntegrationTest
public class OpenShiftIT extends AbstractExampleApplicationTest {

    @Inject
    private URL appUrl;

    @Override
    public String baseURI() {
        return appUrl.toString();
    }
}
