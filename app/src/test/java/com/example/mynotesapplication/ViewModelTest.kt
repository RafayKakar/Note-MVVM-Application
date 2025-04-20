package com.example.mynotesapplication

import androidx.constraintlayout.helper.widget.Flow
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.properties
import com.lemonappdev.konsist.api.verify.assertTrue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.junit.Test

class ViewModelTest {

//    @Test
//    fun `Viewmodel classes should only contain properties of type Flow, StateFlow or MutableStateFlow`() {
//        Konsist.scopeFromProject()
//            .classes().filter { it.name.endsWith("ViewModel")
//            }.flatMap { it.properties(  false) }
//            .assertTrue {
//                it.hasTypeOf(MutableStateFlow::class) || it.hasTypeOf(StateFlow::class) || it.hasTypeOf(
//                    Flow::class
//                )
//            }
//    }
//
//    @Test
//    fun `ViewModel classes should only contain body properties of type Flow, StateFlow, or MutableStateFlow`() {
//        Konsist.scopeFromProject()
//            .classes()
//            .filter { it.name.endsWith("ViewModel") }
//            .flatMap { klass ->
//                klass.properties()
//                    .filterNot { it.isConstructorDefined }
//            }
//            .assertTrue {
//                it.hasTypeOf(Flow::class) ||
//                        it.hasTypeOf(StateFlow::class) ||
//                        it.hasTypeOf(MutableStateFlow::class)
//            }
//    }

}