package org.techtown.study07_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.song.view.*

//리사이클러뷰를 사용하려면 어댑터가 있어야 한다.
class SongAdapter : RecyclerView.Adapter<SongAdapter.ViewHolder>() {
    //변수 items는 data class Song의 리스트이다.
    var items = ArrayList<Song>()

    //늦은 초기화 listener 변수는 인터페이스의 정보 상속 받는다.
    //즉, 뷰홀더 객체와 뷰 객체, 뷰의 포지션 값을 받는다.
    //필요할 때만 메모리를 사용한다.
    lateinit var listener : OnSongItemClickListener

    //getItemCount함수는 items의 size값을 반환한다.
    //items size는 Song리스트의 크기 -> 인덱스들
    //어댑터에서 관리하는 아이템 개수를 반환
    override fun getItemCount() = items.size

    //뷰 객체가 만들어질 때 자동으로 호출
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //layoutInflater는 XML에 정의된 소스들을 View의 형태로 반환시켜 준다.
        //변수 itemView는 XML의 소스를 View형태로 반환한다. 부모의 내용을
        //부모는 ViewHolder -> ViewHolder는 리사이클러뷰의 내용. 을 인플레이트 한다. song의 레이아
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.song, parent, false)
        //뷰 홀더를 반환한다. itemView값을 넣어서.
        return ViewHolder(itemView)
    }

    //뷰 객체가 재사용될 때 자용으로 호출
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    //이너 클래스로 뷰홀더를 만든다. 이 뷰 객체는 하나의 아이템을 위해 만든 뷰 객체
    //song.xml의 레이아웃을 뷰로 만들어 전달한다.을
    //override fun onCreateViewHolder에서 만든 값을 받아서 실행한다.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        //초기화한다.
        init {
            //itemView를 눌렀을 때
            itemView.setOnClickListener {
                //listener는 위에서 lateinit var listener : OnSongItemClickListener 인터페이스를 구현한 객체
                //이것을 메인 엑티비티에서 받는다.
                listener?.onItemClick(this, itemView, adapterPosition)
            }
        }
        //뷰의 텍스트뷰에 글자를 설정할 수 있도록 만든다.
        //이 함수가 호출되면 Song에서 객체를 전달 받는다.
        fun setItem(item: Song) {
            itemView.titleTextView.text = item.title
            itemView.singerTextView.text = item.singer
        }
    }
}