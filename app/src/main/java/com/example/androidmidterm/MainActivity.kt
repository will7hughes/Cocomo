package com.example.androidmidterm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androidmidterm.Constants.Companion.baseUrl
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)


        // API Post request with JsonObjectRequest
        basicBtn.setOnClickListener {
            if (isValidInput())
                handleBasicCocomoRequest(queue)
            else
                responseLabel.text = Constants.invalidInputResponse
        }

        intermediateBtn.setOnClickListener {
            if (isValidInput())
                handleIntermediateCocomoRequest(queue)
            else
                responseLabel.text = Constants.invalidInputResponse
        }
    }

    private fun isValidInput(): Boolean
    {
        if (teamSizeInput.text.isNullOrEmpty() || klocInput.text.isNullOrEmpty())
            return false
        return true
    }

    private fun handleBasicCocomoRequest(queue: RequestQueue)
    {
        val url = "$baseUrl/basic"

        val postParameters = getPostParameters()

        sendRequest(
            queue,
            url,
            postParameters,
            Response.Listener { response ->

                val responseMsg = "" +
                    "The mode is ${response.getString("mode")} " +
                    "with a required staff size of ${response.getString("staff_required")}, " +
                    "effort of %.2f, and ".format(response.getDouble("effort")) +
                    "development time of %.2f months".format(response.getDouble("development_time")) +
                    "".trimIndent()

                responseLabel.text = responseMsg
            }
        )
    }

    private fun handleIntermediateCocomoRequest(queue: RequestQueue)
    {
        val url = "$baseUrl/intermediate"

        val postParameters = getPostParameters()

        sendRequest(
            queue,
            url,
            postParameters,
            Response.Listener { response ->

                val responseMsg = "" +
                    "The mode is ${response.getString("mode")} " +
                    "with max effort of %.2f ".format(response.getDouble("max_effort")) +
                    "mean effort of %.2f, and ".format(response.getDouble("mean_effort")) +
                    "minimum effort of %.2f".format(response.getDouble("min_effort")) +
                    "".trimIndent()

                responseLabel.text = responseMsg
            }
        )
    }

    private fun getPostParameters(): JSONObject
    {
        val postParameters = JSONObject()
        try {
            val teamSize: Int = teamSizeInput.text.toString().toInt()
            val kloc: Int = klocInput.text.toString().toInt()

            postParameters.put("team_size", teamSize)
            postParameters.put("kloc", kloc)

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return postParameters
    }

    private fun sendRequest(queue: RequestQueue, url: String, postParameters: JSONObject, response: Response.Listener<JSONObject>)
    {
        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            postParameters,
            response,
            // The same way we get the response info from a successful API call we can get error info
            Response.ErrorListener { error ->
                val responseMsg = "Error calling API. ${error.message} \n\nSometimes you must send multiple requests for it to go through properly. Try sending the request a couple more times..."
                responseLabel.text = responseMsg
            }
        )

        queue.add(request)
    }
}

/*
References
https://github.com/CodyStandridge/AndroidMidTerm
https://kotlinlang.org/docs/tutorials/kotlin-for-py/declaring-variables.html
https://medium.com/mindorks/lambda-function-in-kotlin-22ded595298
 */