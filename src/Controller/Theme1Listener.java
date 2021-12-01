package Controller;

import java.awt.event.ActionEvent;

public class Theme1Listener extends Settings{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("changed to theme1");
        setTheme(2);
        getThemeNumber();

    }
}
