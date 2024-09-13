package tech.bam.dojo.freetimelancetracker.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import tech.bam.dojo.freetimelancetracker.model.Contact
import tech.bam.dojo.freetimelancetracker.text.FreetimelanceTrackerStrings

class ContactRepository {

    private val _contact = MutableStateFlow(
        Contact(
            web = FreetimelanceTrackerStrings.contact_website_fake_value,
            email = FreetimelanceTrackerStrings.contact_email_fake_value,
            phone = FreetimelanceTrackerStrings.contact_phone_fake_value
        )
    )
    val contact: StateFlow<Contact> = _contact

    private fun updateContact(newContact: Contact) {
        _contact.value = newContact
    }
}
