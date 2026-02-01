package jmockitunexpectedinvocation;

import mockit.*;
import org.junit.Test;

public class PaymentTest {

    @Test
    public void testUnexpectedLoggerCall(
            @Injectable EmailService emailService,
            @Injectable AppLogger logger) {

        PaymentProcessor processor =
                new PaymentProcessor(emailService, logger);

        // Only allow ONE log call
        new Expectations(logger) {{
            logger.log("Refund started for user1");
        }};

        // This method calls log() TWICE → second one is unexpected
        processor.processRefund("user1", 100.0);
    }
}
