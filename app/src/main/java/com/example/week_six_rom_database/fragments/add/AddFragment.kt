package com.example.week_six_rom_database.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.week_six_rom_database.R
import com.example.week_six_rom_database.data.User
import com.example.week_six_rom_database.data.UserViewModel
//to figure out content to lay viewModel class to
class AddFragment : Fragment() {
    private lateinit var addContactBtn: Button
    lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        addContactBtn = view.findViewById(R.id.add_contact_btn)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
//
        addContactBtn.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val addFirstNameEt = requireView().findViewById<EditText>(R.id.et_first_name).text.toString()
        val addLastNameEt = requireView().findViewById<EditText>(R.id.et_last_name).text.toString()
        val phoneNumber = requireView().findViewById<EditText>(R.id.et_phone_number).text

        if (inputCheck(addFirstNameEt, addLastNameEt, phoneNumber)){
            //create User object
            val user = User(0, addFirstNameEt, addLastNameEt, phoneNumber.toString()) //or use Interger.parseInt(phoneNumber.toString())
            //add Data to database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully Added Contact", Toast.LENGTH_SHORT).show()
            //Navigate back to list fragment
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(firstName: String, lastName: String, phone: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && phone.isEmpty())
    }
}