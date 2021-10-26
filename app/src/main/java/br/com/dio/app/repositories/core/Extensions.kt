package br.com.dio.app.repositories.core

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import br.com.dio.app.repositories.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

//Getter and setter text in TextInputLayout
var TextInputLayout.text: String
    get() = editText?.text?.toString() ?: ""
    set(value) {
        editText?.setText(value)
    }

//Hide the keyboard
fun View.hideSoftKeyboard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

//Create Material Alert Dialog Builder
fun Context.createDialog(block: MaterialAlertDialogBuilder.() -> Unit = {}): AlertDialog {
    val builder = MaterialAlertDialogBuilder(this)
    builder.setPositiveButton(android.R.string.ok, null)
    block(builder)
    return builder.create()
}

//Create progress dialog
fun Context.createProgressDialog(): AlertDialog {
    return createDialog {
        val padding = this@createProgressDialog.resources.getDimensionPixelOffset(R.dimen.layout_padding)
        val progressBar = ProgressBar(this@createProgressDialog)
        progressBar.setPadding(padding, padding, padding, padding)
        setView(progressBar)

        setPositiveButton(null, null)
        setCancelable(false)
    }
}