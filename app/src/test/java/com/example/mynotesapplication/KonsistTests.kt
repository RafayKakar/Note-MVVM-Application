package com.example.mynotesapplication

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class KonsistTests {

    @Test
    fun `data sources should end with DataSource or DataSourceImpl`() {
        Konsist.scopeFromProject()
            .files
            .filter {it.resideInPath("..activities..") }
            .assertTrue { it.name.endsWith("Activity")  }
    }

}