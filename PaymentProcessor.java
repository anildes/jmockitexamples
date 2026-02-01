package jmockitunexpectedinvocation;

class PaymentProcessor {

    private EmailService emailService;
    private AppLogger logger;

    public PaymentProcessor(EmailService emailService, AppLogger logger) {
        this.emailService = emailService;
        this.logger = logger;
    }

    public void processRefund(String userId, double amount) {
        logger.log("Refund started for " + userId);
        emailService.sendRefundEmail(userId, amount);
        logger.log("Refund completed for " + userId);
    }
}
