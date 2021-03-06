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

package jsinterop.core.css.enums;

/**
 * Possible font style attributes
 */
public enum FontStyle {

                       NORMAL("normal"),
                       ITALIC("italic"),
                       OBLIQUE("oblique");

    private String value;

    private FontStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * Parses the given value and returns the according FontStyle
     *
     * @param value The value to parse
     * @return The FontStyle for the given value
     */
    public static FontStyle fromString(String value) {
        FontStyle display = null;

        if (value != null) {
            for (FontStyle d : values()) {
                if (d.getValue().equalsIgnoreCase(value)) {
                    display = d;
                    break;
                }
            }
        }

        return display;
    }

}
