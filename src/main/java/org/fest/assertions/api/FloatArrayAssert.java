/*
 * Created on Dec 20, 2010
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
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.assertions.api;

import org.fest.assertions.core.EnumerableAssert;
import org.fest.assertions.core.IndexedObjectEnumerableAssert;
import org.fest.assertions.data.Index;
import org.fest.assertions.description.Description;
import org.fest.assertions.internal.FloatArrays;
import org.fest.util.VisibleForTesting;

/**
 * Assertion methods for arrays of {@code float}s.
 * <p>
 * To create an instance of this class, invoke <code>{@link Assertions#assertThat(float[])}</code>.
 * </p>
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
public class FloatArrayAssert extends AbstractAssert<FloatArrayAssert, float[]> implements
    EnumerableAssert<FloatArrayAssert>, IndexedObjectEnumerableAssert<FloatArrayAssert, Float> {

  @VisibleForTesting
  FloatArrays arrays = FloatArrays.instance();

  protected FloatArrayAssert(float[] actual) {
    super(actual, FloatArrayAssert.class);
  }

  protected FloatArrayAssert(float[] actual, Description description) {
    super(actual, FloatArrayAssert.class, description);
  }

  /** {@inheritDoc} */
  @Override
  public FloatArrayAssert isNullOrEmpty() {
    arrays.assertNullOrEmpty(description, actual);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FloatArrayAssert isEmpty() {
    arrays.assertEmpty(description, actual);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FloatArrayAssert isNotEmpty() {
    arrays.assertNotEmpty(description, actual);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public FloatArrayAssert hasSize(int expected) {
    arrays.assertHasSize(description, actual, expected);
    return this;
  }

  @Override
  public FloatArrayAssert contains(Float value, Index index) {
    arrays.assertContains(description, actual, value, index);
    return this;
  }

  @Override
  public FloatArrayAssert doesNotContain(Float value, Index index) {
    arrays.assertDoesNotContain(description, actual, value, index);
    return this;
  }

  /**
   * Verifies that the actual array contains the given values, in any order.
   *
   * @param values the given values.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not contain the given values.
   */
  public FloatArrayAssert contains(float... values) {
    arrays.assertContains(description, actual, values);
    return this;
  }

  /**
   * Verifies that the actual array contains only the given values and nothing else, in any order.
   *
   * @param values the given values.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not contain the given values, i.e. the actual array contains some
   *           or none of the given values, or the actual array contains more values than the given ones.
   */
  public FloatArrayAssert containsOnly(float... values) {
    arrays.assertContainsOnly(description, actual, values);
    return this;
  }

  /**
   * Verifies that the actual array contains the given sequence, without any other values between them.
   *
   * @param sequence the sequence of values to look for.
   * @return this assertion object.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the given array is {@code null}.
   * @throws AssertionError if the actual array does not contain the given sequence.
   */
  public FloatArrayAssert containsSequence(float... sequence) {
    arrays.assertContainsSequence(description, actual, sequence);
    return this;
  }

  /**
   * Verifies that the actual array does not contain the given values.
   *
   * @param values the given values.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array contains any of the given values.
   */
  public FloatArrayAssert doesNotContain(float... values) {
    arrays.assertDoesNotContain(description, actual, values);
    return this;
  }

  /**
   * Verifies that the actual array does not contain duplicates.
   *
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array contains duplicates.
   */
  public FloatArrayAssert doesNotHaveDuplicates() {
    arrays.assertDoesNotHaveDuplicates(description, actual);
    return this;
  }

  /**
   * Verifies that the actual array starts with the given sequence of values, without any other values between them.
   * Similar to <code>{@link #containsSequence(float...)}</code>, but it also verifies that the first element in the
   * sequence is also first element of the actual array.
   *
   * @param sequence the sequence of values to look for.
   * @return this assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not start with the given sequence.
   */
  public FloatArrayAssert startsWith(float... sequence) {
    arrays.assertStartsWith(description, actual, sequence);
    return this;
  }

  /**
   * Verifies that the actual array ends with the given sequence of values, without any other values between them.
   * Similar to <code>{@link #containsSequence(float...)}</code>, but it also verifies that the last element in the
   * sequence is also last element of the actual array.
   *
   * @param sequence the sequence of values to look for.
   * @return this assertion object.
   * @throws NullPointerException if the given argument is {@code null}.
   * @throws IllegalArgumentException if the given argument is an empty array.
   * @throws AssertionError if the actual array is {@code null}.
   * @throws AssertionError if the actual array does not end with the given sequence.
   */
  public FloatArrayAssert endsWith(float... sequence) {
    arrays.assertEndsWith(description, actual, sequence);
    return this;
  }
}
