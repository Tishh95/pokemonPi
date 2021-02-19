package com.projet.poke.Model

class Pokemon {

    var id:Int=0
    var num: String?=null
    var name: String?=null
    var img: String?=null
    var height: String?=null
    var weight: String?=null
    var candy: String?=null
    var egg: String?=null
    var type:List<String>?=null
    var next_evolution:List<Evolution>?=null
    var prev_evolution:List<Evolution>?=null
}
