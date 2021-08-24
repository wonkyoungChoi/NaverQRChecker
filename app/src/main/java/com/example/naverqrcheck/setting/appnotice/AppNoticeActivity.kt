package com.example.naverqrcheck.setting.appnotice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.naverqrcheck.databinding.ActivityAppNoticeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AppNoticeActivity : AppCompatActivity() {

    private val databaseReference = FirebaseDatabase.getInstance().reference
    private lateinit var binding: ActivityAppNoticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lottieViewLoading.visibility = View.VISIBLE
        binding.lottieViewLoading.playAnimation()

        binding.rvAppNotice.layoutManager = LinearLayoutManager(applicationContext)

        /*

        databaseReference.child("notices").child("1").child("content").setValue("안녕하세요")
        databaseReference.child("notices").child("1").child("date").setValue("2021-08-24")
        databaseReference.child("notices").child("1").child("isNew").setValue("true")
        databaseReference.child("notices").child("1").child("title").setValue("첫 공지")

         */

        FirebaseDatabase.getInstance().reference
            .child("notices")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(p0: DataSnapshot) {
                     Log.d("MainActivity", "Single ValueEventListener : $p0");

                    val notices = arrayListOf<AppNotice>()

                    p0.children.forEach {
                        var content = " "
                        var date = " "
                        var title = " "
                        var isNew = " "
                        it.children.forEach {notice ->
                            when(notice.key){
                                "content" -> content = notice.value.toString()
                                "date" -> date = notice.value.toString()
                                "title" -> title = notice.value.toString()
                                "isNew" -> isNew = notice.value.toString()
                            }
                        }

                        notices.add(0, AppNotice(content, date, title, isNew))
                    }

                    binding.rvAppNotice.adapter = AppNoticeAdapter(notices)
                    binding.lottieViewLoading.visibility = View.GONE
                }
            })

        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}