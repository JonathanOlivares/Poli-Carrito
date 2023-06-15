package com.myaplication.policarrito


import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.widget.SearchView
import android.os.Bundle



class SearchbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchbar)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val searchViewMenuItem = toolbar.menu.findItem(R.id.action_search)
        val searchView = searchViewMenuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Aquí puedes manejar la acción cuando el usuario presione "Enter" o envíe la consulta de búsqueda.
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Aquí puedes manejar la acción cuando el texto de búsqueda cambie en tiempo real.
                return true
            }
        })
    }
}