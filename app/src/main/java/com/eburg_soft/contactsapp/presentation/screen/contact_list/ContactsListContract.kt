package com.eburg_soft.contactsapp.presentation.screen.contact_list

import com.eburg_soft.contactsapp.model.source.database.entity.Contact
import com.eburg_soft.contactsapp.presentation.base.BaseContract

interface ContactsListContract {
    interface View : BaseContract.View {

        fun showLoading()

        fun hideLoading()
        fun addContacts(list: List<Contact>)
        fun submitList(list: List<Contact>)

        fun showNetworkErrorMessage()

        fun showDBErrorMessage()

        fun showErrorMessage(error: String)

        fun openContactView(contact: Contact)
    }

    abstract class Presenter : BaseContract.Presenter<View>() {

        abstract fun onContactClick(contact: Contact)

        abstract fun loadContactsListFromDB()

        abstract fun syncContacts()

        abstract fun eraseContactsFromDB()

        abstract fun onSearchQuerySubmit(query: String, contactList: ArrayList<Contact>)
    }
}