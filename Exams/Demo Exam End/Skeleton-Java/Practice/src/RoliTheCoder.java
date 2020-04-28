import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoliTheCoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Event> events = new LinkedHashMap<>();
        List<String> allEvents = new ArrayList<>();
        while (!line.equals("Time for Code")) {
            String[] input = line.split("\\s+");
            String id = input[0];
            Pattern pattern = Pattern.compile("(?<=#).+");
            Matcher matcher = pattern.matcher(input[1]);
            String eventName = "";
            Pattern name = Pattern.compile("@[a-zA-Z-0-9']+$");
            if (matcher.find()) {
                eventName = matcher.group();
                Event event = new Event(eventName, new ArrayList<>());
                for (int i = 2; i < input.length; i++) {
                    if (!event.getParticipants().contains(input[i])) {
                        Matcher matcherName = name.matcher(input[i]);
                        if (matcherName.find()) {
                            event.addParticipant(input[i]);
                        }
                    }
                }
                if (!events.containsKey(id)&&!allEvents.contains(eventName)) {
                        events.put(id, event);
                        allEvents.add(eventName);
                } else {
                    if (events.get(id).getEventName().equals(event.getEventName())){
                        for (int i = 2; i < input.length; i++) {
                            if (!events.get(id).getParticipants().contains(input[i])) {
                                Matcher matcherName = name.matcher(input[i]);
                                if (matcherName.find()) {
                                    events.get(id).addParticipant(input[i]);
                                }
                            }
                        }
                    }
                }
            }

            line = scanner.nextLine();
        }
        events.entrySet().stream().sorted((e1,e2)->{
            int result = Integer.compare(e2.getValue().getParticipants().size(), e1.getValue().getParticipants().size());
            if (result==0){
                result = e1.getValue().getEventName().compareTo(e2.getValue().getEventName());
            }
            return result;
        }).forEach(e-> {
            System.out.println(e.getValue().getEventName()+" - "+e.getValue().getParticipants().size());
            e.getValue().getParticipants().stream().sorted((e1,e2)->{
                int result = e1.toLowerCase()
                .compareTo(e2.toLowerCase());
                return result;
            }).forEach(a-> System.out.println(a));
        });
    }
}

class Event {
    private String eventName;
    private List<String> participants;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public Event() {
    }

    public Event(String eventName, List<String> participants) {
        this.eventName = eventName;
        this.participants = participants;
    }

    public void addParticipant(String participant) {
        this.participants.add(participant);
    }
}
