package jambda.camp.clean.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CustomerTest {

    @Nested
    inner class CustomerNameTest {

        @Test
        fun `should throw validation error when first name is empty`() {
            Assertions.assertThatThrownBy {
                CustomerName(
                    firstName = "",
                    lastName = "ignored"
                )
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("First name can not be empty")
        }

        @Test
        fun `should throw validation error when last name is empty`() {
            Assertions.assertThatThrownBy {
                CustomerName(
                    firstName = "ignored",
                    lastName = ""
                )
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Last name can not be empty")
        }
    }
}
