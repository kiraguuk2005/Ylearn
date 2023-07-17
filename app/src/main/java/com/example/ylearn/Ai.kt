package com.example.ylearn

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.example.ylearn.adapter.ChatsAdapter
import com.example.ylearn.aiSing.MySingleton
import com.example.ylearn.databinding.ActivityAiBinding
import com.example.ylearn.model.chatModel.ChatModel
import com.example.ylearn.model.chatModel.ChatType
import org.json.JSONException
import org.json.JSONObject

class Ai : AppCompatActivity() {

    private lateinit var binding: ActivityAiBinding
    private var chats = arrayListOf<ChatModel>()
    private lateinit var chatsAdapter: ChatsAdapter

    private var apiUrl = "https://api.openai.com/v1/completions"
    private var accessToken = "API KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAiBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()

        binding.btnSend.setOnClickListener(View.OnClickListener { callAPI() })


    }

    private fun callAPI() {
        val text: String = binding.mEditText.getText().toString()
        chats.add(ChatModel(text, ChatType.MINE))
        chatsAdapter.notifyItemInserted(chats.size - 1)
        binding.mEditText.getText()?.clear()
        val requestBody = JSONObject()

        try {
            requestBody.put("model", "text-davinci-003")
            requestBody.put("prompt", text)
            requestBody.put("max_tokens", 1000)
            requestBody.put("temperature", 1)
            requestBody.put("top_p", 1)
            requestBody.put("frequency_penalty", 0.0)
            requestBody.put("presence_penalty", 0.0)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val request: JsonObjectRequest = object : JsonObjectRequest(
            Method.POST, apiUrl, requestBody,
            Response.Listener<JSONObject> { response ->
                try {
                    val choicesArray = response.getJSONArray("choices")
                    val choiceObject = choicesArray.getJSONObject(0)
                    val text = choiceObject.getString("text")
                    Log.e("API Response", response.toString())
                    //Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
                    chats.add(
                        ChatModel(
                            text.replaceFirst("\n".toRegex(), "").replaceFirst("\n".toRegex(), ""),
                            ChatType.OTHER
                        )
                    )
                    chatsAdapter.notifyItemInserted(chats.size - 1)

                    binding.chatsRecyclerview.apply {
                        adapter = chatsAdapter

                        try {
                            smoothScrollToPosition(chats.size - 1)
                        } catch (e: Exception) {

                            e.message

                        }
                    }


                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error -> Log.e("API Error", error.toString()) }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers: MutableMap<String, String> = HashMap()
                headers["Authorization"] = "Bearer " + accessToken
                headers["Content-Type"] = "application/json"
                return headers
            }

            override fun parseNetworkResponse(response: NetworkResponse): Response<JSONObject> {
                return super.parseNetworkResponse(response)
            }
        }
        val timeoutMs = 25000 // 25 seconds timeout
        val policy: RetryPolicy = DefaultRetryPolicy(
            timeoutMs,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        request.retryPolicy = policy
        // Add the request to the RequestQueue
        MySingleton.getInstance(this)?.addToRequestQueue(request)
    }


    private fun initRecyclerView() {
        chatsAdapter = ChatsAdapter(chats)
        chatsAdapter.notifyDataSetChanged()

        binding.chatsRecyclerview.apply {
            adapter = chatsAdapter
            try {
                smoothScrollToPosition(chats.size - 1)
            } catch (e: Exception) {
                e.message
            }
        }
    }
}
