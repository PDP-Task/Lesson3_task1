package uz.manifest.lesson3_task1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.manifest.lesson3_task1.R
import uz.manifest.lesson3_task1.adapter.ContactAdapter
import uz.manifest.lesson3_task1.model.Contact

class ContactFragment : Fragment() {
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var recyclerView: RecyclerView
    private val contactList: ArrayList<Contact> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_contact)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        contactAdapter = ContactAdapter(contactList())
        recyclerView.adapter = contactAdapter
    }

    private fun contactList(): ArrayList<Contact> {
        for (i in 0..20) {
            if (i % 3 == 0) {
                contactList.add(
                    Contact(
                        R.drawable.kotlin_img,
                        "Kotlin",
                        "Kotlin is the best",
                        true
                    )
                )
            } else {
                contactList.add(Contact(R.drawable.java, "Java", "Java is the strong", false))
            }
        }
        return contactList
    }
}