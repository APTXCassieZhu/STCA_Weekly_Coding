import java.util.Map;
/* Build an app like ​https://www.thumbtack.com/​ where users can specify for what type of event and location they need a photographer. Search results will return a photographer profile with location, rates and types of events they specialize in.
# # Feel free to ask questions and document any assumptions.
# # Given a user’s preferences, generate a list of relevant search results containing a photographer’s profile, rate, and location.

# Now, let’s improve our application: Add a feature to rank photographers based on user reviews.

Input:
eventType: Wedding location San Jose
Output:
“Dream Weddings”, location=’San Jose, CA’, rate=$150, eventType: Wedding, Rehearsal Dinner, Bridal Shower
“Memorable Moments”, location=’San Jose, CA’, rate=$180, eventType: Wedding, 
Reception “XYZ Photographers ”, location=’San Jose, CA’, rate=$180, eventType: Corporate Events 
“Party Photographers ”, location=’San Jose, CA’, rate=$100, eventType: Birthday Parties “Beautiful weddings ”, location=’Dallas, TX’, rate=$100, eventType: Wedding*/
public class Photographer{
    class PhotographerFile{
        Map<Event, Integer> salary;
        int id;
        String name;
        Location location;
    }

    class Location{
        String state;
        String postcode;
        String city;
    }

    enum Event{
        Wedding,
        Birthday,
        Party,
        Business
    }

    List<PhotographerFile> files = new ArrayList<>();

    public List<PhotographerFile> SearchByEvent(Event e, int expectedMoney){
        Map<PhotographerFile, Integer> map = new HashMap<>();
        for(PhotographerFile file : files){
            if(file.salary.get(e) <= expectedMoney){
                map.put(file, file.salary.get(e));
            }
        }
        List<PhotographerFile> ans = new ArrayList<>(map.keySet());
        Collections.sort(ans, (a, b) -> map.get(a) - map.get(b));
        return ans;
    }
}