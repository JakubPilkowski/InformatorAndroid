package com.example.informator.ui.events;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.informator.base.BaseViewModel;
import com.example.informator.models.Event;
import com.example.informator.navigation.Navigator;

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
                "https://www.wykop.pl/cdn/c3201142/comment_prwD69GDKVA1nwaqSd2kHZELy1mLwc9H.jpg",
                "Zadymka u Majkuta",
                "Dużo będzie się działo, wybuchery, gigaakcja",
                calendars.get(0)
        ));
        eventsList.add(new Event(
                "https://www.wykop.pl/cdn/c3201142/comment_prwD69GDKVA1nwaqSd2kHZELy1mLwc9H.jpg",
                "Zadymka u Majkuta",
                "Dużo będzie się działo, wybuchery, gigaakcja",
                calendars.get(1)
        ));
        eventsList.add(new Event(
                "https://www.wykop.pl/cdn/c3201142/comment_prwD69GDKVA1nwaqSd2kHZELy1mLwc9H.jpg",
                "Zadymka u Majkuta",
                "Dużo będzie się działo, wybuchery, gigaakcja",
                calendars.get(2)
        ));
        eventsList.add(new Event(
                "https://www.wykop.pl/cdn/c3201142/comment_prwD69GDKVA1nwaqSd2kHZELy1mLwc9H.jpg",
                "Zadymka u Majkuta",
                "Dużo będzie się działo, wybuchery, gigaakcja",
                calendars.get(3)
        ));
        eventsList.add(new Event(
                "https://www.wykop.pl/cdn/c3201142/comment_prwD69GDKVA1nwaqSd2kHZELy1mLwc9H.jpg",
                "Zadymka u Majkuta",
                "Dużo będzie się działo, wybuchery, gigaakcja",
                calendars.get(4)
        ));
        events.set(eventsList);
        navigator.set(getNavigator());
    }
    // TODO: Implement the ViewModel
}
