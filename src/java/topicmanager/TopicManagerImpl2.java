package topicmanager;

import publisher.Publisher;
import publisher.PublisherImpl2;

public class TopicManagerImpl2 extends TopicManagerImpl {

    public Publisher addPublisherToTopic(String topic){        
        if(topicMap.containsKey(topic)){            
            topicMap.get(topic).incPublishers();
            return (Publisher)topicMap.get(topic);
        }
        else {
            topicMap.put(topic,new PublisherImpl2(topic));
            return (Publisher)topicMap.get(topic);
        }
    }

    public Publisher publisher(String topic){
      return topicMap.get(topic);
    }
}