package com.example.mynotesapplication

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mynotesapplication.presentation.activities.NoteEditorActivity
import com.example.mynotesapplication.adapters.NoteEntity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@RunWith(AndroidJUnit4::class)
class NoteEditorActivityTest {


    @get:Rule
    val activityRule = ActivityScenarioRule(NoteEditorActivity::class.java)


    @Test
    fun testEnterNoteAndHeading() {
        // Type heading
        onView(withId(R.id.heading_edit_text))
            .perform(typeText("Test Heading"), closeSoftKeyboard())

        // Type note
        onView(withId(R.id.note_edit_text))
            .perform(typeText("This is a test note"), closeSoftKeyboard())

        // Simulate back press
        pressBack()

        // Verify if text is still there (ActivityScenario keeps state)
        onView(withId(R.id.heading_edit_text))
            .check(matches(withText("Test Heading")))

        onView(withId(R.id.note_edit_text))
            .check(matches(withText("This is a test note")))
    }

    @Test
    fun testEmptyNoteDoesNotCrash() {
        // Leave heading and note empty

        // Press back
        pressBack()

        // Optionally, check if still empty
        onView(withId(R.id.heading_edit_text))
            .check(matches(withText("")))

        onView(withId(R.id.note_edit_text))
            .check(matches(withText("")))
    }

    @Test
    fun testOnlyHeadingFilled() {
        onView(withId(R.id.heading_edit_text))
            .perform(typeText("Heading Only"), closeSoftKeyboard())

        pressBack()

        onView(withId(R.id.heading_edit_text))
            .check(matches(withText("Heading Only")))

        onView(withId(R.id.note_edit_text))
            .check(matches(withText("")))
    }

    @Test
    fun testOnlyNoteFilled() {
        onView(withId(R.id.note_edit_text))
            .perform(typeText("Note Only"), closeSoftKeyboard())

        pressBack()

        onView(withId(R.id.heading_edit_text))
            .check(matches(withText("")))

        onView(withId(R.id.note_edit_text))
            .check(matches(withText("Note Only")))
    }

    @Test
    fun testUpdateExistingNote() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), NoteEditorActivity::class.java).apply {
            putExtra("NOTE_OBJECT", NoteEntity("Old Heading", "Old Note", Date()))
        }

        ActivityScenario.launch<NoteEditorActivity>(intent).use {
            // Update heading
            onView(withId(R.id.heading_edit_text))
                .perform(replaceText("Updated Heading"), closeSoftKeyboard())

            // Update note
            onView(withId(R.id.note_edit_text))
                .perform(replaceText("Updated Note"), closeSoftKeyboard())

            pressBack()

            onView(withId(R.id.heading_edit_text))
                .check(matches(withText("Updated Heading")))

            onView(withId(R.id.note_edit_text))
                .check(matches(withText("Updated Note")))
        }
    }


    @Test
    fun testLongNoteInput() {
        val longText = "This is a long note. ".repeat(20)

        onView(withId(R.id.note_edit_text))
            .perform(typeText(longText), closeSoftKeyboard())

        pressBack()

        onView(withId(R.id.note_edit_text))
            .check(matches(withText(longText.trim())))
    }

}
