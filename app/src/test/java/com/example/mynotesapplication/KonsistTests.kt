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

    @Test
    fun `activity and fragment classes should have @AndroidEntryPoint annotation`() {
        Konsist.scopeFromProject()
            .classes()
            .filter {
                it.name.endsWith("Activity") || it.name.endsWith("Fragment")
            }
            .assertTrue { clazz ->
                clazz.hasAnnotationWithName("AndroidEntryPoint")
            }
    }


    @Test
    fun `adapter should lie in adapters package and name should end with Adapter`() {
        Konsist.scopeFromProject()
            .files
            .filter {it.resideInPath("..adapters..") }
            .assertTrue { it.name.endsWith("Adapter")  }
    }



    @Test
    fun `all DAO classes should be interfaces in database package and end with Dao`() {
        Konsist.scopeFromPackage("..database..")
            .interfaces()
            .assertTrue { it.name.endsWith("Dao") }
    }


    @Test
    fun `repository should lie in repository package and name should end with Respository`() {
        Konsist.scopeFromProject()
            .files
            .filter {it.resideInPath("..repository..") }
            .assertTrue { it.name.endsWith("Repository")  }
    }


    @Test
    fun `viewmodel should lie in viewmodels package and name should end with ViewModel`() {
        Konsist.scopeFromProject()
            .files
            .filter {it.resideInPath("..viewmodels..") }
            .assertTrue { it.name.endsWith("ViewModel")  }
    }

}