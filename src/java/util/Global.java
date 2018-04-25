package util;


import javax.enterprise.context.ApplicationScoped;
import topicmanager.TopicManager;
import topicmanager.TopicManagerImpl2;

/**
 *
 * @author upcnet
 */
@ApplicationScoped
public class Global {

  TopicManager topicManager;

  public Global() {
    topicManager = new TopicManagerImpl2();
  }
  
  public TopicManager getTopicManager(){
    return topicManager;
  }
}
