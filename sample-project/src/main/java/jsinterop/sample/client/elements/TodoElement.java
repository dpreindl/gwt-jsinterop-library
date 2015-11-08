package jsinterop.sample.client.elements;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.webcomponents.WebComponentElement;

/**
 * Representation of the public API of the todo-element.
 *
 */
@JsType(isNative = true)
public interface TodoElement extends WebComponentElement {

    /**
     * Returns the title/task of the element
     *
     * @return The title/task of the element
     */
    @JsProperty
    public String getTask();

    /**
     * Set the title/task of the element
     *
     * @param task The task to set
     */
    @JsProperty
    public void setTask(String task);

    /**
     * Returns whether the todo element is currently marked as completed
     *
     * @return Whether the todo element is currently marked as completed
     */
    @JsProperty(name = "completed")
    public boolean isCompleted();

    /**
     * Can be used to pass a {@link TodoCompleteCallback} to the todo element. This callback will be called
     * whenever a change of the complete state of the element is triggered.
     *
     * @param callback A callback which will be informed whenever the complete state of the element is
     *            changed.
     */
    public void setCompleteCallback(TodoCompleteCallback callback);

    /**
     * Method adds a new event listener to the todo element and expects a CustomEventObjectCallback.
     *
     * @param name The name of the event to listen to
     * @param callback The callback to add
     */
    public void addEventListener(String name, CustomObjectEventHandler<TodoElement> callback);

    /**
     * An event handler which expects a specified type of object to be passed.
     *
     * @param <R> The type of the event detail object
     */
    @JsFunction
    public interface CustomObjectEventHandler<R> {

        void eventFired(CustomEventObject<R> o);
    }

    /**
     * Represents an event object have a specified type as detail.
     *
     * @param <R> The type of the detail
     */
    @JsType(isNative = true)
    public interface CustomEventObject<R> {

        @JsProperty
        public R getDetail();
    }

    /**
     * The callback specified for the todo element.
     *
     */
    @JsType
    public interface TodoCompleteCallback {

        /**
         * This method will be called whenever the complete state of the todo element changes
         *
         * @param element The element for which the complete state has been changed. The current state can be
         *            retrieved using {@link TodoElement#getCompleted()}
         */
        void completed(TodoElement element);
    }

}
