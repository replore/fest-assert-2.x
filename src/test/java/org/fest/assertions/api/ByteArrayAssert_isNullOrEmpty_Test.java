/*
 * Created on Dec 17, 2010
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
 * Tests for <code>{@link ByteArrayAssert#isNullOrEmpty()}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ByteArrayAssert_isNullOrEmpty_Test {
  @Rule
  public ExpectedException thrown = none();
  private byte[] actual = null;
  private ByteArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new ByteArrayAssert(actual);
  }

  @Test
  public void should_return_this() {
    ByteArrayAssert returned = assertions.isNullOrEmpty();
    Assert.assertEquals(returned, assertions);
  }

  @Test
  public void should_pass_if_actual_is_null() {
    assertions.isNullOrEmpty();
  }

  @Test
  public void should_pass_if_actual_is_empty() {
    actual = new byte[0];
    assertions.isNullOrEmpty();
  }

  @Test
  public void should_fail_if_actual_is_not_null_and_not_empty() {
    thrown.expect(AssertionError.class);
    actual = new byte[1];
    assertions.isNullOrEmpty();
  }
}
