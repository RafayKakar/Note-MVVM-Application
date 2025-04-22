package com.example.mynotesapplication

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class ActivityTest {

    val scope = Konsist.scopeFromPackage("..presentation.activities..")

    @Test
    fun `naming convention`() {
        scope.files.assertTrue {
            it.name.endsWith("Activity")
        }
    }


}