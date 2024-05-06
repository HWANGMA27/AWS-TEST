package test.aws.mq;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RabbitMqService {
    private static final String queueName = "direct-test";
    private static final String exchangeName = "direct-test-exchange";
    private final RabbitTemplate rabbitTemplate;
//
//    public RabbitMqService(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }

//    @Override
//    public void run(String... args) {
//        System.out.println("-----------------------------");
//        System.out.println("Sending message...");
//        System.out.println("-----------------------------");
//        CustomMessage message = new CustomMessage("Hello Message!", 1, true);
//        rabbitTemplate.convertAndSend(topicExchange, "foo.bar.baz", message);
//    }

    /**
     * 1. Queue 로 메세지를 발행
     * 2. Producer 역할 -> Direct Exchange 전략
     **/
    public void sendMessage(CustomMessage messageDto) {
        System.out.println("-----------------------------");
        System.out.println("Sending message...");
        this.rabbitTemplate.convertAndSend(exchangeName,"foo.bar.baz",messageDto);
        System.out.println("-----------------------------");
    }

    /**
     * 1. Queue 에서 메세지를 구독
     **/
    @RabbitListener(queues = queueName)
    public void receiveMessage(CustomMessage messageDto) {
        System.out.println("-----------------------------");
        System.out.println("Receive message...");
        System.out.println("Received Message : " + messageDto.toString());
        System.out.println("-----------------------------");
    }

}