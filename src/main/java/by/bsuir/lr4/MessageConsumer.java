package by.bsuir.lr4;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


@MessageDriven(mappedName = "topic")
public class MessageConsumer implements MessageListener {
    private static final String OUTPUT_FILE_PATH = "D:\\бугор\\3 курс, 2 сем\\РИС\\LR4\\src\\main\\resources\\out.txt";
    @EJB
    private MessageCollector messageCollector;
    @Resource
    MessageDrivenContext mdc;

    @Override
    public void onMessage(Message message) {
            try {
                String messageText = message.getBody(String.class);
                if(messageCollector.collectMessage(messageText)){
                    processCollectedMessages();
                    messageCollector.clear();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
    }

    public void processCollectedMessages() {
            String messageWithMaxVowels = messageCollector.getMessageWithMaxVowels();
            String messageWithMinVowels = messageCollector.getMessageWithMinVowels();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
                writer.write("Сообщение с максимальным количеством гласных:\n");
                writer.write(messageWithMaxVowels);

                writer.write("\n\nСообщение с минимальным количеством гласных:\n");
                writer.write(messageWithMinVowels);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
