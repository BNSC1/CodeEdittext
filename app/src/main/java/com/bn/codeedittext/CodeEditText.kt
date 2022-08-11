package com.bn.codeedittext

import android.content.Context
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.util.AttributeSet
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout

class CodeEditText(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    var codeLength = 0
        set(value) {
            field = value
            refreshEditTexts()
        }
    var allowAlphabet = false
        set(value) {
            field = value
            refreshEditTexts()
        }

    private val editTexts = mutableListOf<EditText>()

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CodeEditText,
            0, 0
        ).apply {
            try {
                codeLength = getInteger(R.styleable.CodeEditText_codeLength, 0)
                allowAlphabet = getBoolean(R.styleable.CodeEditText_allowAlphabets, false)
            } finally {
                recycle()
            }
        }
    }

    private fun refreshEditTexts() = editTexts.let {
        if (it.isNotEmpty()) {
            it.clear()
            this@CodeEditText.removeAllViews()
        }
        for (i in 0 until codeLength) {
            it.add(EditText(context).apply {
                layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
                inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
                keyListener = DigitsKeyListener.getInstance(
                    if (allowAlphabet) {
                        ALLOWED_ALPHABETS + ALLOWED_NUMBERS
                    } else ALLOWED_NUMBERS
                )
                this@CodeEditText.addView(this)
            })
        }
    }

    companion object {
        private const val ALLOWED_ALPHABETS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        private const val ALLOWED_NUMBERS = "0123456789"
    }
}