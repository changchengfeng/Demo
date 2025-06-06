package top.greatfeng.base.ext

import android.content.Context
import top.greatfeng.base.app.BaseApplication
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Preference<T>(val context: Context,val default: T, val prefName: String = "configs")
    : ReadWriteProperty<Any?, T>{

    private val prefs by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(findProperName(property))
    }

    private fun findProperName(property: KProperty<*>) =  property.name

    private fun findPreference(key: String): T{
        return when(default){
            is Boolean -> prefs.getBoolean(key, default)
            is Int -> prefs.getInt(key, default)
            is Long -> prefs.getLong(key, default)
            is Float -> prefs.getFloat(key, default)
            is String -> prefs.getString(key, default)
            else -> throw IllegalArgumentException("Unsupported type.")
        } as T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
         putPreference(findProperName(property), value)
    }

    private fun putPreference(key: String, value: T){
        with(prefs.edit()){
            when(value){
                is Boolean -> putBoolean(key, value)
                is Int -> putInt(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                is String -> putString(key, value)
                else -> throw IllegalArgumentException("Unsupported type")
            }
        }.apply()
    }

}

inline fun <reified R, T> R.pref(default: T) = Preference(BaseApplication.getContext(), default, R::class.java.name)