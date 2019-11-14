package app.sano.picchi.lyrics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import io.realm.Realm
import kotlinx.android.synthetic.main.layout_item_memo.*

class DetailActivity : AppCompatActivity() {

//    //realm型の変数を宣言
//    lateinit var realm: Realm
//
//    //EditText型の変数宣言
//    lateinit var titleEditText: EditText
//    lateinit var contentEditText: EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        //realmを開
//        Realm.init(this)
//        realm = Realm.getDefaultInstance()
//
//        //関連付け
//        titleEditText = findViewById(R.id.titleEditText) as EditText
//        contentEditText = findViewById(R.id.contentEditText) as EditText
//
//        showData();


    }

//    fun showData() {
//        val memo = realm.where(Memo::class.java).equalTo(
//            "updateDate",
//            intent.getStringExtra("updateDate")
//        ).findFirst()
//
//        titleText.setText(memo.title)
//        contentText.setText(memo.content)
//    }

    override fun onDestroy() {
        super.onDestroy()

//        //realmを閉じる
//        realm.close()
    }
}
