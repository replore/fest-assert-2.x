/*
 * Created on Dec 16, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.assertions.api;

import junit.framework.Assert;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.test.ExpectedException.none;

/**
 * Tests for {@link BooleanArrayAssert#doesNotContain(boolean...).
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class BooleanArrayAssert_doesNotContain_Test {
  @Rule
  public ExpectedException thrown = none();
  private boolean[] actual = {true, true};
  private BooleanArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new BooleanArrayAssert(actual);
  }

  @Test
  public void should_return_this() {
    BooleanArrayAssert returned = assertions.doesNotContain(false);
    Assert.assertEquals(returned, assertions);
  }

  @Test
  public void should_pass_if_actual_doesNotContain_expected() {
    assertions.doesNotContain(false);
  }

  @Test
  public void should_fail_if_actual_contains_expected() {
    thrown.expect(AssertionError.class);
    assertions.doesNotContain(true);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    actual = null;
    assertions.doesNotContain(false);
  }

  @Test
  public void should_throw_error_if_actual_is_empty() {
    thrown.expect(AssertionError.class);
    actual = new boolean[0];
    assertions.doesNotContain(false);
  }
}
