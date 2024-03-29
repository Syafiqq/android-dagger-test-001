package com.github.syafiqq.androidarchtest001.controller

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.syafiqq.androidarchtest001.R
import com.github.syafiqq.androidarchtest001.dump.contract.TitleContract
import dagger.android.AndroidInjection
import io.reactivex.subjects.PublishSubject

import kotlinx.android.synthetic.main.activity_dump.*
import kotlinx.android.synthetic.main.content_dump.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DumpActivity : AppCompatActivity() {
    @Inject
    lateinit var titleFactory:TitleContract

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dump)
        setSupportActionBar(toolbar)

        val s = PublishSubject.create<View>()
        s.throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                textView.text = titleFactory.title
            }

        fab.setOnClickListener(s::onNext)
        button.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }

}
