package com.example.sunginhong.sideproject_00.Model_User_Json

import com.example.sunginhong.sideproject_00.Model_User.Main_Exp_User
import java.util.*

class Exp_UsersData {

    val usersList: List<Main_Exp_User> = object : ArrayList<Main_Exp_User>() {
        init {
            add(Main_Exp_User("00", "https://cdn.dribbble.com/users/2782989/screenshots/5719605/image.png", "TYPE-A"))
            add(Main_Exp_User("01", "https://cdn.dribbble.com/users/2782989/screenshots/5719605/image.png", "TYPE-A"))
            add(Main_Exp_User("02", "https://cdn.dribbble.com/users/2782989/screenshots/5719605/image.png", "TYPE-A"))
            add(Main_Exp_User("03", "https://cdn.dribbble.com/users/2782989/screenshots/5719605/image.png", "TYPE-A"))
            add(Main_Exp_User("04", "https://cdn.dribbble.com/users/2782989/screenshots/5719605/image.png", "TYPE-A"))
            add(Main_Exp_User("05", "https://cdn.dribbble.com/users/678989/screenshots/4508258/illu_character.png", "TYPE-B"))
            add(Main_Exp_User("06", "https://cdn.dribbble.com/users/678989/screenshots/4508258/illu_character.png", "TYPE-B"))
            add(Main_Exp_User("07", "https://cdn.dribbble.com/users/678989/screenshots/4508258/illu_character.png", "TYPE-B"))
            add(Main_Exp_User("08", "https://cdn.dribbble.com/users/678989/screenshots/4508258/illu_character.png", "TYPE-B"))
            add(Main_Exp_User("09", "https://cdn.dribbble.com/users/678989/screenshots/4508258/illu_character.png", "TYPE-B"))
            add(Main_Exp_User("10", "https://cdn.dribbble.com/users/77598/screenshots/3090904/illu_fox_dribbble.jpg", "TYPE-C"))
            add(Main_Exp_User("11", "https://cdn.dribbble.com/users/77598/screenshots/3090904/illu_fox_dribbble.jpg", "TYPE-C"))
            add(Main_Exp_User("12", "https://cdn.dribbble.com/users/77598/screenshots/3090904/illu_fox_dribbble.jpg", "TYPE-C"))
            add(Main_Exp_User("13", "https://cdn.dribbble.com/users/77598/screenshots/3090904/illu_fox_dribbble.jpg", "TYPE-C"))
            add(Main_Exp_User("14", "https://cdn.dribbble.com/users/77598/screenshots/3090904/illu_fox_dribbble.jpg", "TYPE-C"))
            add(Main_Exp_User("15", "https://cdn.dribbble.com/users/1162650/screenshots/4135719/dad-2.gif", "TYPE-D"))
            add(Main_Exp_User("16", "https://cdn.dribbble.com/users/1162650/screenshots/4135719/dad-2.gif", "TYPE-D"))
            add(Main_Exp_User("17", "https://cdn.dribbble.com/users/1162650/screenshots/4135719/dad-2.gif", "TYPE-D"))
            add(Main_Exp_User("18", "https://cdn.dribbble.com/users/1162650/screenshots/4135719/dad-2.gif", "TYPE-D"))
        }
    }

    val userTypeList: List<String> = object : ArrayList<String>() {
        init {
            add("TYPE-A")
            add("TYPE-B")
            add("TYPE-C")
            add("TYPE-D")
        }
    }
}
