package jsinterop.sample.client;

import static jsinterop.core.dom.Document.DocumentUtil.document;
import static jsinterop.jQuery.JQueryUtil.$;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;

import jsinterop.core.css.CssStyleDeclaration;
import jsinterop.core.events.Event;
import jsinterop.core.events.Event.Events;
import jsinterop.core.html.HtmlElement;
import jsinterop.core.html.Window;
import jsinterop.jQuery.JQueryUtil;
import jsinterop.sample.client.elements.TodoElement;
import jsinterop.sample.client.elements.TodoElement.CustomEventObject;
import jsinterop.webcomponents.WebComponentsUtils;

public class SimpleView extends UIObject implements IsWidget {

    private static SimpleViewUiBinder uiBinder = GWT.create(SimpleViewUiBinder.class);

    interface SimpleViewUiBinder extends UiBinder<Widget, SimpleView> {}

    @UiField
    TodoElement todoElement;

    @UiField
    HtmlElement changeTextButton;

    private Widget widget;

    public SimpleView() {
        initWidget();

        changeTextButton.addEventListener(Events.CLICK, e -> updateButtonText());

        /*
         * here we are using 2 different addEventListener methods - calling those method would be possible
         * without the tryWebComponentMethod hack
         */
        todoElement.addEventListener("edit", (Event e) -> Window.alert("edit is not yet handled!"));
        todoElement.addEventListener("complete",
                                     (CustomEventObject<TodoElement> o) -> handleCompleteEvent(o));

        /*
         * as we are not only setting eventListeners (which would be possible even for not upgraded elements)
         * we need to wait for Polymer to upgrade the custom elements
         */
        WebComponentsUtils.tryWebComponentMethod(todoElement, () -> polymerInitialized());
    }

    @SuppressWarnings("deprecation")
    private void initWidget() {
        widget = uiBinder.createAndBindUi(this);
        setElement(widget.getElement());
    }

    @Override
    public Widget asWidget() {
        return widget;
    }

    protected void polymerInitialized() {
        /* let's start with changing the name of the task - why? - because we can ;-) */
        todoElement.setTask("GWT-Task");

        /* let's add a callback - this will be called directly from javascript of the todo-element */
        todoElement.setCompleteCallback(element -> handleCompleteCallback(element));
    }

    private void handleCompleteCallback(TodoElement element) {
        updateBackground(element);
        Window.getConsole().log("CompleteCallback has been called - Maybe handle this in future?");
    }

    private void updateBackground(TodoElement element) {
        if (element.isCompleted()) {
            /* without jquery */
            CssStyleDeclaration style = document.getElementById("taskindicator").getStyle();
            style.setProperty("color", "blue");
            style.setProperty("font-weight", "bold");
            document.getElementById("taskstatus").setInnerText(getStatus(element));
        } else {
            /* let's try jquery */
            JQueryUtil.selectById("taskindicator", null).css("color", "red").css("font-weight", "bold");
            $("#taskstatus").text(getStatus(element));
        }
    }

    private void updateButtonText() {
        changeTextButton.setInnerText($("#changeTextInput").val());
    }

    private void handleCompleteEvent(CustomEventObject<TodoElement> event) {
        TodoElement element = event.getDetail();
        Window.alert("Hi there from CustomEventObject - New Status of the element: " + getStatus(element));
    }

    private String getStatus(TodoElement element) {
        return element != null && element.isCompleted() ? "Completed" : "Still open";
    }

}
