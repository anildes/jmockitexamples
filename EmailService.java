package jmockitunexpectedinvocation;

//--- The Classes under test ---

interface EmailService {
 void sendRefundEmail(String userId, double amount);
}
