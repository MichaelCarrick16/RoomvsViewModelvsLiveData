package com.example.roomversionone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomversionone.db.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnActionCallback {
    private lateinit var viewModel : MainViewModel
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linkYoutube()
        initViews()
        initEvent()
    }

    private fun linkYoutube() {
        var str : String = "https://www.youtube.com/watch?v=aK9tOipNm0o"
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
    }

    private fun initEvent() {
        tv_save.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                var userEntity = UserEntity(0,edt_name.text.toString(),edt_email.text.toString())
                viewModel.insertUser(userEntity)
            }
        })
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.setContext(this)

        var layout = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recyclerViewAdapter = RecyclerViewAdapter(this,viewModel.list)
        recyclerViewAdapter.setCallback(this)
        recycler_view.layoutManager = layout
        recycler_view.adapter = recyclerViewAdapter

        viewModel.listUser.observe(this, Observer {
            recyclerViewAdapter.setNewData(viewModel.listUser.value!!)
        })

    }

    override fun onCallback(userEntity: UserEntity) {
        viewModel.deleteUser(userEntity)

    }
}