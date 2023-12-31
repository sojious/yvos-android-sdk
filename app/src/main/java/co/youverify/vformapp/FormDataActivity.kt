package co.youverify.vformapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import com.google.gson.Gson

class FormDataActivity : AppCompatActivity() {


    private var data: String?=null
    private lateinit var contentTextView: TextView
    private lateinit var titleTextView: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_data)
        titleTextView=findViewById(R.id.textView_title)
        contentTextView=findViewById(R.id.textView_content)
        displayReturnedData()
    }

    @SuppressLint("SetTextI18n")
    private fun displayReturnedData() {
        val dataString=intent.getStringExtra(RETURNED_DATA_STRING)
         /*data=Gson().fromJson(dataString,String::class.java)
       val  sb=SpannableStringBuilder()
           .bold { append("id: ") }
           .append("${data?.id}\n")
           .bold { append("fields: ") }
           .append("${data?.fields}\n")*/

        titleTextView.text=dataString
        contentTextView.text=dataString
    }


}