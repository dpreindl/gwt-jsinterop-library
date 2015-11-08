package jsinterop.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class AppEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        SimpleView view = new SimpleView();

        RootPanel.get().add(view.asWidget());
    }

}
