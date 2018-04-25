package publisher;

import java.util.HashSet;
import java.util.Set;
import subscriber.Subscriber;

public class PublisherImpl implements PublisherAdmin, Publisher {

    protected Set<Subscriber> subscriberSet;
    protected int numPublishers;
    protected String topic;
    
    public PublisherImpl(String topic){
        subscriberSet = new HashSet<Subscriber>();
        numPublishers = 1;
        this.topic = topic;
    }
    public int incPublishers(){
        return ++numPublishers;
    }
    public int decPublishers(){
        return --numPublishers;
    }
    public void attachSubscriber(Subscriber subscriber) {
        if(subscriber!=null)
            subscriberSet.add(subscriber);
    }
    public void detachSubscriber(Subscriber subscriber) {
        if(subscriber!=null && subscriberSet.contains(subscriber))
            subscriberSet.remove(subscriber);
    }
    public void detachAllSubscribers() {
        if (!subscriberSet.isEmpty())
            subscriberSet = new HashSet<Subscriber>();
    }
    public void publish(String topic, String event) {
        for (Subscriber subscriber:subscriberSet){
            subscriber.onEvent(topic, event);
        }
    }
}
