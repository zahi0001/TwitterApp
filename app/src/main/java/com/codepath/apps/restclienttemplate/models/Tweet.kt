package com.codepath.apps.restclienttemplate.models

import org.json.JSONArray
import org.json.JSONObject

class Tweet {

    var body: String = ""
    var createdAt : String = ""
    var timeStamp: String =""
    var user: User? = null

    companion object {
        fun fromJson (jsonObject: JSONObject): Tweet {
            val tweet = Tweet()

            tweet.body = jsonObject.getString("text")
            tweet.createdAt = jsonObject.getString("created_at")
            tweet.timeStamp = getFormattedTimestamp(tweet.createdAt)
            tweet.user = User.fromJson(jsonObject.getJSONObject("user"))
            return tweet
        }

        fun fromJsonArray (jsonArray: JSONArray): List <Tweet> {
            val tweets = ArrayList<Tweet> ()

            for (i in 0 until jsonArray.length()) {
                tweets.add(fromJson(jsonArray.getJSONObject(i)))
            }
            return tweets
        }

        fun getFormattedTimestamp (createdAt: String): String {
            return TimeFormatter.getTimeDifference(createdAt)
        }
    }

}