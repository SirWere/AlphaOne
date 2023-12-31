package com.example.myspacealphaoneapartents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class AboutActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList:ArrayList<Int>
    private lateinit var adapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        init()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable,2000)
            }
        })
    }

    private fun init(){
        viewPager2=findViewById(R.id.ViewPager2)
        handler= Handler(Looper.myLooper()!!)
        imageList= ArrayList()

        imageList.add(R.drawable.livingroom)
        imageList.add(R.drawable.livingroom2)
        imageList.add(R.drawable.bedroom3)
        imageList.add(R.drawable.bedroom4)
        imageList.add(R.drawable.kitchen)
        imageList.add(R.drawable.bathroom)
        imageList.add(R.drawable.bathroom2)


        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.55f + r + 0.55f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem +1
    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable,15000)
    }
}