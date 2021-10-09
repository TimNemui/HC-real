package com.NguyenBower.hc

sealed class Screens(val route:String){
    object MainScreen:Screens("main_screen")
    object ListScreen:Screens("list_screen")
    object InfoScreen:Screens("info_screen")

}
