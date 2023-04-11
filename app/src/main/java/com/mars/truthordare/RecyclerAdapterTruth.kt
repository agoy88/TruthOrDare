package com.mars.truthordare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterTruth : RecyclerView.Adapter<RecyclerAdapterTruth.ViewHolder>() {

    private var detailsQuestion = arrayOf(
        "Apakah anda pernah menyimpan sampah terlebih dahulu sampai menemukan tempat sampah untuk membuang sampah tersebut?",
        "Apakah anda pernah melakukan 3 langkah (Reduce, Reuse, Recycle) pengelolaan sampah?",
        "Kapan terakhir kamu buang sampah sembarangan?",
        "Apakah anda pernah terlibat dalam pengelolaan sampah di lingkungan setempat?",
        "Momen paling memalukan apa yang pernah kamu alami dengan sampah",
        "Kalau kamu bisa memilih sampah organik, mau buang sampah kotoran hewan atau buang makanan basi ?",
        "Apa saja barang yang tidak ramah lingkungan pernah kamu beli ?",
        "Kenangan apa yang pernah membekas dalam ingatan mu tentang sampah ?",
        "Berapa lama kamu pernah menyimpan sampah di saku",
        "Kalau disuruh memilih, kamu mau jadi sampah organik atau anorganik? alasannya",
        " Pengakuan dosa, kamu pernah membuang sampah di selokan atau sungai ?",
        "Kapan terakhir kali kamu minum memakai sedotan",
        "Tiga hal yang kita tidak ketahui tentang dosa kamu pada lingkungan",
        "First impression kamu tentang inovasi ramah lingkungan",
        "Apa yang kita nggak tau pernah terjadi di antara kamu dan sampah",
        "Apa saja barang ramah lingkungan yang pernah kamu beli ? dan efek atau manfaatnya untuk lingkungan ?",
        "Ada berapakah tumbler yang selama ini pernah kamu gunakan?",
        "Apa yang kamu pikirkan tentang orang yang membuang sampah sembarangan",
        "Apakah anda mengetahui hari lingkungan hidup sedunia"
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemQuestion: TextView

        init {
            itemQuestion = itemView.findViewById(R.id.tv_truth_question)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_card_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemQuestion.text = detailsQuestion[position]

    }

    override fun getItemCount(): Int {
        return detailsQuestion.size

    }
}