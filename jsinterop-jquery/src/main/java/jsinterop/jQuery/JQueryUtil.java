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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.core.html.HtmlElement;

public class JQueryUtil {

    private static final String ID_SELECT_PREFIX = "#";
    private static final String ATTRIBUTE_DISABLED = "disabled";
    private static final String ATTRIBUTE_VALUE_TRUE = "true";

    /**
     * Return a collection of matched elements either found in the DOM based on passed argument
     *
     * @param selector A string containing a selector expression
     * @return jQuery element of matched elements
     */
    @JsMethod(namespace = JsPackage.GLOBAL, name = "$")
    public static native JQuery $(String selector);

    /**
     * Wraps the given element into a jQuery object
     *
     * @param element A DOM element to wrap in a jQuery object.
     * @return jQuery object of the given element
     */
    @JsMethod(namespace = JsPackage.GLOBAL, name = "$")
    public static native JQuery $(HtmlElement element);

    /**
     * Return a collection of matched elements either found in the DOM based on passed argument
     *
     * @param selector A string containing a selector expression
     * @param context The HtmlElement to use as context
     * @return jQuery element of matched elements
     */
    @JsMethod(namespace = JsPackage.GLOBAL, name = "$")
    public static native JQuery $(String selector, HtmlElement context);

    /**
     * Return a collection of matched elements either found in the DOM based on passed argument
     *
     * @param selector A string containing a selector expression
     * @param context A jQuery object used as context for the selection
     * @return jQuery element of matched elements
     */
    @JsMethod(namespace = JsPackage.GLOBAL, name = "$")
    public static native JQuery $(String selector, JQuery context);

    /**
     * Helper method to easily modify the disabled attribute of an given element
     *
     * @param element The element to modify the disabled attribute for
     * @param enabled Indicates whether the given element should be enabled
     */
    public static void setEnabled(HtmlElement element, boolean enabled) {
        if (enabled) {
            $(element).removeAttr(ATTRIBUTE_DISABLED);
        } else {
            $(element).attr(ATTRIBUTE_DISABLED, ATTRIBUTE_VALUE_TRUE);
        }
    }

    /**
     * Helper method to select an element using the id property.
     *
     * @param id The id used to select the element.
     * @param context The (optional) context to use. This may be null
     * @return jQuery element of matched elements
     */
    public static JQuery selectById(String id, HtmlElement context) {
        if (id == null || id.isEmpty()) {
            return $(id);
        }
        JQuery result = null;
        String idSelector = prepareIdSelector(id);

        if (context != null) {
            result = $(idSelector, context);
        } else {
            result = $(idSelector);
        }

        return result;
    }

    private static String prepareIdSelector(final String id) {
        String escapedId = id.replaceAll("\\.", "\\\\.");

        if (!escapedId.startsWith(ID_SELECT_PREFIX)) {
            escapedId = ID_SELECT_PREFIX + escapedId;
        }

        return escapedId;
    }

}
