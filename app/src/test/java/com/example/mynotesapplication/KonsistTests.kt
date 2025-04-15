package com.example.mynotesapplication

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class KonsistTests {

    @Test
    fun `activity should lie in activities package and name should end with Activity`() {
        Konsist.scopeFromProject()
            .files
            .filter {it.resideInPath("..activities..") }
            .assertTrue { it.name.endsWith("Activity")  }
    }

}