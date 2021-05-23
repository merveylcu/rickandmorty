package com.merveylcu.rickandmorty.ui.character.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.merveylcu.rickandmorty.R
import com.merveylcu.rickandmorty.data.model.character.Character
import com.merveylcu.rickandmorty.databinding.ItemCharacterBinding
import com.merveylcu.rickandmorty.util.listener.OnItemClickListener

class CharacterListAdapter(
    val characterList: ArrayList<Character>,
    val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val binding: ItemCharacterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_character, parent, false
        )
        return CharacterListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class CharacterListViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val item = characterList[position]
            binding.character = item
            binding.onItemClickListener = onItemClickListener
        }
    }
}