package publisher;

import subscriber.Subscriber;
import subscriber.SubscriberImpl;

public class PublisherImpl2 extends PublisherImpl implements PublisherAdmin, Publisher {
    
    public PublisherImpl2(String topic){
      super(topic);
    }
    @Override
    public void detachSubscriber(Subscriber subscriber) {
        //this sentence is useless, hence commented, because 
        //at the client the subscription has already been detached:
        //subscriber.onClose(topic,"SUBSCRIBER");
        for(Subscriber local_subscriber : subscriberSet){
          SubscriberImpl local_subscriberImpl = (SubscriberImpl)local_subscriber;
          SubscriberImpl subscriberImpl = (SubscriberImpl)subscriber;
          if(local_subscriberImpl.session == subscriberImpl.session){
            subscriberSet.remove(local_subscriber);
            System.out.println("subscriber detached");
            break;
          }
        }
    }
}
