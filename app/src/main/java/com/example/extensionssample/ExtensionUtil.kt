package com.example.extensionssample

import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*

object ExtensionUtil {

    // Region View
    fun View.toInvisible() {
        visibility = View.INVISIBLE
    }

    fun View.toGone() {
        visibility = View.GONE
    }

    fun View.toVisible() {
        visibility = View.VISIBLE
    }

    fun View.setVisible(isVisible: Boolean) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    fun View.setHeight(height: Int) {
        layoutParams?.height = height
    }

    fun View.setWidth(width: Int) {
        layoutParams?.width = width
    }

    fun View.setMarginStart(marginStart: Int) {
        val param = layoutParams as ViewGroup.MarginLayoutParams?
        param?.marginStart = marginStart
    }

    fun View.setMarginEnd(marginEnd: Int) {
        val param = layoutParams as ViewGroup.MarginLayoutParams?
        param?.marginEnd = marginEnd
    }

    fun View.setTopMargin(topMargin: Int) {
        val param = layoutParams as ViewGroup.MarginLayoutParams?
        param?.topMargin = topMargin
    }

    fun View.setBottomMargin(bottomMargin: Int) {
        val param = layoutParams as ViewGroup.MarginLayoutParams?
        param?.bottomMargin = bottomMargin
    }

    fun View.setBackgroundColorRes(@ColorRes colorRes: Int) =
        setBackgroundColor(ContextCompat.getColor(context, colorRes))
    // End Region View


    // Region TextView
    fun TextView.setTextColorRes(@ColorRes colorRes: Int) =
        setTextColor(ContextCompat.getColor(context, colorRes))

    fun TextView.setClickableSpan(
        text: String,
        clickableText: String,
        clickAction: (() -> Unit)? = null,
        @ColorRes colorRes: Int = android.R.color.holo_blue_dark,
    ) {
        val spannableString = SpannableString(text)
        val clickableSpan = object : ClickableSpan() {

            override fun updateDrawState(textPaint: TextPaint) {
                // use this to change the link color
                textPaint.color = ContextCompat.getColor(this@setClickableSpan.context, colorRes)
            }

            override fun onClick(view: View) {
                clickAction?.invoke()
            }
        }
        val startIndexOfLink = text.indexOf(clickableText)
        spannableString.setSpan(
            clickableSpan,
            startIndexOfLink,
            startIndexOfLink + clickableText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        this.movementMethod =
            LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
        this.setText(spannableString, TextView.BufferType.SPANNABLE)
    }

    // End Region TextView


    // Region Date
    fun Date.format(format: String): String {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        return simpleDateFormat.format(this)
    }

    fun String.parseDate(format: String): Date? {
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        return simpleDateFormat.parse(format)
    }
// End Region Date

    // Region SpannableString
    fun SpannableString.setColor(color: String, start: Int, end: Int): SpannableString {
        this.setSpan(ForegroundColorSpan(Color.parseColor(color)), start, end, 0)
        return this
    }

    fun SpannableString.setStyleBold(start: Int, end: Int): SpannableString {
        this.setSpan(StyleSpan(Typeface.BOLD), start, end, 0)
        return this
    }

    fun SpannableString.setStyleNormal(start: Int, end: Int): SpannableString {
        this.setSpan(StyleSpan(Typeface.NORMAL), start, end, 0)
        return this
    }

    fun SpannableString.setStyleBoldItalic(start: Int, end: Int): SpannableString {
        this.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, end, 0)
        return this
    }

    fun SpannableString.setStyleItalic(start: Int, end: Int): SpannableString {
        this.setSpan(StyleSpan(Typeface.ITALIC), start, end, 0)
        return this
    }

    fun SpannableString.setUnderline(start: Int, end: Int): SpannableString {
        this.setSpan(UnderlineSpan(), start, end, 0)
        return this
    }

    fun SpannableString.setStrike(start: Int, end: Int): SpannableString {
        this.setSpan(StrikethroughSpan(), start, end, 0)
        return this
    }
// End Region SpannableString
}