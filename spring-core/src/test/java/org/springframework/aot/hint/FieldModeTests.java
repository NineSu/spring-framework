/*
 * Copyright 2002-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aot.hint;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link FieldMode}.
 *
 * @author Phillip Webb
 * @since 6.0
 */
class FieldModeTests {

	@Test
	void writeIncludesNullMode() {
		assertThat(FieldMode.WRITE.includes(null)).isTrue();
	}

	@Test
	void writeIncludesRead() {
		assertThat(FieldMode.WRITE.includes(FieldMode.READ)).isTrue();
	}

	@Test
	void writeIncludesWrite() {
		assertThat(FieldMode.WRITE.includes(FieldMode.WRITE)).isTrue();
	}

	@Test
	void readIncludesNullMode() {
		assertThat(FieldMode.READ.includes(null)).isTrue();
	}

	@Test
	void readIncludesRead() {
		assertThat(FieldMode.READ.includes(FieldMode.READ)).isTrue();
	}

	@Test
	void readDoesNotIncludeWrite() {
		assertThat(FieldMode.READ.includes(FieldMode.WRITE)).isFalse();
	}

}