package com.ControllersViews.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ControllersViews.models.Event;
import com.ControllersViews.models.Message;
import com.ControllersViews.models.User;
import com.ControllersViews.repositories.EventRepository;
import com.ControllersViews.repositories.MessageRepository;
import com.ControllersViews.repositories.UserRepository;

public class EventService {
	 
	    private final UserRepository userRepository;
	    private final MessageRepository messageRepository;
	    private final EventRepository eventRepository;
	
	


	
	
	public EventService(MessageRepository messageRepository, EventRepository eventRepository,
			UserRepository userRepository) {
		this.messageRepository = messageRepository;
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
	}
	 public Event createEvent(Event event,User planner){
	        event.setHostess(planner);
	        Date date = event.getDate();
	        SimpleDateFormat dateFormat=new SimpleDateFormat("MM dd,yyyy");
	        dateFormat.format(date);
	        event.setDate(date);
	        return eventRepository.save(event);
	    }
	 public Event findEvent(Long id){
	        Optional<Event> event =eventRepository.findById(id);
	        if(event.isPresent()) {
	            return event.get();
	        } else {
	            return null;
	        }
	    }
	 public User findUserById(Long id) {
	    	Optional<User> u = userRepository.findById(id);
	    	
	    	if(u.isPresent()) {
	            return u.get();
	    	} else {
	    	    return null;
	    	}
	    }
	 public int countByJoinedUsers(Long id){

	        Event event=eventRepository.findById(id).orElse(null);
	        List<User> joinedUsers =event.getUsersAttending();
	        int count=0;
	        for(int i=0;i<joinedUsers.size();i++){
	            count++;
	        }
	        return count;
	    }
	 public void joinEvent(Long event_id,Long user_id){
	        User user = userRepository.findById(user_id).orElse(null);
	        Event event = eventRepository.findById(event_id).orElse(null);
	        List<User> users = event.getUsersAttending();
	        users.add(user);
	        event.setUsersAttending(users);
	        eventRepository.save(event);
	    }
	 public void cancelEvent(Long event_id,Long user_id){
	        User user = userRepository.findById(user_id).orElse(null);
	        Event event = eventRepository.findById(event_id).orElse(null);
	        List<User> users = event.getUsersAttending();
	        users.remove(user);
	        event.setUsersAttending(users);
	        eventRepository.save(event);
	    }
	 public void updateEvent(Event event){
	        Event event1 = eventRepository.findById(event.getId()).orElse(null);
	        assert event1 != null;
	        event1.setName(event.getName());
	        event1.setDate(event.getDate());
	        event1.setCity(event.getCity());
	        event1.setState(event.getState());
	        eventRepository.save(event1);
	    }
	 
	 public List<Event> allEventsWithState(String state){
	        return eventRepository.findAllByState(state);
	    }
	 
	 public List<Event> allEventsWithoutState(String state){
	        return eventRepository.findByStateNot(state);
	    }
	 
	 public void deleteEvent(Long id){
	        Event event=eventRepository.findById(id).orElse(null);
	        List<Message> messages = event.getMessages();
	        List<User> users = event.getUsersAttending();
	        for(Message msg:messages){
	            messageRepository.deleteById(msg.getId());
	        }
	        for(User usr:users){
	            users.remove(usr);
	        }
	        eventRepository.deleteById(id);
	    }
	 
	 
	 public Message createMessage(Message message,Long event_id,Long user_id){
	        User user = userRepository.findById(user_id).orElse(null);
	        Event event = eventRepository.findById(event_id).orElse(null);
	        return messageRepository.save(new Message(message.getComment(),user,event));
	    }
	 


}
