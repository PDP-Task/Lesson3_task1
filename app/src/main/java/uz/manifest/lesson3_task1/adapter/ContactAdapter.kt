package uz.manifest.lesson3_task1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.manifest.lesson3_task1.R
import uz.manifest.lesson3_task1.model.Contact
import uz.manifest.telegramclone.util.Time

class ContactAdapter(private val contactList: ArrayList<Contact>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            1
        } else
            0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.service_item_layout, parent, false)
            return ContactViewHolderTwo(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact_layout, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contactList[position]

        if (holder is ContactViewHolder) {
            holder.apply {
                imageView.setImageResource(contact.imageProfile)
                tvFullName.text = contact.fullName
                tvMessage.text = contact.message

                if (contact.isOnline) {
                    isOnlineView.setBackgroundResource(R.drawable.background_green)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_profile)
        val tvFullName: TextView = view.findViewById(R.id.tv_full_name)
        val tvMessage: TextView = view.findViewById(R.id.tv_message)
        val isOnlineView: View = view.findViewById(R.id.is_online)
        private val timeText: TextView = view.findViewById(R.id.tv_time)

        init {
            timeText.text = Time.timeStamp()
        }
    }

    inner class ContactViewHolderTwo(view: View) : RecyclerView.ViewHolder(view) {
        val btnLoc: ImageButton = view.findViewById(R.id.btn_location_service)
        val btnInvite: ImageButton = view.findViewById(R.id.btn_invite_service)
        val textLoc: TextView = view.findViewById(R.id.text_loc_service)
        val textInvite: TextView = view.findViewById(R.id.text_invite_service)
    }
}