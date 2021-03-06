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

package jsinterop.core.css;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.core.css.enums.CssValueType;

/**
 * The CSSValue interface represents a simple or a complex value. A CSSValue object only occurs in a context
 * of a CSS property.
 *
 */
@JsType(isNative = true)
public interface CssValue {

    /**
     * @return A string representation of the current value.
     */
    @JsProperty
    String getCssText();

    /**
     * Used to set the string representation of the value
     *
     * @param arg A string representation value to set
     */
    @JsProperty
    void setCssText(String arg);

    /**
     * Returns the type of the value as defined above. Consider using {@link CssValueType} in your Java code
     *
     * @return The type of the value as defined above.
     * @see CssValueType
     */
    int getCssValueType();

}
