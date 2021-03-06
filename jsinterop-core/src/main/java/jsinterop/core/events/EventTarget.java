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

package jsinterop.core.events;

import jsinterop.annotations.JsType;

@JsType(isNative = true)
public interface EventTarget {

    /**
     * Register an event handler of a specific event type on the
     * <code>EventTarget</code>.
     *
     * @param type A string representing the event type to listen for.
     * @param listener The object that receives a notification when an event of the specified type occurs.
     */
    void addEventListener(String type, EventListener listener);

    /**
     *
     * Dispatch an event to this <code>EventTarget</code>.
     *
     * @param event The event to dispatch
     */
    boolean dispatchEvent(Event event);

    /**
     * Removes an event listener from the <code>EventTarget</code>.
     *
     * @param type A string representing the event type to remove.
     * @param listener The EventListener function to remove from the event target.
     */
    void removeEventListener(String type, EventListener listener);

}
