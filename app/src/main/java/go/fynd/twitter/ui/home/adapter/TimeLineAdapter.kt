package go.fynd.twitter.ui.home.adapter

import android.net.Uri
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.ContentLoadingProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import go.fynd.twitter.R
import go.fynd.twitter.model.tweet.TweetsBean
import java.text.SimpleDateFormat
import java.util.*


class TimeLineAdapter(var mList: MutableList<TweetsBean>) :
    RecyclerView.Adapter<BaseViewHolder>() {
    var selectedPosition = 0
    private val VIEW_TYPE_LOADING = 0
    private val VIEW_TYPE_NORMAL = 1
    private var isLoaderVisible = false
    var df = SimpleDateFormat("EEE MMM dd hh:mm:ss Z yyyy", Locale.ENGLISH)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            VIEW_TYPE_LOADING -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.row_loading,
                    parent,
                    false
                )
                return ProgressVH(view)
            }
            VIEW_TYPE_NORMAL -> {
                return TimeLineVH(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.row_tweet,
                        parent,
                        false
                    )
                )
            }
            else -> return ProgressVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.row_loading,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        if (mList.isEmpty()) {
            return 0
        }
        return mList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onbind(position)
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoaderVisible) {
            if (position == mList.size - 1) VIEW_TYPE_LOADING else VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    fun removeLoading() {
        isLoaderVisible = false
        val position = mList.size - 1
        mList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addLoading() {
        isLoaderVisible = true
        mList.add(TweetsBean())
        notifyItemInserted(mList.size - 1)
    }

    fun addItems(postItems: MutableList<TweetsBean>?) {
        removeLoading()
        mList.addAll(postItems!!)
        notifyDataSetChanged()
    }

    fun addAll(postItems: MutableList<TweetsBean>?) {
        mList.clear()
        mList.addAll(postItems!!)
        notifyDataSetChanged()
    }

    /**
     * ViewHolder for TimeLine
     * */
    inner class TimeLineVH(itemView: View) : BaseViewHolder(itemView) {
        var img_profile: SimpleDraweeView
        var tv_user_name: TextView
        var tv_user_id: TextView
        var tv_time: TextView
        var tv_tweet: TextView
        var img_tweet: SimpleDraweeView
        var img_share: ImageView
        var tv_share: TextView
        var img_retweet: ImageView
        var tv_retweet: TextView
        var img_star: ImageView
        var tv_star: TextView
        var img_options: ImageView

        init {
            itemView.setOnClickListener {
                setOnItemClick(adapterPosition)
            }
            img_profile = itemView.findViewById(R.id.img_profile)
            tv_user_name = itemView.findViewById(R.id.tv_user_name)
            tv_user_id = itemView.findViewById(R.id.tv_user_id)
            tv_time = itemView.findViewById(R.id.tv_time)
            tv_tweet = itemView.findViewById(R.id.tv_tweet)
            img_tweet = itemView.findViewById(R.id.img_tweet)
            img_share = itemView.findViewById(R.id.img_share)
            tv_share = itemView.findViewById(R.id.tv_share)
            img_retweet = itemView.findViewById(R.id.img_retweet)
            tv_retweet = itemView.findViewById(R.id.tv_retweet)
            img_star = itemView.findViewById(R.id.img_star)
            tv_star = itemView.findViewById(R.id.tv_star)
            img_options = itemView.findViewById(R.id.img_options)

        }

        private fun setOnItemClick(adapterPosition: Int) {
            selectedPosition = adapterPosition
        }

        override fun onbind(position: Int) {
            super.onbind(position)
            val tweet = mList[position]
            if (tweet.text != null && tweet.text.length > 0) {
                tv_tweet.text = tweet.text
                tv_user_name.text = tweet.user?.name
                tv_user_id.text = "@" + tweet.user?.screenName
                tv_retweet.text = tweet.retweetCount.toString()
                tv_star.text = tweet.favoriteCount.toString()
                tv_share.text = (10 until 80).random().toString()
                if (position % 5 == 0) {
                    img_tweet.visibility = VISIBLE
                    img_tweet.setImageURI(
                        Uri.parse(tweet.user?.profileBackgroundImageUrl),
                        itemView.context
                    )
                } else {
                    img_tweet.visibility = GONE
                }
                img_profile.setImageURI(
                    Uri.parse(tweet.user?.profileImageUrl),
                    itemView.context
                )
                tv_time.text = DateUtils.getRelativeTimeSpanString(
                    df.parse(tweet.createdAt).time,
                    System.currentTimeMillis(),
                    DateUtils.SECOND_IN_MILLIS
                )
            }
        }
    }

    /**
     * ViewHolder for Progressbar
     * */
    inner class ProgressVH(itemView: View) : BaseViewHolder(itemView) {

        var progress_bar: ContentLoadingProgressBar

        init {
            progress_bar = itemView.findViewById(R.id.progress_bar)
        }
    }
}