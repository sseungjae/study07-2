package org.techtown.study07_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //리사이클러뷰의 레이아웃을 설정한다. layoutManager가
        //VERTICAL이니 세로 방향으로 기본 레이아웃을 설정한다.
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        //어댑터 변수느는 SongAdater에서 정보를 받는다.
        val adapter = SongAdapter()
        //리사이클러뷰의 어댑터는 SongAdater에서 정보를 받는다.
        recyclerView.adapter = adapter

        //OnSongItemClickListener인터페이스를 구현한 SongAdaper의 listener객체의 정보를 받는다.
        adapter.listener = object : OnSongItemClickListener {
            //만들어진 아이템이 클릭되면
            override fun onItemClick(holder: SongAdapter.ViewHolder?, view: View?, position: Int) {
                //변수 name은 어댑터의 아이템들의 인덱스 값
                //items는 Song의 리스트들 Song이 받은 title과 singer의 String값
                val name = adapter.items[position]
                //아이템을 클릭하면 토스트 메세지를 보인다.
                //아이템 선택됨 Song(title=OO, singer=OO )
                showToast("아이템 선택 됨 ${name}")
            }
        }

        //추가 버튼을 눌렀을 때
        addButton.setOnClickListener {
            //변수 title은 input1의 String값이다.
            val title = input1.text.toString()
            //변수 singer는 input2의 String값이다.
            val singer = input2.text.toString()

            //어댑터 items에 추가한다. input1은 Song의 title값, input2는 Song의 singer값
            adapter.items.add(Song(title, singer))
            //어댑터의 정보를 갱신해준다.
            adapter.notifyDataSetChanged()

        }
    }

    fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}