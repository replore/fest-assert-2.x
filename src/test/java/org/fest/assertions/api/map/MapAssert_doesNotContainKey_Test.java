/*
 * Created on Mar 29, 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2013 the original author or authors.
 */
package org.fest.assertions.api.map;

import static org.mockito.Mockito.verify;

import org.fest.assertions.api.MapAssert;
import org.fest.assertions.api.MapAssertBaseTest;

/**
 * Tests for <code>{@link org.fest.assertions.api.MapAssert#doesNotContainKey(Object)}</code>.
 * 
 * @author Nicolas François
 */
public class MapAssert_doesNotContainKey_Test extends MapAssertBaseTest {

  @Override
  protected MapAssert<Object, Object> invoke_api_method() {
    return assertions.doesNotContainKey("key1");
  }

  @Override
  protected void verify_internal_effects() {
    verify(maps).assertDoesNotContainKey(getInfo(assertions), getActual(assertions), "key1");
  }
}
