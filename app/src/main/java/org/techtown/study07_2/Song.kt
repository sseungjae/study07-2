package org.techtown.study07_2

//각 아이템의 데이터를 담아둘 클래스를 정의해야한다.
//정의된 클래스로부터 만들어진 아이템 객체들을 어댑터 안에 담을 수 있다.
//title과 singer를 정의한다.
//title과 singer는 String 값을 받는다.
data class Song(val title: String?, val singer: String?)