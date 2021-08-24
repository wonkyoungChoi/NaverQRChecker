package com.example.naverqrcheck.setting

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.naverqrcheck.databinding.ItemSettingBinding
import com.example.naverqrcheck.setting.appnotice.AppNoticeActivity
import com.example.naverqrcheck.setting.license.LicenseActivity
import com.example.naverqrcheck.setting.profile.ProfileActivity

class SettingAdapter : RecyclerView.Adapter<SettingAdapter.SettingViewHolder>() {
    var items = listOf("앱 공지사항", "개발자 정보", "오픈소스 라이센스")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSettingBinding.inflate(layoutInflater, parent, false)
        return SettingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class SettingViewHolder(private val binding: ItemSettingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(str: String) {
            var menuName = ""

            var intent = Intent(itemView.context, ProfileActivity::class.java)

            when (str) {

                "앱 공지사항" -> {
                    menuName = "공지사항"
                    intent = Intent(itemView.context, AppNoticeActivity::class.java)
                }


                "개발자 정보" -> {
                    menuName = "개발자 정보"
                    intent = Intent(itemView.context, ProfileActivity::class.java)
                }

                "오픈소스 라이센스" -> {
                    menuName = "오픈소스 라이센스"
                    intent = Intent(itemView.context, LicenseActivity::class.java)
                }


            }



            binding.tvSetting.text = menuName
            binding.layoutSetting.setOnClickListener {
                it.context.startActivity(intent)
            }


        }
    }
}