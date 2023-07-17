package com.example.ylearn.aiSing

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MySingleton private constructor(private var context: Context) {
    private var requestQueue: RequestQueue?

    init {
        requestQueue = getRequestQueue()
    }

    fun getRequestQueue(): RequestQueue {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext())
        }
        return requestQueue as RequestQueue
    }

    fun <T> addToRequestQueue(req: Request<T>?) {
        getRequestQueue().add(req)
    }

    companion object {
        private var instance: MySingleton? = null
        @Synchronized
        fun getInstance(context: Context): MySingleton? {
            if (instance == null) {
                instance = MySingleton(context)
            }
            return instance
        }
    }
}