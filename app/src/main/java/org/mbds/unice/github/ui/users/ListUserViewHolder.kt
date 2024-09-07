package org.mbds.unice.github.ui.users

import android.graphics.Color
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.mbds.unice.github.R
import org.mbds.unice.github.data.model.User
import coil.load

import org.mbds.unice.github.databinding.ItemListUserBinding


class ListUserViewHolder(private val binding: ItemListUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User, callback: UserListAdapter.Listener) {
        binding.itemListUserUsername.text = user.login

        // Charger l'image avec Coil
        binding.itemListUserAvatar.load(user.avatarUrl) {
            crossfade(true)
          //  placeholder(R.drawable.placeholder_avatar) // Optionnel, placeholder
          //  error(R.drawable.error_avatar) // Optionnel, image d'erreur
        }

        // Changer l'icône et la couleur d'arrière-plan en fonction de l'état
        binding.itemListUserDeleteButton.setImageResource(
            if (user.isActive) R.drawable.ic_delete_black_24dp else R.drawable.ic_restore_black_24dp
        )

        binding.root.setBackgroundColor(
            if (user.isActive) Color.WHITE else Color.RED
        )

        // Gestion du clic sur le bouton delete
        binding.itemListUserDeleteButton.setOnClickListener {
            callback.onClickDelete(user)
        }
    }
}



