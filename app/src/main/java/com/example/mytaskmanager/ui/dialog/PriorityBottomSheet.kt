package com.example.taskease.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import com.example.taskease.R
import com.example.taskease.databinding.BottomSheetPriorityBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class PriorityBottomSheet(
    private val context: Context,
    private val onPrioritySelected: (String) -> Unit
) {
    fun open(selectedPriority: String = "") {
        val binding = BottomSheetPriorityBinding.inflate(LayoutInflater.from(context))
        val dialog = BottomSheetDialog(context)
        dialog.setContentView(binding.root)

        // Highlight the currently selected priority
        highlightSelectedPriority(binding, selectedPriority)

        // Set up click listeners
        binding.cardHigh.setOnClickListener {
            onPrioritySelected(context.getString(R.string.high))
            dialog.dismiss()
        }

        binding.cardMedium.setOnClickListener {
            onPrioritySelected(context.getString(R.string.medium))
            dialog.dismiss()
        }

        binding.cardLow.setOnClickListener {
            onPrioritySelected(context.getString(R.string.low))
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun highlightSelectedPriority(
        binding: BottomSheetPriorityBinding,
        selectedPriority: String
    ) {
        // Reset all backgrounds
        val all = listOf(binding.tvHigh, binding.tvMedium, binding.tvLow)
        all.forEach { it.setBackgroundResource(android.R.color.transparent) }

        // Highlight the selected priority
        when (selectedPriority) {
            context.getString(R.string.high) -> binding.tvHigh.setBackgroundResource(android.R.color.darker_gray)
            context.getString(R.string.medium) -> binding.tvMedium.setBackgroundResource(android.R.color.darker_gray)
            context.getString(R.string.low) -> binding.tvLow.setBackgroundResource(android.R.color.darker_gray)
        }
    }
}