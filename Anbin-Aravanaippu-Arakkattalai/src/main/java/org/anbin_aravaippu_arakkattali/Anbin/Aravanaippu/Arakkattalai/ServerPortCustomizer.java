package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai;


import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;


import org.springframework.stereotype.Component;

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        String port = System.getenv("X_ZOHO_CATALYST_LISTEN_PORT");
        int listenPort;
        try {
            if (port != null && !port.isEmpty()) {
                listenPort = Integer.parseInt(port);
            } else {
                listenPort = 9000; // default for local run
            }
        } catch (NumberFormatException e) {
            listenPort = 9000; // fallback if env is invalid
        }
        factory.setPort(listenPort);
    }
}

