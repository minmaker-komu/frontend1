package com.egg.everylogg.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.egg.everylogg.R
import com.egg.everylogg.util.ListViewItem

class ListViewAdapter: BaseAdapter() {
    //adapter에 추가된 데이터를 저장하기 위한 arraylist
    private var listViewItemList=ArrayList<ListViewItem>()

    //adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    override fun getCount():Int{
        return listViewItemList.size
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 view를 리턴. : 필수 구현
    override fun getView(position:Int, convertView: View?, parent: ViewGroup): View {
        var view=convertView
        val context=parent.context

        if(view==null){
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view =inflater.inflate(R.layout.study_listview_item,parent,false)
        }

        //화면에 표시될 view로부터 위젯에 대한 참조 획득
        val iconImageView=view!!.findViewById(R.id.studyitemThumbnail) as ImageView
        val titleTextView=view.findViewById(R.id.studyitemTitle) as TextView
        val descTextView=view.findViewById(R.id.studyitemtag) as TextView

        //data set에서 position에 위치한 데이터 참조 획득
        val listViewItem=listViewItemList[position]

        //아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.iconDrawable)
        titleTextView.setText(listViewItem.titleStr)
        descTextView.setText(listViewItem.descStr)

        return view
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    override fun getItem(position: Int): Any {
        return listViewItemList[position]
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    fun addItem(icon: Drawable, title: String, desc: String) {
        val item = ListViewItem()

        item.iconDrawable=icon
        item.titleStr=title
        item.descStr=desc

        listViewItemList.add(item)
    }
}