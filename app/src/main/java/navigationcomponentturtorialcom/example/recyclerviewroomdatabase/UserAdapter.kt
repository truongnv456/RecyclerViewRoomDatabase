package navigationcomponentturtorialcom.example.recyclerviewroomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val mListUser: List<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    /* Dùng để tham chiếu đến các view của từng item trong RecyclerView */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val username: TextView
        val address: TextView

        init {
            username = view.findViewById(R.id.tv_username)
            address = view.findViewById(R.id.tv_address)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        holder.username.text = mListUser[position].username
        holder.address.text = mListUser[position].address
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        if (mListUser != null) {
            return mListUser.size
        }
        return 0
    }
}