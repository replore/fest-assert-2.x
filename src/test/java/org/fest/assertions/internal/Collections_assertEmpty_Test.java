/*
 * Created on Apr 23, 2013
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
package org.fest.assertions.internal;

import static java.util.Collections.emptyList;

import static org.fest.assertions.error.ShouldBeEmpty.shouldBeEmpty;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.fest.util.Collections.list;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Collection;

import org.fest.assertions.description.Description;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class Collections_assertEmpty_Test {

  @Rule
  public ExpectedException thrown = none();

  private Failures failures;
  private Collections collections;
  private Description description;

  @Before
  public void setUp() {
    failures = spy(new Failures());
    collections = new Collections();
    collections.failures = failures;
  }

  @Test
  public void should_pass_if_actual_is_empty() {
    collections.assertEmpty(description, emptyList());
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class, actualIsNull());
    collections.assertEmpty(description, null);
  }

  @Test
  public void should_fail_if_actual_has_elements() {
    Collection<String> actual = list("Yoda");
    try {
      collections.assertEmpty(description, actual);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldBeEmpty(actual));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }
}
