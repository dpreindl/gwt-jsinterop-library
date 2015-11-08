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

package jsinterop.webcomponents;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.webcomponents.WebComponentsUtils.WebcomponentsResolover;

/**
 * Represents the WebComponents JavaScript object. To get a reference to the object use
 * {@link WebcomponentsResolover#webcomponents}
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public interface WebComponents {

    @JsProperty
    public Flags getFlags();

    @JsType(isNative = true)
    public class Flags {

        @JsProperty
        public Boolean shadow;

    }

}
