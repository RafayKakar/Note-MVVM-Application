package com.example.mynotesapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rafaykakar.notetakingapplication.activities.NoteEditorActivity
import com.rafaykakar.notetakingapplication.viewmodels.NoteEditorViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class NoteEditorActivityTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val activityRule = ActivityScenarioRule(NoteEditorActivity::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun testNoteEditorActivity_launchesSuccessfully() {
        ActivityScenario.launch(NoteEditorActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                assertNotNull(activity)
                assertNotNull(activity.binding)
            }
        }
    }

    @Test
    fun testAddNote_whenFieldsAreEmpty_shouldNotCrash() {
        ActivityScenario.launch(NoteEditorActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                activity.binding.apply {
                    headingEditText.setText("")
                    noteEditText.setText("")
                }

                activity.addNote()

                // No exception expected, check activity is still alive
                assertNotNull(activity)
            }
        }
    }

    @Test
    fun launch_and_set_fields() = run {
        ActivityScenario.launch(NoteEditorActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->

                activity.binding.apply {
                    headingEditText.setText("Test Heading")
                    noteEditText.setText("Test Note")
                }
            }
        }
    }


}
