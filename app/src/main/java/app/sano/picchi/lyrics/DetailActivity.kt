package app.sano.picchi.lyrics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import io.realm.Realm
import kotlinx.android.synthetic.main.layout_item_memo.*

class DetailActivity : AppCompatActivity() {

    //realm型の変数を宣言
    lateinit var realm: Realm

    //EditText型の変数宣言
    lateinit var titleText: EditText
    lateinit var contentText: EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //realmを開く
        Realm.init(this)
        realm = Realm.getDefaultInstance()

        //関連付け
        titleText = findViewById(R.id.titleEditText) as EditText
        contentText = findViewById(R.id.contentEditText) as EditText

        showData()



    }

    fun showData() {
        val memo = realm.where(Memo::class.java).equalTo(
            "updateDate",
            intent.getStringExtra("updateDate")
        ).findFirst()

        titleText.setText(memo.title)
        contentText.setText(memo.content)
    }

    fun update(view: View) {
        val memo = realm.where(Memo::class.java).equalTo(
            "updateDate",
            intent.getStringExtra("updateDate")
        ).findFirst()

        //更新する
        realm.executeTransaction {
            memo.title = titleText.text.toString()
            memo.content = contentText.text.toString()
        }

        //画面を閉じる
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()

        //realmを閉じる
        realm.close()
    }
}
