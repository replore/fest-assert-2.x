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
package org.fest.assertions.api.iterable;

import static org.mockito.Mockito.verify;

import org.fest.assertions.api.AbstractIterableAssert;
import org.fest.assertions.api.ConcreteIterableAssert;
import org.fest.assertions.api.IterableAssertBaseTest;
import org.fest.assertions.core.Matcher;
import org.fest.assertions.core.TestMatcher;
import org.junit.BeforeClass;

/**
 * Tests for <code>{@link AbstractIterableAssert#doNotHaveAtLeast(org.fest.assertions.core.Matcher, int)}</code>.
 * 
 * @author Nicolas François
 */
public class IterableAssert_doNotHaveAtLeast_Test extends IterableAssertBaseTest {

  private static Matcher<Object> condition;

  @BeforeClass
  public static void beforeOnce() {
    condition = new TestMatcher<Object>();
  }

  @Override
  protected ConcreteIterableAssert<Object> invoke_api_method() {
    return assertions.doNotHaveAtLeast(2, condition);
  }

  @Override
  protected void verify_internal_effects() {
    verify(iterables).assertDoNotHaveAtLeast(getInfo(assertions), getActual(assertions), 2, condition);
  }
}
