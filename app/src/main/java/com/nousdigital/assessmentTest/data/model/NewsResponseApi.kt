package com.nousdigital.assessmentTest.data.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/*
 * Project Name : News
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :09-05-2020 
 * File Name : NewsResponseApi.kt
 * ClassName : NewsResponseApi
 * Module Name : app
 * Desc : data class.
 */

data class News(
    @SerializedName("items")
    val items: List<Item> = listOf()
)

data class Item(
    @SerializedName("description")
    val description: String = "", // Nach einer nächtlichen Surfsession an der Welle im Münchner Eisbach wird Mikesch Opfer einer Messerattacke. Er überlebt schwer verletzt. Mikesch war Anfang der 80er-Jahre ein enger Freund von Leitmayr. Gemeinsam mit der Holländerin Frida verbrachten sie einen aufregenden Sommer zu dritt am Strand des portugiesischen Fischerorts Nazaré. Kurz darauf brach Franz den Kontakt zu beiden wortlos ab. Als er jetzt, Jahrzehnte später, wieder auf Mikesch trifft, ist plötzlich die ganze Vergangenheit wieder nah.
    @SerializedName("id")
    val id: Int = 0, // 14014907
    @SerializedName("imageUrl")
    val imageUrl: String = "", // https://cloud.nousdigital.net/s/rezXHE6qGXGFHSd/preview
    @SerializedName("title")
    val title: String = "" // Die ewige Welle
) :Serializable
