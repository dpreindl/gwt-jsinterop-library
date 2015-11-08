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

package jsinterop.core.dom;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.core.css.CssStyleDeclaration;

@JsType(isNative = true)
public interface Element extends Node, NodeSelector {

    /**
     * Getter for innerHTML attribute
     *
     * @return The markup of the element's content.
     */
    @JsProperty
    public String getInnerHTML();

    /**
     * Setter for innerHTML attribute
     *
     * @param s The markup of the element's content.
     */
    @JsProperty
    public void setInnerHTML(String s);

    /**
     * Getter for classList attribute
     *
     * @return The list of class attributes.
     */
    @JsProperty
    public DomTokenList getClassList();

    @JsProperty
    public CssStyleDeclaration getStyle();

    /**
     * Adds a new attribute or changes the value of an existing attribute on the specified element.
     *
     * @param name The name of the attribute as a string.
     * @param value The desired new value of the attribute.
     */
    public void setAttribute(String name, Object value);

    /**
     * Returns the value of a specified attribute on the element. If the given attribute does not exist, the
     * value returned will either be null or ""
     *
     * @param name The name of the attribute whose value you want to get.
     * @return The value of a specified attribute on the element or null
     */
    public String getAttribute(String name);

    /**
     * Method returns whether the current element has the specified attribute
     *
     * @param name A string representing the name of the attribute.
     * @return Indicates whether the current element has the specified attribute
     */
    public boolean hasAttribute(String name);

    /**
     * Removes an attribute from the specified element.
     *
     * @param name The name of the attribute to be removed from element.
     */
    public void removeAttribute(String name);

}
