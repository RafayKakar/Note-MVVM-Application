package com.example.mynotesapplication

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import com.lemonappdev.konsist.api.ext.list.parameters
import com.lemonappdev.konsist.api.ext.list.sourceDeclarations
import com.lemonappdev.konsist.api.ext.list.types
import com.lemonappdev.konsist.api.ext.list.withGeneric
import com.lemonappdev.konsist.api.verify.assertFalse
import org.junit.Test
import org.mockito.kotlin.stub

//class KonsistTest {
//
//    val appPackageName = BuildConfig.APPLICATION_ID
//
//    @Test
//    fun testArchitecture() {
//        Konsist.scopeFromProject().assertArchitecture {
//            val data = Layer("Data", "..data..")
//            val domain = Layer("Domain", "..domain..")
//            val presentation = Layer("Presentation", "..presentation..")
//            println("P: $presentation")
//            println("D: $domain")
////presentation.include()
////            domain.dependsOnNothing()
//            presentation.doesNotDependOn(domain)
//        }
//
//        val files = Konsist
//            .scopeFromProject()
//            .files
//            .filter { it.resideInPath("..domain..") }
//
//        println("Presentation files: ${files}")
//    }
//
//    @Test
//    fun `function parameter has generic type argument not ending with 'Repository' or 'UseCase'`() {
//        Konsist
//            .scopeFromProduction()
//            .functions()
//            .parameters
//            .types
//            .withGeneric()
//            .sourceDeclarations()
//            .assertFalse {
//                it.hasNameEndingWith("Repository") || it.hasNameEndingWith("UseCase")
//            }
//    }
//}