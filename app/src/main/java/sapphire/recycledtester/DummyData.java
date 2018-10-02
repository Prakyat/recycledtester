package sapphire.recycledtester;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/2/2018.
 */

public class DummyData {
    public static List<CityEvent> getData() {
        List<CityEvent> list = new ArrayList<>();

        list.add(new CityEvent("London", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Droidcon", "Droidcon in London", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Some event", "Some event in London", CityEvent.EVENT_TYPE));

        list.add(new CityEvent("Droidcon", "Droidcon in Amsterdam", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Berlin", null, CityEvent.CITY_TYPE));
        list.add(new CityEvent("Droidcon", "Droidcon in Berlin", CityEvent.EVENT_TYPE));
        list.add(new CityEvent("Amsterdam", null, CityEvent.CITY_TYPE));
        return list;
    }
}
