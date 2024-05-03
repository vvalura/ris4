package by.bsuir.lr4;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Stateless
public class MessageProducer {
    @Resource
    private ConnectionFactory connectionFactory;

    @Resource
    private Destination destination;

    public void sendMessage(String message) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            javax.jms.MessageProducer messageProducer = session.createProducer(destination);

            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(message);

            messageProducer.send(objectMessage);
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
