package myproject.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	/*private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("1","First Topic","First Description"),
			new Topic("2","Second Topic","Second Description"),
			new Topic("3","Third Topic","Third Description"),
			new Topic("4","Fourth Topic","Fourth Description")
			));
	*/
	@Autowired
	TopicRepository topicRepository;
	
	
	public List<Topic> getAllTopics() {
		return (List<Topic>) topicRepository.findAll();
	}
	
	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);
		//return topics.stream().filter(s -> s.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(List<Topic> topic) {
		topicRepository.saveAll(topic);
		//topics.addAll(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		topic.setId(id);
		topicRepository.save(topic);
		/*for(Topic t : topics) {
			if(t.getId().equals(id)) {
				t.setId(topic.getId());
				t.setName(topic.getName());
				t.setDesc(topic.getDesc());
			}
		}*/
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);;
		
		//topics.removeIf(t -> t.getId().equals(id));
		
	}

}