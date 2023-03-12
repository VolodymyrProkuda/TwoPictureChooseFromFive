package com.npchff.twopicturechoosefromfive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var firstElementChoose = 0
    var secondElementChoose = 0
    val fiveIm = mutableListOf<ImageView>()
    val pictureNumber = mutableListOf(0,1,2,3,4)
    val pictIm = listOf<Int>(R.drawable.twosame_bug,R.drawable.twosame_tree,
        R.drawable.twosame_flower,R.drawable.twosame_roll,R.drawable.twosame_umbrela)
    var firstClick = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStrt = findViewById<Button>(R.id.btnStrt)
        val textViewChoose = findViewById<TextView>(R.id.textViewChoose)

        fiveIm.add(findViewById(R.id.imageView))
        fiveIm.add(findViewById(R.id.imageView2))
        fiveIm.add(findViewById(R.id.imageView3))
        fiveIm.add(findViewById(R.id.imageView4))
        fiveIm.add(findViewById(R.id.imageView5))

        btnStrt.setOnClickListener{
            firstElementChoose = 0
            secondElementChoose = 0
            shufflePict()
            drawIm()


        }

        for (i in 0..4) {
            fiveIm[i].setOnClickListener{
                if (firstClick == -1) firstClick = i
                else{
                    if (((pictureNumber[firstClick] == firstElementChoose )&&(pictureNumber[i] == secondElementChoose ))
                        || ((pictureNumber[firstClick] == secondElementChoose) && (pictureNumber[i] ==firstElementChoose ))) {textViewChoose.text = "Good!"
                    }else {textViewChoose.text = "No( . Try once more"}
                    firstClick = -1
                }

            }
        }


    }
    fun shufflePict(){

        for (i in 0..4) pictureNumber[i] = i
        for (i in 0..7)
        {
            var a = (0..4).random()
            var b = pictureNumber[a]
            pictureNumber[a] = pictureNumber[0]
            pictureNumber[0] = b
        }

    }
    fun drawIm(){
        for (i in 0..4) fiveIm[i].setImageResource(pictIm[pictureNumber[i]])
        var a = (0..4).random()
        var b = (0..4).random()
        fiveIm[a].setImageResource(pictIm[b])
        firstElementChoose = pictureNumber[a]
        secondElementChoose = b

    }



}