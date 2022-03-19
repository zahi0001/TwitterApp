package com.codepath.apps.restclienttemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.apps.restclienttemplate.models.Tweet

class TweetsAdapter (val tweets: List<Tweet>) : RecyclerView.Adapter<TweetsAdapter.ViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // time to inflate
        val view = inflater.inflate(R.layout.item_tweet, parent, false)

        return ViewHolder(view)

    }


    // to populate the data into the item through the item view
    override fun onBindViewHolder(holder: TweetsAdapter.ViewHolder, position: Int) {
        // get the data model based on the position
        val tweet: Tweet = tweets.get(position)
        // set item views based on views and data model
        holder.tvUsername.text = tweet.user?.name
        holder.tvTweetBody.text = tweet.body
        //Glide is a library that helps in loading a lot easier
        Glide.with(holder.itemView).load(tweet.user?.publicImageUrl).into(holder.ivProfileImage)
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProfileImage = itemView.findViewById<ImageView>(R.id.ivProfileImage)
        val tvUsername = itemView.findViewById<TextView>(R.id.tvUsername)
        val tvTweetBody = itemView.findViewById<TextView>(R.id.tvTweetBody)
    }
}