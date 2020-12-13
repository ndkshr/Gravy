package com.instance.gravy.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.google.android.material.snackbar.Snackbar


fun Activity.hideSoftKeyboard() {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val focus = currentFocus
    if (focus != null) {
        inputMethodManager.hideSoftInputFromWindow(focus.windowToken, 0)
    } else {
        inputMethodManager.hideSoftInputFromWindow(View(this).windowToken, 0)
    }
}

fun Activity.showSoftKeyboard(editText: EditText?) {
    val inputMethodManager =
        this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    editText?.requestFocus()
    inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
}

fun <T : ViewDataBinding> Activity.setDataBindingView(layoutId: Int): T =
    DataBindingUtil.setContentView(this, layoutId)

/**
 * Run block inside Observer
 */
fun <T> LiveData<T>.observe(owner: LifecycleOwner, block: (T?) -> Unit) =
    observe(owner, Observer { block(it) })

/**
 * Create viewmodel for activity
 */
inline fun <reified T : ViewModel> AppCompatActivity.createViewModel(viewModelFactory: ViewModelProvider.Factory): T =
    androidx.lifecycle.ViewModelProviders.of(this, viewModelFactory)[T::class.java]

/**
 * Property to access resource in ViewModel
 */
val AndroidViewModel.resources: Resources
    get() = getApplication<Application>().resources

fun AppCompatActivity.replaceFragment(
    layoutId: Int,
    fragmentName: String,
    tag: String,
    args: Bundle? = null
) {
    val fragment = Fragment.instantiate(this, fragmentName)
    args?.let { fragment.arguments = it }
    supportFragmentManager
        .beginTransaction()
        .replace(layoutId, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun AppCompatActivity.replaceFragment(
    fragment: Fragment, layoutId: Int,
    addToBackStack: Boolean = false, backStackName: String = ""
) {
    with(supportFragmentManager.beginTransaction()) {
        replace(layoutId, fragment)
        if (addToBackStack) {
            addToBackStack(backStackName)
        }
        commitAllowingStateLoss()
    }
}

fun Activity.getVectorDrawable(drawableId: Int): VectorDrawableCompat? =
    VectorDrawableCompat.create(resources, drawableId, null)

fun Activity.shortSnackbar(@StringRes message: Int) =
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()

fun AppCompatActivity.addFragment(
    layoutId: Int,
    fragmentName: String,
    tag: String,
    args: Bundle? = null
) {
    val fragment = Fragment.instantiate(this, fragmentName)
    args?.let { fragment.arguments = it }
    supportFragmentManager
        .beginTransaction()
        .add(layoutId, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun AppCompatActivity.fragmentBackPress() {
    if (supportFragmentManager.backStackEntryCount > 1) {
        supportFragmentManager.popBackStack()
    } else {
        finish()
    }
}
