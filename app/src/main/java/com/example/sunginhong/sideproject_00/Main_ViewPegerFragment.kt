package com.example.sunginhong.sideproject_00

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class Main_ViewPegerFragment : Fragment() {
    private var mCount: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mCount = arguments.getString(ARG_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle
    ): View? {
        return inflater.inflate(R.layout.mainvp_fragment, container, false)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            activity.title = "count : " + mCount!!
        }
    }

    companion object {
        private val ARG_COUNT = "count"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String): Main_ViewPegerFragment {
            val fragment = Main_ViewPegerFragment()
            val args = Bundle()
            args.putString(ARG_COUNT, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
