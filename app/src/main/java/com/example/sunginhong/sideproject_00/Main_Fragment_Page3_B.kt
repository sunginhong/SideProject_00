//package com.example.sunginhong.sideproject_00
//
//import android.os.Bundle
//import android.support.v4.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.sunginhong.sideproject_00.Test.Test_Exp_ListCustomAdapter
//import com.example.sunginhong.sideproject_00.Test.Test_Exp_Prototype_myGroup
//import kotlinx.android.synthetic.main.main_fragment_page3.*
//
//@Suppress("UNREACHABLE_CODE")
//class Main_Fragment_Page3_B : Fragment() {
//    var lastClickedPosition = 0
//    companion object {
//    }
//
//    fun newInstance(): Main_Fragment_Page3 {
//        val args = Bundle()
//
//        val frag = Main_Fragment_Page3()
//        frag.arguments = args
//
//        return frag
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        return inflater!!.inflate(R.layout.main_fragment_page3, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        init()
//    }
//
//    private fun init(){
//        val ctx = context ?: return
//
//        val DataList = ArrayList<Test_Exp_Prototype_myGroup>()
//
//        var temp = Test_Exp_Prototype_myGroup("[Title] A")
//        temp.childExp.add("A-0")
//        temp.childExp.add("A-1")
//        temp.childExp.add("A-2")
//        temp.childExp.add("A-3")
//        temp.childExp.add("A-4")
//        temp.childExp.add("A-5")
//        DataList.add(temp)
//
//        temp = Test_Exp_Prototype_myGroup("[Title] B")
//        temp.childExp.add("B-0")
//        temp.childExp.add("B-1")
//        temp.childExp.add("B-2")
//        temp.childExp.add("B-3")
//        temp.childExp.add("B-4")
//        temp.childExp.add("B-5")
//        DataList.add(temp)
//
//        temp = Test_Exp_Prototype_myGroup("[Title] C")
//        temp.childExp.add("C-0")
//        temp.childExp.add("C-1")
//        temp.childExp.add("C-2")
//        DataList.add(temp)
//
//        val adapter = Test_Exp_ListCustomAdapter(
//            ctx,
//            R.layout.test_exp_row_main,
//            R.layout.test_exp_row_child,
//            DataList
//        )
////        main_protoList.setIndicatorBounds(MainActivity.screenWidth - 50, MainActivity.screenWidth)
//        main_protoList.setAdapter(adapter)
//
//        main_protoList.setOnGroupClickListener { parent, v, groupPosition, id ->
//            // Listener 에서 Adapter 사용법 (getExpandableListAdapter 사용해야함.)
//            // BaseExpandableAdpater에 오버라이드 된 함수들을 사용할 수 있다.
//            val groupCount = parent.expandableListAdapter.groupCount
//            val childCount = parent.expandableListAdapter.getChildrenCount(groupPosition)
//
//            val isExpand = !main_protoList.isGroupExpanded(groupPosition)
//
//            // 이 전에 열려있던 group 닫기
////            main_protoList.collapseGroup(lastClickedPosition)
//
//            if (isExpand) {
//                main_protoList.expandGroup(groupPosition)
//            } else {
//                main_protoList.collapseGroup(groupPosition)
//            }
//
//            lastClickedPosition = groupPosition
//
//            true
//        }
//
//        // 차일드 클릭 했을 경우 이벤트
//        main_protoList.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
//            false
//        }
//        // 그룹이 닫힐 경우 이벤트
//        main_protoList.setOnGroupCollapseListener { }
//    }
//
//
//}