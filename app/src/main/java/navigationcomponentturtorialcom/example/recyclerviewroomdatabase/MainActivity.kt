package navigationcomponentturtorialcom.example.recyclerviewroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtAddress: EditText
    private lateinit var btnAddUser: Button
    private lateinit var rcvUser: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        btnAddUser.setOnClickListener {
            addUser()
        }
    }

    private fun addUser() {
        val strUsername = edtUsername.text.toString().trim()
        val strAddress = edtAddress.text.toString().trim()

        if (strUsername.isEmpty() || strAddress.isEmpty()) {
            return
        }

        val user = User(0, strUsername, strAddress)
        UserDatabase.getInstance(this)?.userDao()?.insertAll(user)
        Toast.makeText(this, "Add user successfully", Toast.LENGTH_SHORT).show()
        edtUsername.setText("")
        edtAddress.setText("")

        val mListUser = UserDatabase.getInstance(this)?.userDao()?.getAll()
        val userAdapter = UserAdapter(mListUser!!)
        // kết nối với recycle view
        rcvUser.adapter = userAdapter
        rcvUser.layoutManager = LinearLayoutManager(this)
    }

    private fun initUI() {
        edtUsername = findViewById(R.id.edt_username)
        edtAddress = findViewById(R.id.edt_address)
        btnAddUser = findViewById(R.id.btn_add_user)
        rcvUser = findViewById(R.id.rcv_user)
    }
}