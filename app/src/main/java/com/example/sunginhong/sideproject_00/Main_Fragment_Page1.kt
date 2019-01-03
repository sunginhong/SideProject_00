package com.example.sunginhong.sideproject_00

import android.app.Fragment
import android.content.ContentValues
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.sunginhong.sideproject_00.Model_User.Main_User
import com.example.sunginhong.sideproject_00.Model_User_Json.MainUserList_Min00
import com.example.sunginhong.sideproject_00.Utils_Folder.RequestHttpURLConnection
import kotlinx.android.synthetic.main.main_fragment_page1.*
import org.json.JSONArray
import org.json.JSONException

class Main_Fragment_Page1 : Fragment(){

    val values_Fragment_Page1 = ArrayList<Main_User>()
    val values_Fragment_Page1_rv_Json = ArrayList<Array<String>>()
    val values_Fragment_Page1_vp_Json = ArrayList<Array<String>>()

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.main_fragment_page1, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init (){
        val ctx = context ?: return

        val vp_Url = MainActivity.URL_JSON+"data_page.json"
        val vp_networkTask = vp_NetworkTask(vp_Url, null)
        vp_networkTask.execute()

        val rv_Url = MainActivity.URL_JSON+"data_library.json"
        val rv_networkTask = rv_NetworkTask(rv_Url, null)
        rv_networkTask.execute()
    }

    inner class vp_NetworkTask(private val url: String, private val values: ContentValues?) :
        AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void): String {
            val result: String // 요청 결과를 저장할 변수.
            val requestHttpURLConnection = RequestHttpURLConnection()
            result = requestHttpURLConnection.request(url, values)!! // 해당 URL로 부터 결과물을 얻어온다.

            return result
        }

        override fun onPostExecute(s: String) {
            super.onPostExecute(s)
            vp_doJSONParser(s)
        }
    }

    inner class rv_NetworkTask(private val url: String, private val values: ContentValues?) :
        AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void): String {
            val result: String // 요청 결과를 저장할 변수.
            val requestHttpURLConnection = RequestHttpURLConnection()
            result = requestHttpURLConnection.request(url, values)!! // 해당 URL로 부터 결과물을 얻어온다.

            return result
        }

        override fun onPostExecute(s: String) {
            super.onPostExecute(s)
            rv_doJSONParser(s)
        }
    }

    fun vp_doJSONParser(s: String) {
        try {
            val jarray = JSONArray(s)   // JSONArray 생성
            val ctx = context ?: return

            for (i in 0 until jarray.length()) {
                val jObject = jarray.getJSONObject(i)  // JSONObject 추출
                val title = jObject.getString("title")
                val subtitle = jObject.getString("subtitle")
                val thumbImg = jObject.getString("img")

                values_Fragment_Page1_vp_Json.add(arrayOf(title, subtitle, thumbImg))
                val mAdapter = Main_ViewPagerAdapter_Page1(ctx, values_Fragment_Page1_vp_Json)
                vp.setAdapter(mAdapter)
                vp.setClipToPadding(false)
                vp.setPageMargin(0)
                vp.setOffscreenPageLimit(MainUserList_Min00.size)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    fun rv_doJSONParser(s: String) {
        try {
            val jarray = JSONArray(s)   // JSONArray 생성
            val ctx = context ?: return

            for (i in 0 until jarray.length()) {
                val jObject = jarray.getJSONObject(i)  // JSONObject 추출
                val title = jObject.getString("title")
                val subtitle = jObject.getString("subtitle")
                val thumbImg = jObject.getString("img")

                values_Fragment_Page1_rv_Json.add(arrayOf(title, subtitle, thumbImg))
                recyclerView_page1.layoutManager = LinearLayoutManager(ctx, LinearLayout.VERTICAL, false)
                recyclerView_page1.setHasFixedSize(true)
                recyclerView_page1.adapter = Main_RecyclerViewAdapter_Page1(ctx, values_Fragment_Page1_rv_Json)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

}