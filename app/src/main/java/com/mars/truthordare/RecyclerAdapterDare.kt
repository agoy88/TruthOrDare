package com.mars.truthordare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterDare : RecyclerView.Adapter<RecyclerAdapterDare.ViewHolder>() {

    private var detailsQuestion = arrayOf(
        "Memilah sampah disekitar saya",
        "Posting snapgram saat saya membuang sampah pada tempatnya",
        "Posting snapgram mengenai pengakuan perilaku saya yang mencerminkan ketidakpedulian ",
        "dengan lingkungan bersamaan dengan komitmen saya untuk tidak mengulanginya lagi",
        "Cari sampah plastik di sekitarmu dan buang sampah plastik kepada tempatnya",
        "Buang puntung rokok orang tidak dikenal ke dalam tempatnya ",
        "Cari orang yang membuang sampah sembarangan dan berikan edukasi membuang dengan benar",
        "Sebutkan perilaku-perilaku yang pernah anda lakukan dalam rangka menjaga lingkungan sekitar anda",
        "Buatlah lagu singkat mengenai environmental awareness",
        "Posting video edukasi mengenai 3R di sosial media yang kamu miliki",
        "Buatlah puisi tentang Environmental Awareness",
        "Coba tirukan salah satu tren mengenai Environmental awareness yang ada di social media",
        "Buatlah konten tiktok mengenai environmental awareness"
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemQuestion: TextView

        init {
            itemQuestion = itemView.findViewById(R.id.tv_truth_question)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_card_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemQuestion.text = detailsQuestion[position]

    }

    override fun getItemCount(): Int {
        return detailsQuestion.size

    }
}