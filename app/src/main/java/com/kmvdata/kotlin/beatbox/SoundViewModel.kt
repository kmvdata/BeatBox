package com.kmvdata.kotlin.beatbox

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

private const val TAG = "SoundViewModel"

class SoundViewModel(private val beatBox: BeatBox) : BaseObservable() {

    var sound: Sound? = null
        set(sound) {
            field = sound
            notifyChange()
        }

    @get:Bindable
    val title: String?
        get() = sound?.name

    fun onButtonClick() {
        Log.d(TAG, "SoundViewModel::onButtonClick() called for ${title}")
        sound?.let {
            beatBox.play(it)
        }
    }
}
