package com.android.projectara

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.projectara.model.Post
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val posts: ArrayList<Post> = ArrayList()
        for (i in 1..100) {
            posts.add(Post("danielmalone_" + i, "asdf asdf text here", "https://picsum.photos/600/300?random&" + i))
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PostAdapter(posts, this)
    }
}

