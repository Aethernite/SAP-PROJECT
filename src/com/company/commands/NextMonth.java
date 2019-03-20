package com.company.commands;

import com.company.pages.MainMenuPage;
import com.company.utils.calendar.CalendarService;

public class NextMonth implements Command {
    private Command parent;

    public NextMonth(Command parent){
        this.parent = parent;
    }

    @Override
    public Command execute(){
        CalendarService.printNextMonth();
        return new MainMenuPage(this);
    }
}
