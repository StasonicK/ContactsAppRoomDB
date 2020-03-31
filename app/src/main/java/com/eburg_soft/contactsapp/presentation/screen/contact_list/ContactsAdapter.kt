package com.eburg_soft.contactsapp.presentation.screen.contact_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eburg_soft.contactsapp.R
import com.eburg_soft.contactsapp.model.source.database.entity.Contact
import com.eburg_soft.contactsapp.presentation.base.BaseAdapter
import com.eburg_soft.contactsapp.presentation.screen.contact_list.ContactsAdapter.ContactViewHolder
import kotlinx.android.synthetic.main.recycler_view_item.view.text_height
import kotlinx.android.synthetic.main.recycler_view_item.view.text_name
import kotlinx.android.synthetic.main.recycler_view_item.view.text_phone

class ContactsAdapter(val listener: OnContactItemClickListener? = null) :
    BaseAdapter<ContactViewHolder>() {

    interface OnContactItemClickListener {
        fun onContactClick(contact: Contact)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ContactViewHolder(v)
    }

    inner class ContactViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {

        var id: String = ""
        var name: String = ""
        var heingt: String = ""
        var biography: String = ""
        var temperament: String = ""
        var educationStart: String = ""
        var educationEnd: String = ""

        override fun bind(item: Any) {

            let {
                item as Contact

                view.text_name.text = item.contactName
                view.text_phone.text = item.contactPhone
                view.text_height.text = item.contactHeingt.toString()

                id = item.contactId
                name = item.contactName
                heingt = item.contactHeingt.toString()
                biography = item.contactBiography
                temperament = item.contactTemperament
                educationStart = item.contactEducationStart
                educationEnd = item.contactEducationEnd

                itemView.setOnClickListener { listener?.onContactClick(item) }
            }
        }
    }
}
