package pl.android.informator.ui.events;

import androidx.databinding.ObservableField;

import pl.android.informator.base.BaseViewModel;
import pl.android.informator.models.Event;
import pl.android.informator.navigation.Navigator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventsViewModel extends BaseViewModel {
    public ObservableField<Navigator>navigator = new ObservableField<>();
    public ObservableField<List<Event>>events = new ObservableField<>();
    public void init() {
        List<Event>eventsList = new ArrayList<>();
        List<Date>calendars = new ArrayList<>();
        for (int i = 0; i <=30 ; i+=6) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH,i+2);
            calendars.add(calendar.getTime());
        }
        eventsList.add(new Event(
                1, "https://gfx.antyradio.pl/var/antyradio/storage/images/muzyka/koncerty/enigma-zagra-pierwszy-raz-w-polsce-w-2019-27308/1919440-1-pol-PL/Enigma-zagra-pierwszy-raz-w-Polsce-w-2019.-Zespol-zapowiedzial-7-koncertow_article.jpg",
                "Koncert",
                "Koncert zespołu XYZ, nie możesz tego ominąć. Wstęp od 10zł. Wpadaj, nie możesz tego przegapić",
                calendars.get(0)
        ));
        eventsList.add(new Event(
                2, "https://gfx.antyradio.pl/var/antyradio/storage/images/muzyka/koncerty/enigma-zagra-pierwszy-raz-w-polsce-w-2019-27308/1919440-1-pol-PL/Enigma-zagra-pierwszy-raz-w-Polsce-w-2019.-Zespol-zapowiedzial-7-koncertow_article.jpg",
                "Koncert",
                "Koncert zespołu XYZ, nie możesz tego ominąć. Wstęp od 10zł. Wpadaj, nie możesz tego przegapić." +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" +
                        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
                calendars.get(1)
        ));
        eventsList.add(new Event(
                3, "https://gfx.antyradio.pl/var/antyradio/storage/images/muzyka/koncerty/enigma-zagra-pierwszy-raz-w-polsce-w-2019-27308/1919440-1-pol-PL/Enigma-zagra-pierwszy-raz-w-Polsce-w-2019.-Zespol-zapowiedzial-7-koncertow_article.jpg",
                "Koncert",
                "Koncert zespołu XYZ, nie możesz tego ominąć. Wstęp od 10zł. Wpadaj, nie możesz tego przegapić",
                calendars.get(2)
        ));
        eventsList.add(new Event(
                4, "https://gfx.antyradio.pl/var/antyradio/storage/images/muzyka/koncerty/enigma-zagra-pierwszy-raz-w-polsce-w-2019-27308/1919440-1-pol-PL/Enigma-zagra-pierwszy-raz-w-Polsce-w-2019.-Zespol-zapowiedzial-7-koncertow_article.jpg",
                "Koncert",
                "Koncert zespołu XYZ, nie możesz tego ominąć. Wstęp od 10zł. Wpadaj, nie możesz tego przegapić",
                calendars.get(3)
        ));
        eventsList.add(new Event(
                5, "https://gfx.antyradio.pl/var/antyradio/storage/images/muzyka/koncerty/enigma-zagra-pierwszy-raz-w-polsce-w-2019-27308/1919440-1-pol-PL/Enigma-zagra-pierwszy-raz-w-Polsce-w-2019.-Zespol-zapowiedzial-7-koncertow_article.jpg",
                "Koncert",
                "Koncert zespołu XYZ, nie możesz tego ominąć. Wstęp od 10zł. Wpadaj, nie możesz tego przegapić",
                calendars.get(4)
        ));
        events.set(eventsList);
        navigator.set(getNavigator());
    }
    // TODO: Implement the ViewModel
}
