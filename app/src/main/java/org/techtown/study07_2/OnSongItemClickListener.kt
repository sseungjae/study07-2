package org.techtown.study07_2

import android.view.View

//소스 코드를 어댑터 파일 안에 추가하면 버튼을 클릭 했을 때의 기능이 변경될 때마다 어댑터 소스 파일을 수정해야 함
//그래서 어댑터 객체 밖에서 리스너를 설정하고 설정된 리스너 쪽으로 이벤트를 전달 받도록 한다.
interface OnSongItemClickListener {

    //onitemClick 메소드가 호출 될 때 파라미터도 뷰홀더 객체와 뷰 객체, 뷰의 포지션 값이 전달 된다.
    //position -> 몇 번째 아이템인지 구분할 수 있는 인덱스 값
    fun onItemClick(holder: SongAdapter.ViewHolder?, view: View?, position: Int)
}