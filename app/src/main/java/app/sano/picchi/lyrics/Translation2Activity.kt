package app.sano.picchi.lyrics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_translation.*
import kotlinx.android.synthetic.main.activity_translation2.*
import kotlinx.android.synthetic.main.activity_translation2.contentText
import kotlinx.android.synthetic.main.activity_translation2.titleText

class Translation2Activity : AppCompatActivity() {

    //realm型の変数を宣言
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translation2)

        //realmを開く
        realm = Realm.getDefaultInstance()

        showData()



        backButton.setOnClickListener{
            finish()
        }


    }

    fun showData() {
        val memo = realm.where(Memo::class.java).equalTo(
            "updateDate",
            intent.getStringExtra("updateDate")
        ).findFirst()

        titleText.setText(memo.title)
        contentText.setText(memo.content)

    }

    override fun onDestroy() {
        super.onDestroy()

        //realmを閉じる
        realm.close()
    }



}
