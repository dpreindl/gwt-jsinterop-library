/*
 * Copyright 2015 David Preindl <david.preindl@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jsinterop.jQuery;

import jsinterop.annotations.JsType;
import jsinterop.core.dom.Element;
import jsinterop.core.html.HtmlElement;
import jsinterop.core.util.CallbackFunction;

/**
 * JSInterop wrapper for jQuery library.
 */
@JsType(isNative = true)
public interface JQuery {

    /**
     * Set one or more CSS properties for the set of matched elements.
     *
     * @param property A CSS property name.
     * @param value A value to set for the property.
     * @return jQuery element
     */
    JQuery css(String property, String value);

    /**
     * Get the computed style properties for the first element in the set of matched elements.
     *
     * @param property A CSS property name.
     * @return The computed style properties
     */
    String css(String property);

    /**
     * Set the content of each element in the set of matched elements to the specified text.
     *
     * @param text The text to set as the content of each matched element. When Number or Boolean is supplied,
     *            it will be converted to a String representation.
     * @return jQuery element
     */
    JQuery text(String text);

    /**
     * Adds the specified class(es) to each element in the set of matched elements.
     *
     * @param style One or more space-separated classes to be added to the class attribute of each matched
     *            element.
     * @return jQuery element
     */
    JQuery addClass(String style);

    /**
     * Remove a single class, multiple classes, or all classes from each element in the set of matched
     * elements.
     *
     * @param classNameOne or more space-separated classes to be removed from the class attribute of each
     *            matched element.
     * @return jQuery element
     */
    JQuery removeClass(String className);

    /**
     * Get the value of an attribute for the first element in the set of matched elements.
     *
     * @param The name of the attribute to get.
     * @return The value of the given attribute
     */
    String attr(String attributeName);

    /**
     * Set one or more attributes for the set of matched elements.
     *
     * @param attributeName The name of the attribute to set.
     * @param value A value to set for the attribute.
     * @return jQuery element
     */
    JQuery attr(String attributeName, String value);

    /**
     * Remove an attribute from each element in the set of matched elements.
     *
     * @param attributeName An attribute to remove; as of version 1.7, it can be a space-separated list of
     *            attributes.
     * @return jQuery element
     */
    JQuery removeAttr(String attributeName);

    /**
     * Get the parent of each element in the current set of matched elements
     *
     * @return jQuery element representing the parent
     */
    JQuery parent();

    /**
     * Remove the set of matched elements from the DOM.
     *
     * @return jQuery element
     */
    JQuery remove();

    /**
     * Insert element, specified by the parameter, to the end of each element in the set of matched elements.
     *
     * @param element The element which should be inserted
     * @return jQuery element
     */
    JQuery append(Element element);

    /**
     * Insert element, specified by the parameter, to the end of each element in the set of matched elements.
     *
     * @param element The element which should be inserted
     * @return jQuery element
     */
    JQuery append(HtmlElement element);

    /**
     * Insert html, specified by the parameter, to the end of each element in the set of matched elements.
     *
     * @param html The html which should be inserted
     * @return jQuery element
     */
    JQuery append(String html);

    /**
     * Insert html, specified by the parameter, after each element in the set of matched elements.
     *
     * @param html The html which should be inserted
     * @return jQuery element
     */
    JQuery after(String html);

    /**
     * Insert element, specified by the parameter, after each element in the set of matched elements.
     *
     * @param element The element which should be inserted
     * @return jQuery element
     */
    JQuery after(HtmlElement element);

    /**
     * Insert content, specified by the parameter, before each element in the set of matched elements.
     *
     * @param element The element which should be inserted
     * @return jQuery element
     */
    JQuery before(HtmlElement element);

    /**
     * Attach a handler to an event for the elements.
     *
     * @param eventName A string containing one or more DOM event types, such as "click" or "submit," or
     *            custom event names.
     * @param function A function to execute each time the event is triggered.
     * @return jQuery element
     */
    JQuery bind(String eventName, ElementFunctionCallback function);

    /**
     * Bind an event handler to the "click" JavaScript event, or trigger that event on an element.
     *
     * @param clickHandler A function to execute each time the event is triggered.
     * @return jQuery element
     */
    JQuery click(CallbackFunction clickHandler);

    /**
     * Get the descendants of each element in the current set of matched elements, filtered by a selector
     *
     * @param selector A string containing a selector expression to match elements against.
     * @return jQuery element
     */
    JQuery find(String selector);

    /**
     * Get the descendants of each element in the current set of matched elements, filtered by an element.
     *
     * @param element An element or a jQuery object to match elements against.
     * @return jQuery element
     */
    JQuery find(JQuery element);

    /**
     * Hide the matched elements.
     *
     * @return jQuery element
     */
    JQuery hide();

    /**
     * Hide the matched elements.
     *
     * @param duration A string or number determining how long the animation will run.
     * @param completeCallback A function to call once the animation is complete, called once per matched
     *            element.
     * @return jQuery element
     */
    JQuery hide(int duration, CallbackFunction completeCallback);

    /**
     * Display the matched elements.
     *
     * @return jQuery element
     */
    JQuery show();

    /**
     * Display the matched elements.
     *
     * @param duration A string or number determining how long the animation will run.
     * @param completeCallback A function to call once the animation is complete, called once per matched
     *            element.
     * @return jQuery element
     */
    JQuery show(int duration, CallbackFunction completeCallback);

    /**
     * Remove all child nodes of the set of matched elements from the DOM.
     *
     * @return jQuery element
     */
    JQuery empty();

    /**
     * Get the current value of the first element in the set of matched elements.
     *
     * @return The value of the first matched element
     */
    String val();

    @JsType(isNative = true)
    public interface ElementFunctionCallback {

        void call(HtmlElement element);
    }

}
